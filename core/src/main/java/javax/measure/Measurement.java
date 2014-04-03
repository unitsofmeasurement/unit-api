/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import javax.measure.function.MeasurementConverter;
import javax.measure.function.UnitSupplier;
import javax.measure.function.ValueSupplier;

/**
 * Represents a value with a unit.
 * 
 * A Measurement object is used for maintaining the tuple of value and unit.
 * </br> Arithmetic methods are provided. At least a runtime error (for some
 * operations already at compile time) will occur when two measurements are used
 * in an incompatible way. E.g., when a speed (m/s) is added to a distance (m).
 * The measurement class will correctly track changes in unit during
 * multiplication and division, always coercing the result to the most simple
 * form. See <type>Unit</type> for more information on the supported units.
 * 
 * <p>
 * Measurement instances should be immutable.
 * </p>
 * 
 * @param <Q>
 *            The type of the measurement.
 * @param <V>
 *            The measured value.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/Units_of_measurement"> Wikipedia:
 *      Units of measurement</a>
 * @version 1.11, $Date: 2014-04-03 $
 */
public interface Measurement<Q extends Quantity<Q>, V> extends UnitSupplier<Q>,
        ValueSupplier<V>, MeasurementConverter<Q, V> {

    /**
     * Returns the sum of this {@code Measurement} with the one specified.
     * 
     * @param that
     *            the {@code Measurement} to be added.
     * @return <code>this + that</code>.
     */
    Measurement<Q, V> add(Measurement<Q, V> that);

    /**
     * Returns the difference between this {@code Measurement} and the one specified.
     * 
     * @param that
     *            the {@code Measurement} to be subtracted.
     * @return <code>this - that</code>.
     */
    Measurement<Q, V> substract(Measurement<Q, V> that);

    /**
     * Returns the product of this {@code Measurement} with the one specified.
     * 
     * @param that
     *            the {@code Measurement} multiplier.
     * @return <code>this · that</code>.
     */
    Measurement<?, V> multiply(Measurement<?, V> that);

    /**
     * Returns the product of this {@code Measurement} with the {@code V} value specified.
     * 
     * @param that
     *            the {@code V} multiplier.
     * @return <code>this · that</code>.
     */
    Measurement<?, V> multiply(V that);

    /**
     * Returns this {@code Measurement} divided by the one specified.
     * 
     * @param that
     *            the {@code Measurement} divisor.
     * @return <code>this / that</code>.
     */
    Measurement<?, V> divide(Measurement<?, V> that);
    
    /**
     * Returns the product of this {@code Measurement} divided by the {@code V} value specified.
     * 
     * @param that
     *            the {@code V} divisor.
     * @return <code>this / that</code>.
     */
    Measurement<?, V> divide(V that);

    /**
     * Returns a {@code Measurement} whose unit is {@code unit.inverse()}.
     * 
     * @return {@code Measurement with this.getUnit().inverse()}.
     */
    Measurement<Q, V> inverse();
}
