/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import javax.measure.function.ConversionOperator;

/**
 * Measurement is the assignment of values to objects or events.
 * <p>
 * Any measurement can be judged by the following meta-measurement criteria
 * values:
 * <ul>
 * <li>level of measurement (which may include magnitude)</li>
 * <li>dimensions (units)</li>
 * <li>uncertainty.</li>
 * </ul>
 * They enable comparisons to be done between different measurements and reduce
 * confusion. Even in cases of clear qualitative similarity or difference,
 * increased precision through quantitative measurement is often preferred in
 * order to aid in replication. For example, different colors may be based
 * either on wavelengths of light or (qualitative) terms such as "green" and
 * "blue" which are often interpreted differently by different people.
 * </p>
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
 * @see <a href="http://en.wikipedia.org/wiki/Measurement">Wikipedia:
 *      Measurement</a>
 * @see Unit
 * @version 0.20, 2014-09-09
 */
public interface Measurement<Q extends Quantity<Q>> extends
		ConversionOperator<Unit<Q>, Measurement<Q>> {
	/**
	 * Returns the unit of this {@linkplain Measurement}.
	 *
	 * @return the unit (shall not be {@code null}).
	 */
	Unit<Q> getUnit();
}
