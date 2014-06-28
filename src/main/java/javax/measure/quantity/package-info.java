/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
/**
 * [OPTIONAL] Provides quantitative properties or attributes of thing such as
 * mass, time, distance, heat, and angular separation.
 * Quantities of different kinds are represented by sub-types of the
 * {@link javax.measure.Quantity} interface.
 *
 * <p>Only quantities defined in the <a href="http://en.wikipedia.org/wiki/International_System_of_Units">International System of Units</a>
 * are provided here. Users can create their own quantity types by extending the
 * {@link javax.measure.Quantity Quantity} interface.</p>
 *
 * <p>This package supports <cite>measurable</cite> quantities, which can be expressed
 * as ({@link java.lang.Number}, {@link javax.measure.Unit}) tuples.
 * Those tuples are not necessarily used directly in numerically intensive code.
 * They are more useful as meta-data converted to the application internal representation
 * (for example {@code double} primitive type with the requirement to provide values in meters)
 * before computation begins.</p>
 *
 * <p>Quantities sub-types are also used as parameterized type to characterize
 * generic classes and provide additional compile time check. This technique is
 * used extensively by the {@link javax.measure.Unit} interface,
 * but users can apply the same approach to their own classes. In the example
 * below, {@code Sensor}, {@code MyQuantity} and {@code Vector3D} are user-defined
 * classes:</p>
 *
 * <code>
 *    // A general-purpose Sensor class used for temperature measurements:<br>
 *    Sensor<Temperature> sensor ...;<br>
 *    Temperature temp = sensor.getValue();<br><br>
 *
 *    // A vector of velocity in a three-dimensional space.<br>
 *    Unit<Speed> = metrePerSecond = METRE.divide(SECOND);<br>
 *    Vector3D<Speed> aircraftSpeed = new Vector3D(200.0, 50.0, -0.5, metrePerSecond);
 * </code>
 *
 * <p>This package holds only the quantities required by the metric system.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 2.3
 *
 */
package javax.measure.quantity;
