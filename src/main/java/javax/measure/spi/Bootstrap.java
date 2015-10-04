/*
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;

import static java.util.logging.Level.INFO;
import static java.util.logging.Level.WARNING;

import java.util.Collection;
import java.util.ServiceLoader;
import java.util.logging.Logger;

/**
 * This singleton provides access to the services available in the current runtime environment. The
 * behavior can be adapted, by calling {@link #init(ServiceProvider)} before accessing any measurement
 * services.
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, October 4, 2015
 */
public final class Bootstrap {
    /**
     * The ServiceProvider used.
     */
    private static volatile ServiceProvider serviceProviderDelegate;
    /**
     * The shared lock instance user.
     */
    private static final Object LOCK = new Object();

    /**
     * Private singleton constructor.
     */
    private Bootstrap() {
    }

    /**
     * Load the {@link ServiceProvider} to be used.
     *
     * @return {@link ServiceProvider} to be used for loading the services.
     */
    private static ServiceProvider loadDefaultServiceProvider() {
        try {
            for (ServiceProvider sp : ServiceLoader.load(ServiceProvider.class)) {
                return sp;
            }
        } catch (Exception e) {
            Logger.getLogger(Bootstrap.class.getName()).log(INFO, "No ServiceProvider loaded, using default.");
        }
        return new DefaultServiceProvider();
    }

    /**
     * Replace the current {@link ServiceProvider} in use.
     *
     * @param serviceProvider the new {@link ServiceProvider}
     * @return the removed , or null.
     */
    public static ServiceProvider init(ServiceProvider serviceProvider) {
        if (serviceProvider == null) {
        	throw new NullPointerException();
        }
        synchronized (LOCK) {
            if (Bootstrap.serviceProviderDelegate==null) {
                Bootstrap.serviceProviderDelegate = serviceProvider;
                Logger.getLogger(Bootstrap.class.getName()).log(INFO, 
                		"Measurement Bootstrap: new ServiceProvider set: " + serviceProvider.getClass().getName());
                return null;
            } else {
                ServiceProvider prevProvider = Bootstrap.serviceProviderDelegate;
                Bootstrap.serviceProviderDelegate = serviceProvider;
                Logger.getLogger(Bootstrap.class.getName()).log(WARNING, 
                		"Measurement Bootstrap: ServiceProvider replaced: " + serviceProvider.getClass().getName());
                return prevProvider;
            }
        }
    }

    /**
     * Returns the current {@link ServiceProvider}. If necessary the {@link ServiceProvider} will be lazily loaded.
     *
     * @return the {@link ServiceProvider} used.
     */
    static ServiceProvider getServiceProvider() {
        if (serviceProviderDelegate==null) {
            synchronized (LOCK) {
                if (serviceProviderDelegate==null) {
                    serviceProviderDelegate = loadDefaultServiceProvider();
                }
            }
        }
        return serviceProviderDelegate;
    }

    /**
     * Delegate method for {@link ServiceProvider#getServices(Class)}.
     *
     * @param serviceType the service type.
     * @return the services found.
     * @see ServiceProvider#getServices(Class)
     */
    public static <T> Collection<T> getServices(Class<T> serviceType) {
        return getServiceProvider().getServices(serviceType);
    }

    /**
     * Delegate method for {@link ServiceProvider#getService(Class)}.
     *
     * @param serviceType the service type.
     * @return the service found, or {@code null}.
     * @see ServiceProvider#getServices(Class)
     */
    public static <T> T getService(Class<T> serviceType) {
    	return getServiceProvider().getService(serviceType);
    }
}
