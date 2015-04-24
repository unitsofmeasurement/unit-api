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
 * Degree of magnetization of a material that responds linearly
 * to an applied magnetic field.
 * The system unit for this quantity is "H/m" (henry per meter).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.8.1
 *
 * @see <a href="http://en.wikipedia.org/wiki/Permeability_(electromagnetism)">Wikipedia: Permeability</a>
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100
 */
public interface MagneticPermeability extends Quantity<MagneticPermeability> {
}
