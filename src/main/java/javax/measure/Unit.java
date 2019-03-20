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
//
// This source code implements specifications defined by the Java
// Community Process. In order to remain compliant with the specification
// DO NOT add / change / or delete method signatures!
//
package javax.measure;

import java.util.Map;

/**
 * Represents a determinate {@linkplain Quantity quantity} (as of length, time, heat, or value) adopted as a standard of measurement.
 *
 * <p>
 * It is helpful to think of instances of this class as recording the history by which they are created. Thus, for example, the string {@code "g/kg"}
 * (which is a dimensionless unit) would result from invoking the method {@link #toString()} on a unit that was created by dividing a gram unit by a
 * kilogram unit.
 * </p>
 *
 * <p>
 * This interface supports the multiplication of offsets units. The result is usually a unit not convertible to its {@linkplain #getSystemUnit()
 * system unit}. Such units may appear in derivative quantities. For example Celsius per meter is an unit of gradient, which is common in atmospheric
 * and oceanographic research.
 * </p>
 *
 * <p>
 * Units raised at non-integral powers are not supported. For example, {@code LITRE.root(2)} raises an {@code ArithmeticException}, but
 * {@code HECTARE.root(2)} returns {@code HECTOMETRE} (100 metres).
 * </p>
 *
 * <p>
 * Unit instances shall be immutable.
 * </p>
 *
 * @param <Q>
 *          The type of the quantity measured by this unit.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:steve@unidata.ucar.edu">Steve Emmerson</a>
 * @author <a href="mailto:martin.desruisseaux@geomatys.com">Martin Desruisseaux</a>
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 1.3, March 20, 2019
 * @since 1.0
 *
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement">Wikipedia: Units of measurement</a>
 */
public interface Unit<Q extends Quantity<Q>> {

    /*******************/
    /** Units Queries **/
    /*******************/

    /**
     * Returns the symbol (if any) of this unit. This method returns {@code null} if this unit has no specific symbol associated with.
     *
     * @return this unit symbol, or {@code null} if this unit has not specific symbol associated with (e.g. product of units).
     *
     * @see #toString()
     * @see javax.measure.format.UnitFormat
     */
    String getSymbol();

    /**
     * Returns the name (if any) of this unit. This method returns {@code null} if this unit has no specific name associated with.
     *
     * @return this unit name, or {@code null} if this unit has not specific name associated with (e.g. product of units).
     *
     * @see #toString()
     * @see javax.measure.format.UnitFormat
     */
    String getName();

    /**
     * Returns the dimension of this unit. Two units {@code u1} and {@code u2} are {@linkplain #isCompatible(Unit) compatible} if and only if
     * {@code u1.getDimension().equals(u2.getDimension())}.
     *
     * @return the dimension of this unit.
     *
     * @see #isCompatible(Unit)
     */
    Dimension getDimension();

    /**
     * Returns the unscaled system unit from which this unit is derived. System units are either base units, {@linkplain #alternate(String) alternate}
     * units or product of rational powers of system units.
     *
     * <p>
     * Because the system unit is unique by quantity type, it can be be used to identify the quantity given the unit. For example:
     * </p>
     * <code>
     *     static boolean isAngularSpeed(Unit&lt;?&gt; unit) {<br>
     *     &nbsp;&nbsp;    return unit.getSystemUnit().equals(RADIAN.divide(SECOND));<br>
     *     }<br>
     *     assert isAngularSpeed(REVOLUTION.divide(MINUTE)); // Returns true.<br><br>
     * </code>
     *
     * @return the system unit this unit is derived from, or {@code this} if this unit is a system unit.
     */
    Unit<Q> getSystemUnit();

    /**
     * Returns the base units and their exponent whose product is this unit, or {@code null} if this unit is a base unit (not a product of existing
     * units).
     *
     * @return the base units and their exponent making up this unit.
     */
    Map<? extends Unit<?>, Integer> getBaseUnits();

