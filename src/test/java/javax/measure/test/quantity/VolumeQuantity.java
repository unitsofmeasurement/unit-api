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
package javax.measure.test.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Volume;
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.VolumeUnit;

/**
 * @author Werner Keil
 * @version 0.5
 */
public class VolumeQuantity extends TestQuantity<Volume> {
  public VolumeQuantity() {
    super(Volume.class);
  }

  public VolumeQuantity(double val, VolumeUnit un) {
    this();
    units = val;
    unit = un;
    scalar = val * unit.getMultFactor();
  }

  public VolumeQuantity(Number val, Unit un) {
    this(val.doubleValue(), (VolumeUnit) un);
  }

  public VolumeQuantity add(VolumeQuantity d1) {
    VolumeQuantity dn = new VolumeQuantity();
    Object o = super.add(dn, this, d1, VolumeUnit.REF_UNIT);
    return (VolumeQuantity) o;
  }

  public VolumeQuantity subtract(VolumeQuantity d1) {
    VolumeQuantity dn = new VolumeQuantity();
    Object o = super.subtract(dn, this, d1, VolumeUnit.REF_UNIT);
    return (VolumeQuantity) o;
  }

  public boolean eq(VolumeQuantity d1) {
    return super.eq(d1);
  }

  public boolean ne(VolumeQuantity d1) {
    return super.ne(d1);
  }

  public boolean gt(VolumeQuantity d1) {
    return super.gt(d1);
  }

  public boolean lt(VolumeQuantity d1) {
    return super.lt(d1);
  }

  public boolean ge(VolumeQuantity d1) {
    return super.ge(d1);
  }

  public boolean le(VolumeQuantity d1) {
    return super.le(d1);
  }

  public VolumeQuantity multiply(double v) {
    return new VolumeQuantity(units * v, (VolumeUnit) unit);
  }

  public VolumeQuantity divide(double v) {
    return new VolumeQuantity(units / v, (VolumeUnit) unit);
  }

  // mixed type operations

  public AreaQuantity divide(DistanceQuantity d1) {
    VolumeQuantity dq0 = convert(VolumeUnit.cumetre);
    DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
    return new AreaQuantity(dq0.units / dq1.units, AreaUnit.sqmetre);
  }

  public DistanceQuantity divide(AreaQuantity a1) {
    VolumeQuantity dq0 = convert(VolumeUnit.cumetre);
    AreaQuantity dq1 = a1.convert(AreaUnit.sqmetre);
    return new DistanceQuantity(dq0.units / dq1.units, DistanceUnit.m);
  }

  public VolumeQuantity convert(VolumeUnit newUnit) {
    return new VolumeQuantity(scalar / newUnit.getMultFactor(), newUnit);
  }

  public String showInUnits(VolumeUnit u, int precision) {
    return super.showInUnits(u, precision);
  }

  public Quantity<?> divide(Quantity<?> that) {
    // TODO Auto-generated method stub
    return null;
  }

  public Quantity<Volume> subtract(Quantity<Volume> that) {
    // TODO Auto-generated method stub
    return null;
  }

  public Quantity<Volume> add(Quantity<Volume> that) {
    // TODO Auto-generated method stub
    return null;
  }

  public Quantity<Volume> divide(Number that) {
    // TODO Auto-generated method stub
    return null;
  }

  public Quantity<Volume> inverse() {
    // TODO Auto-generated method stub
    return null;
  }

  public Quantity<Volume> multiply(Number that) {
    return multiply(that.doubleValue());
  }

  public Quantity<Volume> to(Unit<Volume> unit) {
    // TODO Auto-generated method stub
    return null;
  }

  public Quantity<?> multiply(Quantity<?> that) {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public final <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException {
    this.getUnit().asType(type); // Raises ClassCastException is dimension
    // mismatches.
    return (Quantity) this;
  }
}
