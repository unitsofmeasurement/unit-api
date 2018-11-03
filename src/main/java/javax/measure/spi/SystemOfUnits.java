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

import java.util.Set;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * A system of units grouped together for historical or cultural reasons.<br>
 * Common system of units are "SI" (System International), "Imperial" (British), "US" (US Customary). Nothing prevents a unit from belonging to
 * several systems of units at the same time (for example an {@code Imperial} system would have many of the units held by the {@code US} Customary
 * system).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 1.1, June 21, 2018
 * @since 1.0
 *
 * @see <a href="http://en.wikipedia.org/wiki/International_System_of_Units"> Wikipedia: International System of Units</a>
 * @see <a href="http://en.wikipedia.org/wiki/Systems_of_measurement"> Wikipedia: System of measurement</a>
 */
public interface SystemOfUnits {

    /**
     * @return a name
     */
    String getName();

    /**
     * Returns the default unit for the specified quantity or {@code null} if none is defined for the given quantity in this unit system.
     *
     * @param <Q>
     *          the compile-time quantity type.
     * @param quantityType
     *          the quantity type.
     * @return the unit for the specified quantity.
     */
    <Q extends Quantity<Q>> Unit<Q> getUnit(Class<Q> quantityType);

    /**
     * Returns a unit with the given {@linkplain String string} representation or {@code null} if none is found in this unit system.
     *
     * @param string
     *          the string representation of a unit, not {@code null}.
     * @return the unit with the given string representation.
     * @since 2.0
     */
    Unit<?> getUnit(String string);

    /**
     * Returns a read only view over the units explicitly defined by this system. This include the base and derived units which are assigned a special
     * name and symbol. This set does not include new units created by arithmetic or other operations.
     *
     * @return the defined collection of units.
     */
    Set<? extends Unit<?>> getUnits();

    /**
     * Returns the units defined in this system having the specified dimension (convenience method).
     *
     * @param dimension
     *          the dimension of the units to be returned.
     * @return the collection of units of specified dimension.
     */
    Set<? extends Unit<?>> getUnits(Dimension dimension);
}
