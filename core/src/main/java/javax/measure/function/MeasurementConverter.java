/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 *  Represents a function that accepts a unit and produces a measurement.
 * 
 * <p>
 * This is a <a href=
 * "http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html"
 * >functional interface</a> whose functional method is {@link #to()}.
 * 
 * @author Werner Keil
 * @version 0.3 ($Revision: 395 $), $Date: 2014-01-27 23:16:02 +0100 (Mo, 27 Jän 2014) $
 * @param <Q>
 *            The type of the quantity measured.
 * @param <V>
 *            The value of the quantity measured.
 *            
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units"> Wikipedia:
 *      Conversion of units</a>
 * @see Measurement
 * @see Unit
 * @see Quantity
 */
// equivalent to @FunctionalInterface
public interface MeasurementConverter<Q extends Quantity<Q>, V> {

    /**
     * Returns a measurement converted into another unit.
     * 
     * @param unit
     * @return the converted result.
     */
    Q to(Unit<Q> unit);
}
