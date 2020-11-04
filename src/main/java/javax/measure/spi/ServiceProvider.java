/*
 * Units of Measurement API
 * Copyright (c) 2014-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.measure.spi;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.measure.Quantity;
import javax.measure.format.QuantityFormat;
import javax.measure.format.UnitFormat;

/**
 * Service Provider for Units of Measurement services.
 * <p>
 * All the methods in this class are safe to use by multiple concurrent threads.
 * </p>
 *
 * @version 1.7, November 4, 2020
 * @author Werner Keil
 * @author Martin Desruisseaux
 * @since 1.0
 */
public abstract class ServiceProvider {
    /**
     * Class name of JSR-330 annotation for naming a service provider.
     * We use reflection for keeping JSR-330 an optional dependency.
     */
    private static final String NAMED_ANNOTATION = "javax.inject.Named";

    /**
     * Class name of JSR-250 annotation for assigning a priority level to a service provider.
     * We use reflection for keeping JSR-250 an optional dependency.
     */
    private static final String PRIORITY_ANNOTATION = "javax.annotation.Priority";

    /**
     * The current service provider, or {@code null} if not yet determined.
     *
     * <p>Implementation Note: We do not cache a list of all service providers because that list depends
     * indirectly on the thread invoking the {@link #available()} method. More specifically, it depends
     * on the context class loader. Furthermore caching the {@code ServiceProvider}s can be a source of
     * memory leaks. See {@link ServiceLoader#load(Class)} API note for reference.</p>
     */
    private static final AtomicReference<ServiceProvider> current = new AtomicReference<>();

    /**
     * Creates a new service provider. Only to be used by subclasses.
     */
    protected ServiceProvider() {
    }

    /**
     * Allows to define a priority for a registered {@code ServiceProvider} instance.
     * When multiple providers are registered in the system, the provider with the highest priority value is taken.
     *
     * <p>If the {@value #PRIORITY_ANNOTATION} annotation (from JSR-250) is present on the {@code ServiceProvider}
     * implementation class, then that annotation is taken and this {@code getPriority()} method is ignored.
     * Otherwise – if the {@code Priority} annotation is absent – this method is used as a fallback.</p>
     *
     * @return the provider's priority (default is 0).
     */
    public int getPriority() {
        return 0;
    }

    /**
     * Returns the service to obtain a {@link SystemOfUnits}, or {@code null} if none.
     *
     * @return the service to obtain a {@link SystemOfUnits}, or {@code null}.
     */
    public abstract SystemOfUnitsService getSystemOfUnitsService();

    /**
     * Returns the service to obtain a {@link UnitFormat}, or {@code null} if none.
     *
     * @return the service to obtain a {@link UnitFormat}, or {@code null}.
     * @deprecated Use {@link #getFormatService()}. This method will be removed in a future version, it is here for backward compatibility only.
     */
    @Deprecated
    public abstract UnitFormatService getUnitFormatService();

    /**
     * Returns the service to obtain {@link UnitFormat} and {@link QuantityFormat} or {@code null} if none.
     *
     * @return the service to obtain a {@link UnitFormat} and {@link QuantityFormat}, or {@code null}.
     * @since 2.0
     */
    public abstract FormatService getFormatService();

    /**
     * Returns a factory for the given {@link Quantity} type.
     *
     * @param <Q>
     *            the type of the {@link Quantity} instances created by the factory
     * @param quantity
     *            the quantity type
     * @return the {@link QuantityFactory} for the given type
     */
    public abstract <Q extends Quantity<Q>> QuantityFactory<Q> getQuantityFactory(Class<Q> quantity);

    /**
     * A filter and a comparator for processing the stream of service providers.
     * The two tasks (filtering and sorting) are implemented by the same class,
     * but the filter task shall be used only if the name to search is non-null.
     * The comparator is used in all cases, for sorting providers with higher priority first.
     */
    private static final class Selector implements Predicate<ServiceProvider>, Comparator<ServiceProvider> {
        /**
         * The name of the provider to search, or {@code null} if no filtering by name is applied.
         */
        private final String toSearch;

        /**
         * Class of the {@value #NAMED_ANNOTATION} and {@value #PRIORITY_ANNOTATION} annotations to search,
         * or {@code null} if those classes are not on the classpath.
         */
        private Class<? extends Annotation> nameAnnotation, priorityAnnotation;

