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
 * Rate of change of angular displacement with respect to time.
 * The system unit for this quantity is "rad/s" (radian per second).
 *
 * <p><cite>Angular speed</cite> is a scalar value, while <cite>angular velocity</cite> is a
 * pseudo-vector. The angular speed is the magnitude of the angular velocity pseudo-vector,
 * or the components of the angular velocity pseudo-vector.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.3
 *
 * @see Angle
 * @see Time
 * @see Speed
 * @see <a href="http://en.wikipedia.org/wiki/Angular_speed">Wikipedia: Angular Speed</a>
 * 
 * @deprecated see https://java.net/jira/browse/UNITSOFMEASUREMENT-100 */
public interface AngularSpeed extends Quantity<AngularSpeed> {
}
