/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import java.util.Map;

import javax.measure.function.Nameable;
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
 * @version 1.4
 *
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement">Wikipedia: Units of measurement</a>
 */
public interface Unit<Q extends Quantity<Q>> extends UnitTransformer<Q>, Nameable {

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
     *     static boolean isAngularVelocity(Unit<?> unit) {
     *         return unit.getSystemUnit().equals(RADIAN.divide(SECOND));
     *     }
     *     assert isAngularVelocity(REVOLUTION.divide(MINUTE)); // Returns true.
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
    Map<? extends Unit<?>, Integer> getProductUnits();


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
