/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ServiceLoader;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class implements the (default) {@link ServiceProvider} interface and hereby uses the JDK
 * {@link java.util.ServiceLoader} to load the services required.
 *
 * @author Werner Keil
 */
class DefaultServiceProvider implements ServiceProvider {
    /** List of services loaded, per class. */
    private final ConcurrentHashMap<Class, List<Object>> servicesLoaded = new ConcurrentHashMap<Class, List<Object>>();
    // TODO does this work in CLDC8?
//    @Override
    public int getPriority() {
        return 0;
    }

    /**
     * Loads and registers services.
     *
     * @param serviceType
     *            The service type.
     * @param <T>
     *            the concrete type.
     * @return the items found, never {@code null}.
     */
//    @Override
    public <T> List<T> getServices(final Class<T> serviceType) {
        @SuppressWarnings("unchecked")
        List<T> found = (List<T>) servicesLoaded.get(serviceType);
        if (found != null) {
            return found;
        }

        return loadServices(serviceType);
    }

//    @Override
    public <T> T getService(Class<T> serviceType) {
        List<T> servicesFound = getServices(serviceType);
        if(servicesFound.isEmpty()){
            return null;
        }
        return servicesFound.get(0);
    }

    /**
     * Loads and registers services.
     *
     * @param   serviceType  The service type.
     * @param   <T>          the concrete type.
     *
     * @return  the items found, never {@code null}.
     */
    private <T> List<T> loadServices(final Class<T> serviceType) {
        List<T> services = new ArrayList<T>();
        try {
            for (T t : ServiceLoader.load(serviceType)) {
                services.add(t);
            }
            @SuppressWarnings("unchecked")
            final List<T> previousServices = (List<T>) servicesLoaded.putIfAbsent(serviceType, (List<Object>) services);
            return Collections.unmodifiableList(previousServices != null ? previousServices : services);
        } catch (Exception e) {
            Logger.getLogger(DefaultServiceProvider.class.getName()).log(Level.WARNING,
                                                                         "Error loading services of type " + serviceType, e);
            return services;
        }
    }

}
