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
 * Represents a supplier of {@link Unit}-valued results.
 * 
 * <p>There is no requirement that a distinct result be returned each
 * time the supplier is invoked.
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #getUnit()}.
 * 
 * @author Werner Keil
 * @version 1.3 ($Revision: 395 $), 2013-12-22
 * @param <Q>
 *            The type of the quantity.
 * @see Unit
 */
// equivalent to @FunctionalInterface
public interface UnitSupplier<Q extends Quantity<Q>> {
	/**
	 * Returns the unit of this UnitProvider {@linkplain #getValue() value}.
	 * 
	 * @return the unit (can not be {@code null}).
	 */
	Unit<Q> getUnit();
}
