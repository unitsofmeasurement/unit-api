/*
 * Units of Measurement API
 * Copyright (c) 2014-2019, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure.test.unit;

import javax.measure.UnitConverter;
import javax.measure.test.TestUnit;

import javax.measure.Dimension;
import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * <p>
 * This class represents multi-radix units (such as "hour:min:sec" or "ft, in"). Instances of this class are created using the {@link Unit#mix
 * Unit.mix} method.
 * </p>
 * 
 * <p>
 * Examples of mixed units:<code> Unit<Time> HOUR_MINUTE_SECOND = HOUR.mix(MINUTE).mix(SECOND); <br>Unit<Length> FOOT_INCH =
 * FOOT.mix(INCH); </code>
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.9, March 20, 2019
 * @since 2.0
 */
public final class MixedUnit<Q extends Quantity<Q>> extends TestUnit<Q> {

  /**
   * Holds the upper unit.
   */
  private final Unit<Q> upper;

  /**
   * Holds the lower unit.
   */
  private final Unit<Q> lower;

  /**
   * Creates a mixed unit from the specified units.
   *
   * @param up
   *          the upper unit.
   * @param low
   *          the lower unit(s)
   * @throws IllegalArgumentException
   *           if both units do not the same system unit.
   */
  public MixedUnit(Unit<Q> up, Unit<Q> low) {
    if (!up.getSystemUnit().equals(low.getSystemUnit()))
      throw new IllegalArgumentException("Both units do not have the same system unit");
    upper = up;
    lower = low;
  }

  /**
   * Returns the lower unit of this mixed unit.
   *
   * @return the lower unit.
   */
  public Unit<Q> getLower() {
    return lower;
  }

  /**
   * Returns the upper unit of this mixed unit.
   *
   * @return the upper unit.
   */
  public Unit<Q> getUpper() {
    return upper;
  }

  /**
   * Indicates if this mixed unit is considered equals to the specified object (both are mixed units with same composing units in the same
   * order).
   *
   * @param obj
   *          the object to compare for equality.
   * @return <code>true</code> if <code>this</code> and <code>obj</code> are considered equal; <code>false</code>otherwise.
   */
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof MixedUnit) {
      MixedUnit<?> thatUnit = (MixedUnit<?>) obj;
      return this.upper.equals(thatUnit.upper) && this.lower.equals(thatUnit.lower);
    }
    return super.equals(obj);
  }

  @Override
  public int hashCode() {
    return upper.hashCode() ^ lower.hashCode();
  }

  @Override
  public UnitConverter getSystemConverter() {
    return ((TestUnit<?>) lower).getSystemConverter();
  }

  @Override
  public Unit<Q> getSystemUnit() {
    return lower.getSystemUnit();
  }

  @Override
  public Dimension getDimension() {
    return lower.getDimension();
  }
}
