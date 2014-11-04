/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;

import java.util.Set;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * A system of units grouped together for historical or cultural reasons.
 * Nothing prevents a unit from belonging to several systems of units at the
 * same time (for example an {@code Imperial} system would have many of the
 * units held by {@code US} customary system).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.7, $Date: 2014-11-04 $
 * @see <a href="http://en.wikipedia.org/wiki/International_System_of_Units">
 *      Wikipedia: International System of Units</a>
 * @see <a href="http://en.wikipedia.org/wiki/Systems_of_measurement">
 *      Wikipedia: System of measurement</a>
 *
 */
public interface SystemOfUnits {

	/**
	 * @return a name
	 */
	String getName();

	/**
	 * Returns the default unit for the specified quantity.
	 *
	 * @param <Q>
	 *            the compile-time quantity type.
	 * @param quantityType
	 *            the quantity type.
	 * @return the unit for the specified quantity.
	 */
	<Q extends Quantity<Q>> Unit<Q> getUnit(Class<Q> quantityType);

	/**
	 * Returns a read only view over the units defined in this system.
	 *
	 * @return the collection of units.
	 */
	Set<? extends Unit<?>> getUnits();

	/**
	 * Returns the units defined in this system having the specified dimension
	 * (convenience method).
	 *
	 * @param dimension
	 *            the dimension of the units to be returned.
	 * @return the collection of units of specified dimension.
	 */
	Set<? extends Unit<?>> getUnits(Dimension dimension);
}
