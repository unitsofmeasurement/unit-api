/*
 * Units of Measurement API
 * Copyright (c) 2014-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
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
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
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
package javax.measure.spi;

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * Represents a factory that accepts {@linkplain Number} and {@link Unit} arguments to create a {@link Quantity} result.
 *
 * @param <Q>
 *          the type of the {@link Quantity} result
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @author <a href="mailto:otaviojava@java.net">Otavio Santana</a>
 * @version 0.7, $Date: 2015-09-27 $
 */
public interface QuantityFactory<Q extends Quantity<Q>> {

  /**
   * Returns the quantity for the specified number stated in the specified unit.
   *
   * @param value
   *          the numeric value stated in the specified unit
   * @param unit
   *          the unit
   * @return the corresponding quantity
   */
  Quantity<Q> create(Number value, Unit<Q> unit);

  /**
   * Returns the system unit for quantities produced by this factory or <code>null</code> if unknown.
   *
   * <p>
   * Because the system unit is unique by quantity type, it can be be used to identify the quantity given the unit. For example:
   * </p>
   *
   * <pre>
   *     static boolean isAngularSpeed({@literal Unit<?>} unit) {
   *         return unit.getSystemUnit().equals(RADIAN.divide(SECOND));
   *     }
   *     assert isAngularSpeed(REVOLUTION.divide(MINUTE)); // Returns true.
   * </pre>
   *
   * @return the system unit for this factory.
   * @see Unit#getSystemUnit()
   */
  Unit<Q> getSystemUnit();
}
