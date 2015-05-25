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
 * Rate of change of angular velocity with respect to time.
 * The system unit for this quantity is "rad/s²" (radian per square second).
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 1.1
 *
 * @see Angle
 * @see AngularSpeed
 * @see Time
 * @see Acceleration
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100
 */
public interface AngularAcceleration extends Quantity<AngularAcceleration> {
}
