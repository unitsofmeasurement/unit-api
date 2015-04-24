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
 * Mass per unit volume of a substance under specified conditions
 * of pressure and temperature.
 * The system unit for this quantity is "kg/m³" (kilogram per cubic metre).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.2.1
 *
 * @see Mass
 * @see Volume
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100
 */
public interface VolumetricDensity extends Quantity<VolumetricDensity> {
}
