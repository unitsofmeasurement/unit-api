/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * Represents a factory that accepts {@linkplain Number} and {@link Unit} arguments to create a {@link Quantity} result.
 *
 * <p>This is a <a href="http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description">functional interface</a>
 * whose functional method is {@link #create(Number, Unit)}.
 *
 * @param <Q> the type of the {@link Quantity} result
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @author <a href="mailto:otaviojava@java.net">Otavio Santana</a>
 * @version 0.6, $Date: 2014-09-18 $
 */
public interface QuantityFactory <Q extends Quantity<Q>> {

    /**
     * Returns the quantity for the specified number stated in the specified unit.
     *
     * @param number the numeric value stated in the specified unit
     * @param unit the unit
     * @return the corresponding quantity
     */
	Quantity<Q> create(Number value, Unit<Q> unit);
}
