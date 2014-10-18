/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import java.util.Map;

import javax.measure.function.UnitConverter;
import javax.measure.function.UnitTransformer;


/**
 * Represents a determinate {@linkplain Quantity quantity} (as of
 * length, time, heat, or value) adopted as a standard of measurement.
 *
 * <p>It is helpful to think of instances of this class as recording the history
 * by which they are created. Thus, for example, the string {@code "g/kg"} (which
 * is a dimensionless unit) would result from invoking the method {@link #toString()}
 * on a unit that was created by dividing a gram unit by a kilogram unit.</p>
 *
 * <p>This interface supports the multiplication of offsets units. The result is
 * usually a unit not convertible to its {@linkplain #getSystemUnit() system unit}.
 * Such units may appear in derivative quantities. For example Celsius per meter is
 * an unit of gradient, which is common in atmospheric and oceanographic research.</p>
 *
 * <p>Units raised at non-integral powers are not supported. For example,
 * {@code LITRE.root(2)} raises an {@code ArithmeticException}, but
 * {@code HECTARE.root(2)} returns {@code HECTOMETRE} (100 metres).</p>
 *
 * <p>Unit instances shall be immutable.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:steve@unidata.ucar.edu">Steve Emmerson</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.14
 *
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement">Wikipedia: Units of measurement</a>
 */
public interface Unit<Q extends Quantity<Q>> extends UnitTransformer<Q> {

    /*******************/
    /** Units Queries **/
    /*******************/

    /**
     * Returns the symbol (if any) of this unit.
     * This method returns {@code null} if this unit has no specific symbol associated with.
     *
     * @return this unit symbol, or {@code null} if this unit has not
     *         specific symbol associated with (e.g. product of units).
     *
     * @see #toString()
     * @see UnitFormat
     */
    String getSymbol();

    /**
     * Returns the name (if any) of this unit.
     * This method returns {@code null} if this unit has no specific name associated with.
     *
     * @return this unit name, or {@code null} if this unit has not
     *         specific name associated with (e.g. product of units).
     *
     * @see #toString()
     * @see UnitFormat
     */
    String getName();

    /**
     * Returns the dimension of this unit. Two units {@code u1} and {@code u2}
     * are {@linkplain #isCompatible(Unit) compatible} if and only if
     * {@code u1.getDimension().equals(u2.getDimension())}.
     *
     * @return the dimension of this unit.
     *
     * @see #isCompatible(Unit)
     */
    Dimension getDimension();

    /**
     * Returns the unscaled system unit from which this unit is derived.
     * System units are either base units, {@linkplain #alternate(String)
     * alternate} units or product of rational powers of system units.
     *
     * <p>Because the system unit is unique by quantity type, it can be
     * be used to identify the quantity given the unit. For example:</p>
     *
     * [code]
     *     static boolean isAngularSpeed(Unit<?> unit) {
     *         return unit.getSystemUnit().equals(RADIAN.divide(SECOND));
     *     }
     *     assert isAngularSpeed(REVOLUTION.divide(MINUTE)); // Returns true.
     * [/code]
     *
     * @return the system unit this unit is derived from,
     *         or {@code this} if this unit is a system unit.
     */
    Unit<Q> getSystemUnit();

    /**
     * Returns the base units and their exponent whose product is this unit,
     * or {@code null} if this unit is a base unit (not a product of existing units).
     *
     * @return the base units and their exponent making up this unit.
     */
    <T extends Quantity<T>> Map<Unit<T>, Integer> getProductUnits();

    /**
     * Indicates if this unit is compatible with the unit specified.
     * Units don't need to be equals to be compatible. For example
     * (assuming {@code ONE} is a dimensionless unit):
     *
     * [code]
     *     RADIAN.equals(ONE) == false
     *     RADIAN.isCompatible(ONE) == true
     * [/code]
     *
     * @param  that the other unit to compare for compatibility.
     * @return {@code this.getDimension().equals(that.getDimension())}
     *
     * @see #getDimension()
     */
    <T extends Quantity<T>> boolean isCompatible(Unit<T> that);

    /**
     * Casts this unit to a parameterized unit of specified nature or throw a
     * {@code ClassCastException} if the dimension of the specified quantity
     * and this unit's dimension do not match. For example:
     *
     * [code]
     *      Unit<Speed> C = METRE.times(299792458).divide(SECOND).asType(Speed.class);
     * [/code]
     *
     * @param  <T> The type of the quantity measured by the unit.
     * @param  type the quantity class identifying the nature of the unit.
     * @return this unit parameterized with the specified type.
     * @throws ClassCastException if the dimension of this unit is different
     *         from the specified quantity dimension.
     */
    <T extends Quantity<T>> Unit<T> asType(Class<T> type) throws ClassCastException;

    /**
     * Returns a converter of numeric values from this unit to another unit of same type.
     * This method performs the same work than {@link #getConverterToAny(Unit)} without
     * raising checked exception.
     *
     * @param  that the unit of same type to which to convert the numeric values.
     * @return the converter from this unit to {@code that} unit.
     * @throws UnconvertibleException if a converter cannot be constructed.
     *
     * @see #getConverterToAny(Unit)
     */
    UnitConverter getConverterTo(Unit<Q> that) throws UnconvertibleException;

