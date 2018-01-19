/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.test.TestUnit;

/**
 * Building blocks on top of which all others units are created. Base units are always unscaled metric units.
 *
 * <p>
 * When using the standard model (default), all seven base units are dimensionally independent.
 * </p>
 *
 * @param <Q>
 *          The type of the quantity measured by this unit.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.0
 *
 * @see <a href="http://en.wikipedia.org/wiki/SI_base_unit">Wikipedia: SI base unit</a>
 */
public class BaseUnit<Q extends Quantity<Q>> extends TestUnit<Q> {
  /**
   * Creates a base unit having the specified symbol.
   *
   * @param symbol
   *          the symbol of this base unit.
   * @throws IllegalArgumentException
   *           if the specified symbol is associated to a different unit.
   */
  public BaseUnit(String symbol, String name) {
    super(name);
    this.symbol = symbol;
  }

  /**
   * Creates a base unit having the specified symbol.
   *
   * @param symbol
   *          the symbol of this base unit.
   * @throws IllegalArgumentException
   *           if the specified symbol is associated to a different unit.
   */
  public BaseUnit(String symbol) {
    this(symbol, null);
  }

  @Override
  public String getSymbol() {
    return symbol;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj instanceof BaseUnit<?>) {
      BaseUnit<?> other = (BaseUnit<?>) obj;
      return symbol != null && symbol.equals(other.symbol);
    }
    return false;
  }

  @Override
  public int hashCode() {
    // return Objects.hashCode(symbol);
    return 0;
  }

  @Override
  public Unit<Q> getSystemUnit() {
    return this;
  }
}
