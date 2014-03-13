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
 * Volume of fluid passing a point in a system per unit of time.
 * The system unit for this quantity is "m³/s" (cubic metre per second).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 3.2.1
 *
 * @see Volume
 * @see Time
 * @see <a href="http://en.wikipedia.org/wiki/Rate_of_fluid_flow">Wikipedia: Volumetric Flow Rate</a>
 */
public interface VolumetricFlowRate extends Quantity<VolumetricFlowRate> {
}
