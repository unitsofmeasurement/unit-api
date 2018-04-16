/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import java.util.Collection;
import java.util.Set;

/**
 * This interface represents the service to obtain a {@link SystemOfUnits system of units}.
 *
 * <p>
 * Common systems of units are "SI" (System International), "Imperial" (British), or "US" (US Customary).
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:martin.desruisseaux@geomatys.com">Martin Desruisseaux</a>
 * @version 1.3, April 12, 2018
 * @since 1.0
 *
 * @see <a href="http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia: International System of Units</a>
 */
public interface SystemOfUnitsService {

  /**
   * Returns the default {@link SystemOfUnits system of units}. Depending on the implementation this may be the <a
   * href="http://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a> or another default system.
   *
   * @return the default system of units.
   */
  SystemOfUnits getSystemOfUnits();

  /**
   * Returns the system of units having the specified name or <code>null</code> if none.
   *
   * @param name
   *          the system of unit name.
   * @return the given system of units.
   */
  SystemOfUnits getSystemOfUnits(String name);

  /**
   * Gets a list with available systems for this {@link SystemOfUnitsService}.
   *
   * @return list of available systems of units, never null.
   */
  Collection<SystemOfUnits> getAvailableSystemsOfUnits();

  /**
   * Returns a {@link Set} containing the values of a particular {@link Prefix} type.<br>
   * This method may be used to iterate over the prefixes as follows:
   *
   * <pre>
   * <code>
   *    for(Prefix p : service.getPrefixes(PrefixType.class))
   *        System.out.println(p);
   * </code>
   * </pre>
   *
   * @param prefixType
   *          the {@link Prefix} type
   * @return a set containing the constant values of this Prefix type, in the order they're declared
   * @throws ClassCastException
   *           if the class is not compatible with the desired Prefix implementation.
   * @since 2.0
   */
  Set<Prefix> getPrefixes(Class<? extends Prefix> prefixType);
}
