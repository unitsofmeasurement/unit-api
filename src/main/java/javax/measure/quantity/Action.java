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
 * Energy multiplied by a duration (quantity associated to the
 * <a href="http://en.wikipedia.org/wiki/Planck%27s_constant">Planck Constant</a>).
 * The system unit for this quantity is "J.s" (joules second).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1
 *
 * @see <a href="http://en.wikipedia.org/wiki/Action_(physics)">Wikipedia: Action</a>
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100
 */
public interface Action extends Quantity<Action> {
}
