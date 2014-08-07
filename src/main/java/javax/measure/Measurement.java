/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import javax.measure.function.ConversionOperator;
import javax.measure.function.UnitSupplier;

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
 * @version 0.17, $Date: 2014-08-03 $
 */
public interface Measurement<Q extends Quantity<Q>, V> extends UnitSupplier<Q>,
		ConversionOperator<Measurement<Q, V>, Unit<Q>> {
}