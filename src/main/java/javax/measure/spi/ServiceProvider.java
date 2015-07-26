/*
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;

import java.util.List;

/**
 * This class models the component to managing the lifecycle of the
 * Unit and Quantity services.
 * 
 * @author Werner Keil
 */
public interface ServiceProvider {

    /**
     * This method allows to define a priority for a registered ServiceProvider instance. When multiple providers are
     * registered in the system the provider with the highest priority value is taken.
     *
     * @return the provider's priority (default is 0).
     */
    public int getPriority();

    /**
     * Access a list of services, given its type. The bootstrap mechanism should
     * order the instance for precedence, hereby the most significant should be
     * first in order. If no such services are found, an empty list should be
     * returned.
     *
     * @param serviceType
     *            the service type.
     * @return The instance to be used, never {@code null}
     */
    <T> List<T> getServices(Class<T> serviceType);

    /**
     * Access a single service, given its type. The bootstrap mechanism should
     * order the instance for precedence, hereby the most significant should be
     * first in order and returned. If no such services are found, null is
     * returned.
     *
     * @param serviceType the service type.
     * @return The instance, (with highest precedence) or {@code null}, if no such service is available.
     */
    <T> T getService(Class<T> serviceType);
}
