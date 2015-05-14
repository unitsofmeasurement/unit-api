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
 * Speed of data-transmission.
 * The system unit for this quantity is "bit/s" (bit per second).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3
 *
 * @see Information
 * @see <a href="http://en.wikipedia.org/wiki/Information_rate">Wikipedia: Information Rate</a>
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100
 */
public interface InformationRate extends Quantity<InformationRate> {
}
