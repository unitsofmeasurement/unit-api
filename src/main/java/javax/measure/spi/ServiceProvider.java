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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.measure.Quantity;
import javax.measure.format.UnitFormat;

/**
 * Service Provider for Units of Measurement services.
 * <p>
 * All the methods in this class are safe for use by multiple concurrent threads.
 *
 * @version 0.9.2, June 15, 2016
 * @author Werner Keil
 * @author Martin Desruisseaux
 */
public abstract class ServiceProvider {
  /**
   * Synchronization lock for searching or setting the service providers.
   */
  private static final Object LOCK = new Object();

  /**
   * All service providers found, sorted in preference order. Array content shall never been changed after initialization; if we want to change the
   * array content, a new array shall be created.
   */
  private static volatile ServiceProvider[] providers;

  /**
   * Creates a new service provider.
   */
  protected ServiceProvider() {
  }

  /**
   * This method allows to define a priority for a registered ServiceProvider instance. When multiple providers are registered in the system the
   * provider with the highest priority value is taken.
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
   */
  public abstract UnitFormatService getUnitFormatService();

  /**
   * Return a factory for this {@link Quantity}.
   *
   * @param quantity
   *          the quantity
   * @return the {@link QuantityFactory}
   */
  public abstract <Q extends Quantity<Q>> QuantityFactory<Q> getQuantityFactory(Class<Q> quantity);

  /**
   * Gets all {@link ServiceProvider}. This method loads the provider when first needed.
   */
  private static ServiceProvider[] getProviders() {
    ServiceProvider[] p = providers;
    if (p == null) {
      synchronized (LOCK) {
        p = providers;
        if (p == null) {
          final List<ServiceProvider> loaded = new ArrayList<ServiceProvider>();
          for (ServiceProvider provider : ServiceLoader.load(ServiceProvider.class)) {
            loaded.add(provider);
          }
          p = loaded.toArray(new ServiceProvider[loaded.size()]);
          Arrays.sort(p, new Comparator<ServiceProvider>() {
            @Override
            public int compare(ServiceProvider p1, ServiceProvider p2) {
              return p2.getPriority() - p1.getPriority();
            }
          });
          providers = p; // Set only on success.
        }
      }
    }
    return p;
  }

  /**
   * Returns the list of available service providers.
   *
   * @return all available service providers.
   */
  public static List<ServiceProvider> available() {
    return Arrays.asList(getProviders()); // .clone();
  }

  /**
   * Returns the current {@link ServiceProvider}. If necessary the {@link ServiceProvider} will be lazily loaded.
   *
   * @return the {@link ServiceProvider} used.
   * @throws IllegalStateException
   *           if no {@link ServiceProvider} has been found.
   */
  public static ServiceProvider current() {
    ServiceProvider[] p = getProviders();
    if (p.length != 0) {
      return p[0];
    }
    throw new IllegalStateException("No measurement ServiceProvider found.");
  }

  /**
   * Replaces the current {@link ServiceProvider}.
   *
   * @param provider
   *          the new {@link ServiceProvider}
   * @return the removed provider, or null.
   */
  public static ServiceProvider setCurrent(ServiceProvider provider) {
    if (provider == null) {
      throw new NullPointerException();
    }
    synchronized (LOCK) {
      ServiceProvider[] p = getProviders();
      ServiceProvider old = (p.length != 0) ? p[0] : null;
      if (provider != old) {
        List<ServiceProvider> copy = new ArrayList<ServiceProvider>(Arrays.asList(p));
        copy.remove(provider);
        copy.add(0, provider);
        providers = copy.toArray(new ServiceProvider[copy.size()]);

        // Keep the log inside the synchronized block for making sure that the order
        // or logging messages matches the order in which ServiceProviders were set.
        Logger.getLogger("javax.measure.spi").log(Level.CONFIG,
            (old == null) ? "Measurement ServiceProvider set to {0}" : "Measurement ServiceProvider replaced by {0}", provider.getClass().getName());
      }
      return old;
    }
  }
}