    /**
     * Indicates if this unit is compatible with the unit specified. Units don't need to be equals to be compatible. For example (assuming {@code ONE}
     * is a dimensionless unit):
     *
     * <code>
     *     RADIAN.equals(ONE) == false<br>
     *     RADIAN.isCompatible(ONE) == true<br>
     * </code>
     *
     * @param that
     *          the other unit to compare for compatibility.
     * @return {@code this.getDimension().equals(that.getDimension())}
     *
     * @see #getDimension()
     */
    boolean isCompatible(Unit<?> that);

    /**
     * Casts this unit to a parameterized unit of specified nature or throw a {@code ClassCastException} if the dimension of the specified quantity and
     * this unit's dimension do not match. For example:
     *
     * <code>
     *      {@literal Unit<Speed>} C = METRE.multiply(299792458).divide(SECOND).asType(Speed.class);
     * </code>
     *
     * @param <T>
     *          The type of the quantity measured by the unit.
     * @param type
     *          the quantity class identifying the nature of the unit.
     * @return this unit parameterized with the specified type.
     * @throws ClassCastException
     *           if the dimension of this unit is different from the specified quantity dimension.
     */
    <T extends Quantity<T>> Unit<T> asType(Class<T> type) throws ClassCastException;

    /**
     * Returns a converter of numeric values from this unit to another unit of same type. This method performs the same work as
     * {@link #getConverterToAny(Unit)} without raising checked exception.
     *
     * @param that
     *          the unit of same type to which to convert the numeric values.
     * @return the converter from this unit to {@code that} unit.
     * @throws UnconvertibleException
     *           if a converter cannot be constructed.
     *
     * @see #getConverterToAny(Unit)
     */
    UnitConverter getConverterTo(Unit<Q> that) throws UnconvertibleException;

    /**
     * Returns a converter from this unit to the specified unit of type unknown. This method can be used when the quantity type of the specified unit is
     * unknown at compile-time or when dimensional analysis allows for conversion between units of different type.
     *
     * <p>
     * To convert to a unit having the same parameterized type, {@link #getConverterTo(Unit)} is preferred (no checked exception raised).
     * </p>
     *
     * @param that
     *          the unit to which to convert the numeric values.
     * @return the converter from this unit to {@code that} unit.
     * @throws IncommensurableException
     *           if this unit is not {@linkplain #isCompatible(Unit) compatible} with {@code that} unit.
     * @throws UnconvertibleException
     *           if a converter cannot be constructed.
     *
     * @see #getConverterTo(Unit)
     * @see #isCompatible(Unit)
     */
    UnitConverter getConverterToAny(Unit<?> that) throws IncommensurableException, UnconvertibleException;

    /**********************/
    /** Units Operations **/
    /**********************/

    /**
     * Returns a system unit equivalent to this unscaled standard unit but used in expressions to distinguish between quantities of a different nature
     * but of the same dimensions.
     *
     * <p>
     * Examples of alternate units:
     * </p>
     *
     * <code>
     *     {@literal Unit<Angle>} RADIAN = ONE.alternate("rad").asType(Angle.class);<br>
     *     {@literal Unit<Force>} NEWTON = METRE.multiply(KILOGRAM).divide(SECOND.pow(2)).alternate("N").asType(Force.class);<br>
     *     {@literal Unit<Pressure>} PASCAL = NEWTON.divide(METRE.pow(2)).alternate("Pa").asType(Pressure.class);<br>
     * </code>
     *
     * @param symbol
     *          the new symbol for the alternate unit.
     * @return the alternate unit.
     * @throws UnsupportedOperationException
     *           if this unit is not an unscaled standard unit.
     * @throws IllegalArgumentException
     *           if the specified symbol is not valid or is already associated to a different unit.
     */
    Unit<Q> alternate(String symbol);

    /**
     * Returns the result of setting the origin of the scale of measurement to the given value. The returned unit is convertible with all units that are
     * convertible with this unit. For example the following code:
     *
     * <code>
     *    CELSIUS = KELVIN.shift(273.15);
     * </code>
     *
     * creates a new unit where 0°C (the origin of the new unit) is equals to 273.15 K. Converting from the old unit to the new one is equivalent to
     * <em>subtracting</em> the offset to the value in the old unit.
     *
     * @param offset
     *          the offset added (expressed in this unit).
     * @return this unit offset by the specified value.
     */
    Unit<Q> shift(double offset);

