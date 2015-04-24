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
 * Quantity of subatomic particles or electromagnetic waves that are energetic
 * enough to detach electrons from atoms or molecules, ionizing them.
 * The system unit for this quantity is "C/kg ("coulomb per kilogram).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2.1
 *
 * @see <a href="http://en.wikipedia.org/wiki/Ionizing_radiation">Wikipedia: Ionizing Radiation</a>
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100
 */
public interface IonizingRadiation extends Quantity<IonizingRadiation> {
}
