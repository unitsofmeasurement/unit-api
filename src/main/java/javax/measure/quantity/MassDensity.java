/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.quantity;

import javax.measure.Quantity;

/**
 * Mass per unit volume of a substance under specified conditions
 * of pressure and temperature.
 * The system unit for this quantity is "kg/m³" (kilogram per cubic metre).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.4
 *
 * @see <a href="http://en.wikipedia.org/wiki/Density">Wikipedia: (Mass) Density</a>
 * @see Mass
 * @see Volume
 */
public interface MassDensity extends Quantity<MassDensity> {
}
