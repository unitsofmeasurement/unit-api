/*
 * Units of Measurement API
 * Copyright (c) 2014-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
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
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
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

import java.util.List;

/**
 * This class models the component to managing the lifecycle of the Unit and
 * Quantity services.
 * 
 * @author Werner Keil
 */
public interface ServiceProvider extends Comparable<ServiceProvider> {

	/**
	 * This method allows to define a priority for a registered ServiceProvider
	 * instance. When multiple providers are registered in the system the
	 * provider with the highest priority value is taken.
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
	 * @param serviceType
	 *            the service type.
	 * @return The instance, (with highest precedence) or {@code null}, if no
	 *         such service is available.
	 */
	<T> T getService(Class<T> serviceType);
}
