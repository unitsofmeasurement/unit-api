/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

/**
 * Measurement is the assignment of values to objects or events.
 * <p>
 * Any measurement can be judged by the following meta-measurement criteria
 * values:
 * <ul>
 * <li>level of measurement (which includes magnitude)</li>
 * <li>dimensions (units)</li>
 * <li>uncertainty.</li>
 * </ul>
 * They enable comparisons to be done between different measurements and reduce
 * confusion. Even in cases of clear qualitative similarity or difference,
 * increased precision through quantitative measurement is often preferred in
 * order to aid in replication. For example, different colors may be based
 * either on wavelengths of light or (qualitative) terms such as "green" and
 * "blue" which are often interpreted differently by different people.<br>
 * Some measurements like <a href="http://en.wikipedia.org/wiki/Clothing_sizes">clothing sizes</a> use a non-numeric magnitude e.g. "<type>XL</type>" rather than an actual number used by other standards or countries in this area.<br>
 * The API therefore offers a {@link ValueSupplier} like it's used by {@link Quantity}, but does not mandate it for {@link Measurement}. Leaving implementations a freedom of choice for an appropriate getter of such values. For mentioned examples like "green" or "X-Large" this could simply be a <code>toString()</code> method, too or methods provided by a used type such as {@linkplain Enum}.
 * </p>
 * <p>
 * Measurement instances should be immutable.
 * </p>
 *
 * @param <Q>
 *            The type of the measurement.
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://en.wikipedia.org/wiki/Measurement">Wikipedia:
 *      Measurement</a>
 * @see <a href="http://en.wikipedia.org/wiki/Clothing_sizes">Wikipedia:
 *      Clothing sizes</a>
 * @see Unit
 * @version 0.24, 2014-09-29
 * @deprecated to be removed from a future version, use {@link Quantity} instead.
 */
public interface Measurement<Q extends Quantity<Q>> {
	/**
	 * Returns the unit of this {@linkplain Measurement}.
	 *
	 * @return the unit (shall not be {@code null}).
	 */
	Unit<Q> getUnit();
}
