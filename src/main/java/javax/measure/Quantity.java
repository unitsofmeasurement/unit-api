/**
 * Unit-API - Units of Quantity API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

/**
 * <p>
 * Represents a quantitative properties or attributes of thing. Mass, time,
 * distance, heat, and angular separation are among the familiar examples of
 * quantitative properties.
 * </p>
 * 
 * <p>
 * This interface is used to specify the quantitative property associated to a
 * class through class parameterization and to provide limited compile time
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
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/Quantity">Wikipedia: Quantity</a>
 * @see <a href="http://martinfowler.com/eaaDev/quantity.html"> Martin Fowler -
 *      Quantity</a>
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units">Wikipedia:
 *      Conversion of units</a>
 * @version 0.10, Date: 2014-08-02
 */
public interface Quantity<Q extends Quantity<Q>> extends Measurement<Q, Number> {
	Quantity<?> divide(Quantity<?> that);

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
	 * Returns the sum of this {@code Quantity} with the one specified.
	 * 
	 * @param that
	 *            the {@code Quantity} to be added.
	 * @return <code>this + that</code>.
	 */
	Quantity<Q> add(Quantity<Q> that);

	/**
	 * Returns this {@code Quantity} divided by the one specified.
	 * 
	 * @param that
	 *            the {@code Quantity} divisor.
	 * @return <code>this / that</code>.
	 */
	// Quantity<?, V> divide(Quantity<?, V> that);

	/**
	 * Returns the product of this {@code Quantity} divided by the {@code V}
	 * value specified.
	 * 
	 * @param <R>
	 * 
	 * @param that
	 *            the {@code V} divisor.
	 * @return <code>this / that</code>.
	 */
	Quantity<Q> divide(Number that);

	/**
	 * Returns this {@code Quantity} divided by the one specified.
	 * 
	 * @param that
	 *            the {@code Quantity} divisor.
	 * @return <code>this / that</code>.
	 */
	// Quantity<?, V> divide(Quantity<?, V> that);

	/**
	 * Returns a {@code Quantity} whose unit is {@code unit.inverse()}.
	 * 
	 * @return {@code Quantity with this.getUnit().inverse()}.
	 */
	Quantity<Q> inverse();

	/**
	 * Returns the product of this {@code Quantity} with the one specified.
	 * 
	 * @param that
	 *            the {@code Quantity} multiplier.
	 * @return <code>this Â· that</code>.
	 */
	Quantity<?> multiply(Quantity<?> that);

	/**
	 * Returns the product of this {@code Quantity} with the {@code V} value
	 * specified.
	 * 
	 * @param that
	 *            the {@code V} multiplier.
	 * @return <code>this Â· that</code>.
	 */
	Quantity<Q> multiply(Number that);
}
