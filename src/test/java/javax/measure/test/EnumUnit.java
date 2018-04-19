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
package javax.measure.test;

import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.spi.Prefix;
import javax.measure.test.unit.MultiplyConverter;

/**
 * @author Werner Keil
 *
 */
@SuppressWarnings("rawtypes")
enum EnumUnit implements Unit {
  TEST("t", 1);

  private final String symbol;
  @SuppressWarnings("unused")
  private final double factor;

  private EnumUnit(String symbol, double factor) {
    this.symbol = symbol;
    this.factor = factor;
  }

  public String getSymbol() {
    return symbol;
  }

  public Dimension getDimension() {
    return TestDimension.getInstance();
  }

  public Unit getSystemUnit() {
    return this;
  }

  public Map getBaseUnits() {
    // TODO Auto-generated method stub
    return null;
  }

  public boolean isCompatible(Unit that) {
    return (this.equals(that));
  }

  public Unit asType(Class type) throws ClassCastException {
    // TODO Auto-generated method stub
    return this;
  }

  public UnitConverter getConverterTo(Unit that) throws UnconvertibleException {
    // TODO Auto-generated method stub
    return null;
  }

  public UnitConverter getConverterToAny(Unit that) throws IncommensurableException, UnconvertibleException {
    // TODO Auto-generated method stub
    return null;
  }

  public Unit alternate(String symbol) {
    return this;
  }

  public Unit transform(UnitConverter operation) {
    // TODO Auto-generated method stub
    return null;
  }

  public Unit shift(double offset) {
    return this;
  }

  public Unit multiply(double factor) {
    return this;
  }

  public Unit multiply(Unit that) {
    if (!(that instanceof EnumUnit)) {
      throw new UnconvertibleException("Incompatible unit");
    }
    return this;
  }

  public Unit inverse() {
    return this;
  }

  public Unit divide(double divisor) {
    return this;
  }

  public Unit divide(Unit that) {
    if (!(that instanceof EnumUnit)) {
      throw new UnconvertibleException("Incompatible unit");
    }
    return this;
  }

  public Unit root(int n) {
    return this;
  }

  public Unit pow(int n) {
    return this;
  }

  public String getName() {
    return name();
  }

  @Override
  public Unit prefix(Prefix prefix) {
    final MultiplyConverter converter = 
      new MultiplyConverter(Math.pow(prefix.getBase(), prefix.getExponent()));
    return this.transform(converter);
  }
}
