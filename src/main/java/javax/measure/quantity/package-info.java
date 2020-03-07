/*
 * Units of Measurement API
 * Copyright (c) 2014-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
//
// This source code implements specifications defined by the Java
// Community Process. In order to remain compliant with the specification
// DO NOT add / change / or delete method signatures!
//

/**
 * [OPTIONAL] Provides quantitative properties or attributes of thing such as
 * mass, time, distance, heat, and angular separation.
 * Quantities of different kinds are represented by sub-types of the
 * {@link javax.measure.Quantity} interface.
 *
 * <p>Only quantities defined in the <a href="http://www.bipm.org/en/publications/si-brochure/">BIPM - SI Brochure</a>
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
 * <p>{@link javax.measure.Quantity Quantity} sub-types are also used as parameterized type to characterize
 * generic classes and provide additional compile time check. This technique is
 * used extensively by the {@link javax.measure.Unit} interface,
 * but users can apply the same approach to their own classes. In the example
 * below, {@code Sensor}, {@code MyQuantity} and {@code Vector3D} are user-defined
 * classes:</p>
 *
 * <code>
 *    // A general-purpose Sensor class used for temperature measurements:<br>
 *    Sensor&lt;Temperature&gt; sensor ...;<br>
 *    Temperature temp = sensor.getValue();<br><br>
 *
 *    // A vector of velocity in a three-dimensional space.<br>
 *    Unit&lt;Speed&gt; = metrePerSecond = METRE.divide(SECOND);<br>
 *    Vector3D&lt;Speed&gt; aircraftSpeed = new Vector3D(200.0, 50.0, -0.5, metrePerSecond);
 * </code>
 *
 * <p>This package holds only the quantities required by the metric system.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 2.8
 * @since 1.0
 * @see <a href="https://en.wikipedia.org/wiki/International_System_of_Units">Wikipedia: International System of Units</a>
 * @see <a href="https://en.wikipedia.org/wiki/2019_redefinition_of_the_SI_base_units">Wikipedia: 2019 redefinition of the SI base units</a>
 */
package javax.measure.quantity;

