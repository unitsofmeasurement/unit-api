/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.quantity;

import javax.measure.Quantity;


/**
 * Measure of the quantity of matter that a body or an object contains.
 * The mass of the body is not dependent on gravity and therefore is
 * different from but proportional to its weight.
 * The metric system unit for this quantity is "kg" (kilogram).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 *
 * @see VolumetricDensity
 * @see RadiationDoseAbsorbed
 */
public interface Mass extends Quantity<Mass> {
}
