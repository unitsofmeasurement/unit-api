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
 * This interface transforms a {@link Unit}
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #transform()}.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, $Date: 2014-04-16 $
 * @param <Q>
 *            The type of the quantity.
 * @see Unit
 * @see UnitConverter
 */
//equivalent to @FunctionalInterface
public interface UnitTransformer<Q extends Quantity<Q>> {
    /**
     * Returns the unit derived from this unit using the specified converter.
     * The converter does not need to be linear. For example:<br>
     * <code>
     *     Unit<Dimensionless> DECIBEL = Unit.ONE.transform(
     *         new LogConverter(10).inverse().concatenate(
     *             new RationalConverter(1, 10)));
     * </code>
     *
     * @param  operation the converter from the transformed unit to this unit.
     * @return the unit after the specified transformation.
     */
	Unit<Q> transform(UnitConverter converter);
}
