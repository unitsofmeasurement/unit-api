/**
 * Unit-API - Units of Quantity API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import javax.measure.function.ValueSupplier;

/**
 * <p>
 * Represents quantitative properties or attributes of thing. {@link javax.measure.quantity.Mass Mass}, time,
 * distance, heat, and angular separation are among the familiar examples of
 * quantitative properties.
 * </p>
 *
 * <p>
 * This interface extends {@link Measurement} to specify the quantitative property associated to a
 * class through class parameterization and to provide some compile time
 * dimension consistency. <br>
 * <br>
 * <code> Unit<Mass> pound = ... Quantity<Length> size = ... Sensor<Temperature><br>
 * thermometer = ... Vector3D<Speed> aircraftSpeed = ... </code>
 * </p>
 *
 * @param <Q>
 *            The type of the quantity.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin
 *         Desruisseaux</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/Quantity">Wikipedia: Quantity</a>
 * @see <a href="http://martinfowler.com/eaaDev/quantity.html"> Martin Fowler -
 *      Quantity</a>
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units">Wikipedia:
 *      Conversion of units</a>
 * @see Measurement
 * @version 0.17, Date: 2014-10-06
 */
public interface Quantity<Q extends Quantity<Q>> extends Measurement<Q>, ValueSupplier<Number> {

	/**
	 * Returns the sum of this {@code Quantity} with the one specified.
	 *
	 * @param that
	 *            the {@code Quantity} to be added.
	 * @return <code>this + that</code>.
	 */
	Quantity<Q> add(Quantity<Q> that);

	/**
	 * Returns the difference between this {@code Quantity} and the one
	 * specified.
	 *
	 * @param that
	 *            the {@code Quantity} to be subtracted.
	 * @return <code>this - that</code>.
	 */
	Quantity<Q> subtract(Quantity<Q> that);

	/**
	 * Returns the product of this {@code Quantity} divided by the {@code Quantity}
	 * specified.
	 *
	 * @throws ClassCastException if the type of an element
     *         in the specified operation is incompatible with this
     *         quantity
     *         (<a href="#optional-restrictions">optional</a>)
	 *
	 * @param that
	 *            the {@code Quantity} divisor.
	 * @return <code>this / that</code>.
	 */
	<T extends Quantity<T>, R extends Quantity<R>> Quantity<R> divide(Quantity<T> that);

	/**
	 * Returns the product of this {@code Quantity} divided by the {@code Number}
	 * specified.
	 *
	 * @param that
	 *            the {@code Number} divisor.
	 * @return <code>this / that</code>.
	 */
	Quantity<Q> divide(Number that);

	/**
	 * Returns the product of this {@code Quantity} with the one specified.
	 *
	 * @throws ClassCastException if the type of an element
     *         in the specified operation is incompatible with this
     *         quantity
     *         (<a href="#optional-restrictions">optional</a>)
	 *
	 * @param that
	 *            the {@code Quantity} multiplier.
	 * @return <code>this * that</code>.
	 */
	<T extends Quantity<T>, R extends Quantity<R>> Quantity<R> multiply(Quantity<T> that);

	/**
	 * Returns the product of this {@code Quantity} with the {@code Number} value
	 * specified.
	 *
	 * @param that
	 *            the {@code Number} multiplier.
	 * @return <code>this * that</code>.
	 */
	Quantity<Q> multiply(Number multiplier);

	/**
	 * Returns a {@code Quantity} whose unit is {@code unit.inverse()}.
	 *
	 * @return {@code Quantity with this.getUnit().inverse()}.
	 */
	<T extends Quantity<T>> Quantity<T> inverse();

    /**
     * Returns this {@code Quantity} converted into another (compatible) {@code Unit}.
     *
     * @param unit
     * @return the converted result.
     */
    Quantity<Q> to(Unit<Q> unit);
}