        /**
         * The {@code value()} method in the {@code *Annotation} class,
         * or {@code null} if those classes are not on the classpath.
         */
        private Method nameGetter, priorityGetter;

        /**
         * Creates a new filter and comparator for a stream of service providers.
         *
         * @param name  name of the desired service provider, or {@code null} if no filtering by name is applied.
         */
        Selector(String name) {
            toSearch = name;
            try {
                if (name != null) try {
                    nameAnnotation = Class.forName(NAMED_ANNOTATION).asSubclass(Annotation.class);
                    nameGetter = nameAnnotation.getMethod("value", (Class[]) null);
                } catch (ClassNotFoundException e) {
                    // Ignore since JSR-330 is an optional dependency.
                }
                try {
                    priorityAnnotation = Class.forName(PRIORITY_ANNOTATION).asSubclass(Annotation.class);
                    priorityGetter = priorityAnnotation.getMethod("value", (Class[]) null);
                } catch (ClassNotFoundException e) {
                    // Ignore since JSR-250 is an optional dependency.
                }
            } catch (NoSuchMethodException e) {
                // Should never happen since value() is a standard public method of those annotations.
                throw new ServiceConfigurationError("Can not get annotation value", e);
            }
        }

        /**
         * Returns {@code true} if the given service provider has the name we are looking for.
         * This method shall be invoked only if a non-null name has been specified to the constructor.
         * This method looks for the {@value #NAMED_ANNOTATION} annotation, and if none are found fallbacks on
         * {@link ServiceProvider#toString()}.
         */
        @Override
        public boolean test(ServiceProvider provider) {
            Object value = null;
            if (nameGetter != null) {
                Annotation a = provider.getClass().getAnnotation(nameAnnotation);
                if (a != null) try {
                    value = nameGetter.invoke(a, (Object[]) null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    // Should never happen since value() is a public method and should not throw exception.
                    throw new ServiceConfigurationError("Can not get annotation value", e);
                }
            }
            if (value == null) {
                value = provider.toString();
            }
            return toSearch.equals(value);
        }

        /**
         * Returns the priority of the given service provider.
         * This method looks for the {@value #PRIORITY_ANNOTATION} annotation,
         * and if none are found fallbacks on {@link ServiceProvider#getPriority()}.
         */
        private int priority(ServiceProvider provider) {
            if (priorityGetter != null) {
                Annotation a = provider.getClass().getAnnotation(priorityAnnotation);
                if (a != null) try {
                    return (Integer) priorityGetter.invoke(a, (Object[]) null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    // Should never happen since value() is a public method and should not throw exception.
                    throw new ServiceConfigurationError("Can not get annotation value", e);
                }
            }
            return provider.getPriority();
        }

        /**
         * Compares the given service providers for order based on their priority.
         * The priority of each provider is determined as documented by {@link ServiceProvider#getPriority()}.
         */
        @Override
        public int compare(final ServiceProvider p1, final ServiceProvider p2) {
            return Integer.compare(priority(p1), priority(p2));
        }

        /**
         * Gets all {@link ServiceProvider}s sorted by priority and optionally filtered by the name in this selector.
         * The list of service providers is <strong>not</strong> cached because it depends on the context class loader,
         * which itself depends on which thread is invoking this method.
         */
        private Stream<ServiceProvider> stream() {
            Stream<ServiceProvider> stream = StreamSupport.stream(ServiceLoader.load(ServiceProvider.class).spliterator(), false);
            if (toSearch != null) {
                stream = stream.filter(this);
            }
            return stream.sorted(this);
        }
    }

    /**
     * Returns the list of all service providers available for the current thread's context class loader.
     * The {@linkplain #current() current} service provider is always the first item in the returned list.
     * Other service providers after the first item may depend on the caller thread
     * (see {@linkplain ServiceLoader#load(Class) service loader API note}).
     *
     * @return all service providers available for the current thread's context class loader.
     */
    public static final List<ServiceProvider> available() {
        ArrayList<ServiceProvider> providers = new Selector(null).stream().collect(Collectors.toCollection(ArrayList::new));
        /*
         * Get the current service provider. If no provider has been set yet, set it now for
         * consistency with the contract saying that the first item is the current provider.
         */
        ServiceProvider first = current.get();
        if (first == null && !providers.isEmpty()) {
            first = setDefault(providers.get(0));
        }
        /*
         * Make sure that 'first' is the first item in the 'providers' list. If that item appears
         * somewhere else, we have to remove the second occurrence for avoiding duplicated elements.
         * We compare the classes, not the instances, because new instances may be created each time
         * this method is invoked and we have no guaranteed that implementors overrode 'equals'.
         */
setcur: if (first != null) {
            final Class<?> cf = first.getClass();
            final int size = providers.size();
            for (int i=0; i<size; i++) {
                if (cf.equals(providers.get(i).getClass())) {
                    if (i == 0) break setcur;       // No change needed (note: labeled breaks on if statements are legal).
                    providers.remove(i);
                    break;
                }
            }
            providers.add(0, first);
        }
        return providers;
    }

    /**
     * Returns the {@link ServiceProvider} with the specified name.
     * The given name must match the name of at least one service provider available in the current thread's
     * context class loader. The service provider names are the values of {@value #NAMED_ANNOTATION} annotations
     * when present, or the value of {@link #toString()} method for providers without {@code Named} annotation.
     *
     * <p>Implementors are encouraged to provide an {@code Named} annotation or to override {@link #toString()}
     * and use a unique enough name, e.g. the class name or other distinct attributes.
     * Should multiple service providers nevertheless use the same name, the one with the highest
     * {@linkplain #getPriority() priority} wins.</p>
     *
     * @param name
     *            the name of the service provider to return
     * @return the {@link ServiceProvider} with the specified name
     * @throws IllegalArgumentException
     *             if available service providers do not contain a provider with the specified name
     * @throws NullPointerException
     *             if {@code name} is null
     * @see #toString()
     * @since 2.0
     */
    public static ServiceProvider of(String name) {
        Objects.requireNonNull(name);
        Selector select = new Selector(name);
        ServiceProvider p = current.get();
        if (p != null && select.test(p)) {
            return p;
        }
        Optional<ServiceProvider> first = select.stream().findFirst();
        if (first.isPresent()) {
            return first.get();
        } else {
            throw new IllegalArgumentException("No measurement ServiceProvider " + name + " found .");
        }
    }

    /**
     * Returns the current {@link ServiceProvider}. If necessary the {@link ServiceProvider} will be lazily loaded.
     * <p>
     * If there are no providers available, an {@linkplain IllegalStateException} is thrown.
     * Otherwise the provider with the highest priority is used
     * or the one explicitly designated via {@link #setCurrent(ServiceProvider)}.
     * </p>
     *
     * @return the {@link ServiceProvider} used.
     * @throws IllegalStateException
     *             if no {@link ServiceProvider} has been found.
     * @see #getPriority()
     * @see #setCurrent(ServiceProvider)
     */
    public static final ServiceProvider current() {
        ServiceProvider p = current.get();
        if (p == null) {
            Optional<ServiceProvider> first = new Selector(null).stream().findFirst();
            if (first.isPresent()) {
                p = first.get();
            } else {
                throw new IllegalStateException("No measurement ServiceProvider found.");
            }
            p = setDefault(p);
        }
        return p;
    }

    /**
     * Sets the given provider as the current one if and only if no other provider are currently set.
     * If another provider is already set, that other provider is returned.
     *
     * @param  provider  the provider to set by default if no other provider is currently set.
     * @return the current provider, which is the specified {@code provider} if no other provider
     *         was set before this method call.
     */
    private static ServiceProvider setDefault(ServiceProvider provider) {
        while (!current.compareAndSet(null, provider)) {
            final ServiceProvider c = current.get();
            if (c != null) return c;
        }
        return provider;
    }

    /**
     * Replaces the current {@link ServiceProvider}.
     *
     * @param provider
     *            the new {@link ServiceProvider}
     * @return the replaced provider, or null.
     */
    public static final ServiceProvider setCurrent(ServiceProvider provider) {
        Objects.requireNonNull(provider);
        ServiceProvider old = current.getAndSet(provider);
        if (old != provider) {
            Logger.getLogger("javax.measure.spi").log(Level.CONFIG,
                    "Measurement ServiceProvider {1,choice,0#set to|1#replaced by} {0}.",
                    new Object[] {provider.getClass().getName(), (old == null) ? 0 : 1});
        }
        return old;
    }
}