    /**
     * Returns the result of multiplying this unit by the specified factor. If the factor is an integer value, the multiplication is exact
     * (recommended). For example:
     *
     * <code>
     *    FOOT = METRE.multiply(3048).divide(10000); // Exact definition.
     *    ELECTRON_MASS = KILOGRAM.multiply(9.10938188e-31); // Approximation.
     * </code>
     *
     * @param multiplier
     *          the multiplier
     * @return this unit scaled by the specified multiplier.
     */
    Unit<Q> multiply(double multiplier);

    /**
     * Returns the product of this unit with the one specified.
     *
     * @param multiplier
     *          the unit multiplier.
     * @return {@code this * multiplier}
     */
    Unit<?> multiply(Unit<?> multiplier);

    /**
     * Returns the reciprocal (multiplicative inverse) of this unit.
     *
     * @return {@code 1 / this}
     * @see <a href="https://en.wikipedia.org/wiki/Multiplicative_inverse">Wikipedia: Multiplicative inverse</a>
     */
    Unit<?> inverse();

    /**
     * Returns the result of dividing this unit by an approximate divisor. If the factor is an integer value, the division is exact. For example:
     *
     * <code>
     *    GRAM = KILOGRAM.divide(1000); // Exact definition.
     * </code>
     *
     * @param divisor
     *          the divisor value.
     * @return this unit divided by the specified divisor.
     */
    Unit<Q> divide(double divisor);

    /**
     * Returns the quotient of this unit with the one specified.
     *
     * @param divisor
     *          the unit divisor.
     * @return {@code this / divisor}
     */
    Unit<?> divide(Unit<?> divisor);

    /**
     * Returns an unit that is the n-th (integer) root of this unit. Equivalent to the mathematical expression {@code unit^(1/n)}.
     *
     * @param n
     *          an integer giving the root's order as in 'n-th root'
     * @return the n-th root of this unit.
     * @throws ArithmeticException
     *           if {@code n == 0} or if this operation would result in an unit with a fractional exponent.
     */
    Unit<?> root(int n);

    /**
     * Returns an unit raised to the n-th (integer) power of this unit. Equivalent to the mathematical expression {@code unit^n}.
     *
     * @param n
     *          the exponent.
     * @return the result of raising this unit to the exponent.
     */
    Unit<?> pow(int n);

    /**
     * Returns the unit derived from this unit using the specified converter. The converter does not need to be linear. For example:<br>
     *
     * <pre>
     *     {@literal Unit<Dimensionless>} DECIBEL = Unit.ONE.transform(
     *         new LogConverter(10).inverse().concatenate(
     *             new RationalConverter(1, 10)));
     * </pre>
     *
     * @param operation
     *          the converter from the transformed unit to this unit.
     * @return the unit after the specified transformation.
     */
    Unit<Q> transform(UnitConverter operation);

    /**
     * Returns a string representation of this unit. The string representation may be the unit {@linkplain #getSymbol() symbol}, or may be some
     * representation of {@linkplain #getBaseUnits() product units}, multiplication factor and offset if any.
     *
     * <p>
     * The string may be localized at implementation choice by the means of a particular device and platform.
     * </p>
     *
     * @return the string representation of this unit.
     *
     * @see #getSymbol()
     * @see javax.measure.format.UnitFormat
     */
    @Override
    String toString();

    /**
     * Returns a new unit equal to this unit prefixed by the specified {@code prefix}.
     *
     * @param prefix
     *          the prefix to apply on this unit.
     * @return the unit with the given prefix applied.
     * @since 2.0
     */
    Unit<Q> prefix(Prefix prefix);
    
    /**
     * Returns the combination of this unit with the specified unit. Mixed
     * units are typically used for formatting purpose. Examples of mixed
     * units:<code> 
     *     Unit<Length> FOOT_INCH = FOOT.mix(INCH);
     *     Unit<Time> HOUR_MINUTE_SECOND = HOUR.mix(MINUTE).mix(SECOND);
     * </code>
     * 
     * @param that
     *            the other unit to mix with this unit.
     * @return the corresponding mixed unit.
     * @since 2.0
     */
    Unit<Q> mix(Unit<Q> that);
}
