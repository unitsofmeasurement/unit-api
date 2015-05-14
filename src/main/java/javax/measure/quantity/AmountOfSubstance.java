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
 * Number of elementary entities (molecules, for example) of a substance.
 * The metric system unit for this quantity is "mol" (mole).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.2
 * 
 * @see <a href=" http://en.wikipedia.org/wiki/Amount_of_substance">Wikipedia: Amount of Substance</a>
 * 
 * @implSpec 
 * SI Base Unit
 */
public interface AmountOfSubstance extends Quantity<AmountOfSubstance> {
}
