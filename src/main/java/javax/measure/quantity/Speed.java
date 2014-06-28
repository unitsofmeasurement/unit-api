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
 * Distance traveled divided by the time of travel.
 * The metric system unit for this quantity is "m/s" (metre per second).
 *
 * <p><cite>Speed</cite> is a scalar value, while <cite>velocity</cite> is a vector.
 * Speed is the magnitude of the velocity vector, or the components of the velocity
 * vector.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 *
 * @see Length
 * @see Time
 * @see Acceleration
 * @see AngularSpeed
 * @see <a href="http://en.wikipedia.org/wiki/Speed">Wikipedia: Speed</a>
 */
public interface Speed extends Quantity<Speed> {
}
