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
package javax.measure.test;

import static java.util.logging.Level.WARNING;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceLoader;
import java.util.logging.Logger;

import javax.measure.spi.ServiceProvider;

/**
 * This class implements the {@link ServiceProvider} interface and hereby uses the JDK {@link java.util.ServiceLoader} to load the services required.
 *
 * @author Werner Keil
 * @version 0.3
 */
public class TestServiceProvider implements ServiceProvider {
  /** List of services loaded, per class. */
  @SuppressWarnings("rawtypes")
  private final Map<Class, List<Object>> servicesLoaded = new HashMap<Class, List<Object>>();

  public int getPriority() {
    return 10;
  }

  /**
   * Loads and registers services.
   *
   * @param serviceType
   *          The service type.
   * @param <T>
   *          the concrete type.
   * @return the items found, never {@code null}.
   */
  public <T> List<T> getServices(final Class<T> serviceType) {
    @SuppressWarnings("unchecked")
    List<T> found = (List<T>) servicesLoaded.get(serviceType);
    if (found != null) {
      return found;
    }

    return loadServices(serviceType);
  }

  public <T> T getService(Class<T> serviceType) {
    List<T> servicesFound = getServices(serviceType);
    if (servicesFound.isEmpty()) {
      return null;
    }
    return servicesFound.get(0);
  }

  /**
   * Loads and registers services.
   *
   * @param serviceType
   *          The service type.
   * @param <T>
   *          the concrete type.
   *
   * @return the items found, never {@code null}.
   */
  @SuppressWarnings("unchecked")
  private <T> List<T> loadServices(final Class<T> serviceType) {
    final List<T> services = new ArrayList<T>();
    try {
      for (T t : ServiceLoader.load(serviceType)) {
        services.add(t);
      }
      final List<T> previousServices = (List<T>) servicesLoaded.put(serviceType, (List<Object>) services);
      return list(previousServices != null ? previousServices.iterator() : services.iterator());
    } catch (Exception e) {
      Logger.getLogger(TestServiceProvider.class.getName()).log(WARNING, "Error loading services of type " + serviceType, e);
      return services;
    }
  }

  @Override
  public int compareTo(ServiceProvider o) {
    return compare(getPriority(), o.getPriority());
  }

  /**
   * Compares two {@code int} values numerically. The value returned is identical to what would be returned by:
   * 
   * <pre>
   * Integer.valueOf(x).compareTo(Integer.valueOf(y))
   * </pre>
   *
   * @param x
   *          the first {@code int} to compare
   * @param y
   *          the second {@code int} to compare
   * @return the value {@code 0} if {@code x == y}; a value less than {@code 0} if {@code x < y}; and a value greater than {@code 0} if {@code x > y}
   */
  private static int compare(int x, int y) {
    return (x < y) ? -1 : ((x == y) ? 0 : 1);
  }

  /**
   * Returns an array list containing the elements returned by the specified iterator in the order they are returned by the enumeration. This method
   * provides interoperability between legacy APIs that return enumerations and new APIs that require collections.
   *
   * @param e
   *          enumeration providing elements for the returned array list
   * @return an array list containing the elements returned by the specified enumeration.
   * @since 1.4
   * @see Enumeration
   * @see ArrayList
   */
  private static <T> ArrayList<T> list(Iterator<T> i) {
    ArrayList<T> l = new ArrayList<>();
    while (i.hasNext())
      l.add(i.next());
    return l;
  }
}
