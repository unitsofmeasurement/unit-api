/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 *  Represents an operation to convert values.
 * <p>
 * This is a <a href=
 * "http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description"
 * >functional interface</a> whose functional method is {@link #to()}.
 *
*  @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.4.1, 2014-09-18
 * @param <Q>
 *            The type to convert to.
 * @see <a href="http://en.wikipedia.org/wiki/Data_conversion">Wikipedia: Data Conversion</a>
 */
public interface MeasurementConverter<Q extends Quantity<Q>> {

    /**
     * Returns a quantity converted into another unit.
     * @param type
     * @return the converted result.
     */
    Quantity<Q> to(Unit<Q> type);
}
