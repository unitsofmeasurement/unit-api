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
 * Represents a quantitative property of a phenomenon, body, or substance, that can be quantified by {@link Measurement}. {@link javax.measure.quantity.Mass Mass}, time,
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
 * @implSpec
 * This interface places no restrictions on the mutability of implementations,
 * however immutability is strongly recommended.
 * All implementations must be {@link Comparable}.
 *
 * @param <Q>
 *            The type of the quantity.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:desruisseaux@users.sourceforge.net">Martin
 *         Desruisseaux</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:otaviojava@java.net">Otavio Santana</a>
 * @see <a href="http://en.wikipedia.org/wiki/Quantity">Wikipedia: Quantity</a>
 * @see <a href="http://martinfowler.com/eaaDev/quantity.html"> Martin Fowler -
 *      Quantity</a>
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units">Wikipedia:
 *      Conversion of units</a>
 * @see Measurement
 * @version 0.21, Date: 2014-10-29
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
	Quantity<?> divide(Quantity<?> that);

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
	Quantity<?> multiply(Quantity<?> multiplier);

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
	Quantity<?> inverse();

    /**
     * Returns this {@code Quantity} converted into another (compatible) {@code Unit}.
     *
     * @param unit
     * @return the converted result.
     */
    Quantity<Q> to(Unit<Q> unit);

	/**
	 * Casts this quantity to a parameterized unit of specified nature or throw a
	 * <code>ClassCastException</code> if the dimension of the specified
	 * quantity and this measure unit's dimension do not match. For example:<br/>
	 * <code>
	 *     Quantity<Length> length = BaseQuantity.of("2 km").asType(Length.class);
	 * </code>
	 * or
     * <code>
     *      Quantity<Speed> C = length.multiply(299792458).divide(second).asType(Speed.class);
     * </code>
     *
     * @param  <T> The type of the quantity.
     * @param  type the quantity class identifying the nature of the quantity.
   	 * @return this quantity parameterized with the specified type.
	 * @throws ClassCastException
	 *             if the dimension of this unit is different from the specified
	 *             quantity dimension.
	 * @throws UnsupportedOperationException
	 *             if the specified quantity class does not have a public static
	 *             field named "UNIT" holding the SI unit for the quantity.
	 * @see Unit#asType(Class)
     */
    <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException;


    /**
     * Compares two instances of {@link Quantity<Q>}.
     * Conversion of unit can happen if necessary
     * @param that the {@code quantity<Q>} to be compared with this instance.
     * @return {@code true} if {@code that > this}.
     * @throws NullPointerException if the that is null
     */
    boolean isGreaterThan(Quantity<Q> that);
    /**
     * Compares two instances of {@link Quantity<Q>},
     * doing the conversion of unit if necessary.
     * @param that the {@code quantity<Q>} to be compared with this instance.
     * @return {@code true} if {@code that >= this}.
     * @throws NullPointerException if the that is null
     */
    boolean isGreaterThanOrEqualTo(Quantity<Q> that);
    /**
     * Compares two instances of {@link Quantity<Q>},
     * doing the conversion of unit if necessary.
     * @param that the {@code quantity<Q>} to be compared with this instance.
     * @return {@code true} if {@code that < this}.
     * @throws NullPointerException if the quantity is null
     */
    boolean isLessThan(Quantity<Q> that);
    /**
     * Compares two instances of {@link Quantity<Q>},
     * doing the conversion of unit if necessary.
     * @param that the {@code quantity<Q>} to be compared with this instance.
     * @return {@code true} if {@code that < this}.
     * @throws NullPointerException if the quantity is null
     */
    boolean isLessThanOrEqualTo(Quantity<Q> that);
    /**
     * Compares two instances of {@link Quantity<Q>},
     * doing the conversion of unit if necessary.
     * @param that the {@code quantity<Q>} to be compared with this instance.
     * @return {@code true} if {@code that < this}.
     * @throws NullPointerException if the quantity is null
     */
    boolean isEquivalentTo(Quantity<Q> that);

}
