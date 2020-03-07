/*
 * Units of Measurement API
 * Copyright (c) 2014-2019, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
import java.util.EnumSet;
import java.util.Set;
import javax.measure.Prefix;

/**
 * This interface represents the service to obtain a {@link SystemOfUnits system
 * of units}.
 *
 * <p>
 * Common systems of units are "SI" (System International) or Metric system,
 * "Imperial" (British), or "US" (US Customary).
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:martin.desruisseaux@geomatys.com">Martin
 *         Desruisseaux</a>
 * @version 1.7, October 7, 2018
 * @since 1.0
 *
 * @see <a href=
 *      "http://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia:
 *      International System of Units</a>
 */
public interface SystemOfUnitsService {

    /**
     * Returns the default {@link SystemOfUnits system of units}. Depending on the
     * implementation this may be the <a href="http://en.wikipedia.org/wiki/International_System_of_Units">International
     * System of Units</a> or another default system.
     *
     * @return the default system of units.
     */
    SystemOfUnits getSystemOfUnits();

    /**
     * Returns the system of units having the specified name or {@code null} if
     * none is found.
     *
     * @param name the system of unit name.
     * @return the system of units for the given name.
     */
    SystemOfUnits getSystemOfUnits(String name);

    /**
     * Gets a list with available systems for this {@link SystemOfUnitsService}.
     *
     * @return list of available systems of units, never null.
     */
    Collection<SystemOfUnits> getAvailableSystemsOfUnits();

    /**
     * Returns a {@link Set} containing the values of a particular {@link Prefix}
     * type.
     *
     * <p>
     * This method may be used to iterate over certain prefixes as follows:
     * </p>
     * <pre>{@code
     *    for(MetricPrefix mp : service.getPrefixes(MetricPrefix.class))
     *        System.out.println(p);
     * }</pre>
     *
     * The default implementation assumes that prefixes of the given type are implemented as an enumeration.
     * This is the case of the two default prefix implementations provided in JSR 385,
     * namely {@link javax.measure.MetricPrefix} and {@link javax.measure.BinaryPrefix}.
     * Implementors shall override this method if they provide prefixes implemented in a different way.
     *
     * @param <P> compile-time value of the {@code prefixType} argument
     * @param prefixType the {@link Prefix} type
     * @return a set containing the constant values of this Prefix type, in the
     *         order they're declared
     * @throws ClassCastException if the class is not compatible with the desired
     *                            Prefix implementation or does not implement Prefix at all.
     * @since 2.0
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    default <P extends Prefix> Set<P> getPrefixes(Class<P> prefixType) {
        // Following check is redundant with parameterized type but nevertheless applied as a safety.
        if (Prefix.class.isAssignableFrom(prefixType)) {
            EnumSet<? extends Enum<?>> prefixes = EnumSet.allOf(prefixType.asSubclass(Enum.class));
            /*
             * Following unchecked cast is safe for read operations because the given class implements
             * 'prefixType' in addition of being an enumeration.  It is also safe for write operations
             * because all enumerations are closed universes (so users can not add an instance unknown
             * to EnumSet) and we would have got an exception before this point if 'prefixType' was not
             * an enumeration in the sense of Class.isEnum().
             */
            return (EnumSet) prefixes;
        } else {
            throw new ClassCastException(String.format("%s does not implement Prefix", prefixType));
            // TODO or should we throw a different exception here, MeasurementException or IllegalArgumentException?
        }
    }
}