    /**
     * Returns a converter from this unit to the specified unit of type unknown.
     * This method can be used when the quantity type of the specified unit
     * is unknown at compile-time or when dimensional analysis allows for
     * conversion between units of different type.
     *
     * <p>To convert to a unit having the same parameterized type,
     * {@link #getConverterTo(Unit)} is preferred (no checked exception raised).</p>
     *
     * @param  that the unit to which to convert the numeric values.
     * @return the converter from this unit to {@code that} unit.
     * @throws IncommensurableException if this unit is not
     *         {@linkplain #isCompatible(Unit) compatible} with {@code that} unit.
     * @throws UnconvertibleException if a converter cannot be constructed.
     *
     * @see #getConverterTo(Unit)
     * @see #isCompatible(Unit)
     */
    <T extends Quantity<T>> UnitConverter getConverterToAny(Unit<T> that) throws IncommensurableException,
            UnconvertibleException;

    /**********************/
    /** Units Operations **/
    /**********************/

    /**
     * Returns a system unit equivalent to this unscaled standard unit but used
     * in expressions to distinguish between quantities of a different nature
     * but of the same dimensions.
     *
     * <p>Examples of alternate units:</p>
     *
     * [code]
     *     Unit<Angle> RADIAN = ONE.alternate("rad").asType(Angle.class);
     *     Unit<Force> NEWTON = METRE.times(KILOGRAM).divide(SECOND.pow(2)).alternate("N").asType(Force.class);
     *     Unit<Pressure> PASCAL = NEWTON.divide(METRE.pow(2)).alternate("Pa").asType(Pressure.class);
     * [/code]
     *
     * @param  symbol the new symbol for the alternate unit.
     * @return the alternate unit.
     * @throws UnsupportedOperationException if this unit is not an unscaled standard unit.
     * @throws IllegalArgumentException if the specified symbol is already
     *         associated to a different unit.
     */
    Unit<Q> alternate(String symbol);

    /**
     * Returns the result of setting the origin of the scale of measurement to the given value.
     * The returned unit is convertible with all units that are convertible with this unit.
     * For example the following code:
     *
     * [code]
     *    CELSIUS = KELVIN.shift(273.15);
     * [/code]
     *
     * creates a new unit where 0°C (the origin of the new unit) is equals to 273.15 K.
     * Converting from the old unit to the new one is equivalent to <em>subtracting</em>
     * the offset to the value in the old unit.
     *
     * @param  offset the offset added (expressed in this unit).
     * @return this unit offset by the specified value.
     */
    Unit<Q> shift(double offset);

    /**
     * Returns the result of multiplying this unit by the specified factor.
     * If the factor is an integer value, the multiplication is exact
     * (recommended). For example:
     *
     * [code]
     *    FOOT = METRE.multiply(3048).divide(10000); // Exact definition.
     *    ELECTRON_MASS = KILOGRAM.multiply(9.10938188e-31); // Approximation.
     * [/code]
     *
     * @param  factor the factor
     * @return this unit scaled by the specified factor.
     */
    Unit<Q> multiply(double factor);

    /**
     * Returns the product of this unit with the one specified.
     *
     * @param  that the unit multiplicand.
     * @return {@code this * that}
     */
    <T extends Quantity<T>, R extends Quantity<R>>  Unit<R> multiply(Unit<T> that);

    /**
     * Returns the inverse of this unit.
     *
     * @return {@code 1 / this}
     */
    <T extends Quantity<T>> Unit<T> inverse();

    /**
     * Returns the result of dividing this unit by an approximate divisor.
     * If the factor is an integer value, the division is exact.
     * For example:
     *
     * [code]
     *    QUART = GALLON_LIQUID_US.divide(4); // Exact definition.
     * [/code]
     *
     * @param  divisor the divisor value.
     * @return this unit divided by the specified divisor.
     */
    Unit<Q> divide(double divisor);

    /**
     * Returns the quotient of this unit with the one specified.
     *
     * @param  that the unit divisor.
     * @return {@code this / that}
     */
    <T extends Quantity<T>, R extends Quantity<R>>  Unit<R> divide(Unit<T> that);

    /**
     * Returns a unit equals to the given root of this unit.
     *
     * @param  n the root's order.
     * @return the result of taking the given root of this unit.
     * @throws ArithmeticException if {@code n == 0} or if this operation
     *         would result in an unit with a fractional exponent.
     */
    <T extends Quantity<T>> Unit<T> root(int n);

    /**
     * Returns a unit equals to this unit raised to an exponent.
     *
     * @param  n the exponent.
     * @return the result of raising this unit to the exponent.
     */
    <T extends Quantity<T>> Unit<T> pow(int n);

    /**
     * Returns a string representation of this unit. The string representation may
     * be the unit {@linkplain #getSymbol() symbol}, or may be some representation
     * of {@linkplain #getProductUnits() product units}, multiplication factor and
     * offset if any. The string may be localized at implementation choice.
     *
     * @return the (eventually localized) string representation of this unit.
     *
     * @see #getSymbol()
     */
    @Override
    String toString();
}
