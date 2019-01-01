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
import javax.measure.quantity.Area;
import javax.measure.quantity.Dimensionless;
import javax.measure.test.TestUnit;
import javax.measure.test.unit.BaseUnit;

/**
 * @author Werner Keil
 * @version 0.5
 */
class DimensionlessQuantity extends TestQuantity<Dimensionless> implements Dimensionless {

    public DimensionlessQuantity(double val, TestUnit un) {
        this();
        value = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public DimensionlessQuantity(Number val, Unit un) {
        this(val.doubleValue(), (TestUnit) un);
    }

    public DimensionlessQuantity() {
        super(Dimensionless.class);
    }

    public boolean eq(DimensionlessQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(DimensionlessQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(DimensionlessQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(DimensionlessQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(DimensionlessQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(DimensionlessQuantity d1) {
        return super.le(d1);
    }

    public DimensionlessQuantity multiply(double v) {
        return new DimensionlessQuantity(value * v, (BaseUnit) unit);
    }

    public DimensionlessQuantity divide(double v) {
        return new DimensionlessQuantity(value / v, (BaseUnit) unit);
    }

    // public Speed divide(TimeInterval t1) {
    // return new Speed(scalar /
    // t1.scalar, Speed.refUnit);
    // }
    // public TimeInterval divide(Speed s1) {
    // return new TimeInterval(scalar /
    // s1.scalar, TimeInterval.refUnit);
    // }

    public DimensionlessQuantity convert(BaseUnit newUnit) {
        return new DimensionlessQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(BaseUnit u, int precision) {
        return super.showInUnits(u, precision);
    }

    public Quantity<?> divide(Quantity<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Dimensionless> to(Unit<Dimensionless> unit) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Dimensionless> subtract(Quantity<Dimensionless> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Dimensionless> add(Quantity<Dimensionless> that) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Quantity<Dimensionless> negate() {
        return new DimensionlessQuantity(-value, getUnit());
    }

    public Quantity<Dimensionless> divide(Number that) {
        return divide(that.doubleValue());
    }

    public Quantity<Dimensionless> inverse() {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Dimensionless> multiply(Number that) {
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

    public Area multiply(Dimensionless l) {
        // TODO Auto-generated method stub
        return null;
    }
}
