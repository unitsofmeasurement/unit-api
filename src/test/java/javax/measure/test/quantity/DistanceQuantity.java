/*
 * Units of Measurement API
 * Copyright (c) 2014-2022, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
import javax.measure.quantity.Length;
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.VolumeUnit;

/**
 * @author Werner Keil
 * @version 0.7
 */
public class DistanceQuantity extends TestQuantity<Length> implements Length {

    public DistanceQuantity(double val, DistanceUnit un) {
        this();
        value = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public DistanceQuantity(Number val, Unit un) {
        this(val.doubleValue(), (DistanceUnit) un);
    }

    public DistanceQuantity() {
        super(Length.class);
    }

    /*
     * Distance(double val) {
     *
     * value = val; unit = m; // reference Unit scalar = val;
     *
     * }
     */
    public DistanceQuantity add(DistanceQuantity d1) {
        DistanceQuantity dn = new DistanceQuantity();
        Object o = super.add(dn, this, d1, DistanceUnit.REF_UNIT);
        return (DistanceQuantity) o;
    }

    public DistanceQuantity subtract(DistanceQuantity d1) {
        DistanceQuantity dn = new DistanceQuantity();
        Object o = super.subtract(dn, this, d1, DistanceUnit.REF_UNIT);
        return (DistanceQuantity) o;
    }

    public boolean eq(DistanceQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(DistanceQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(DistanceQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(DistanceQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(DistanceQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(DistanceQuantity d1) {
        return super.le(d1);
    }

    public DistanceQuantity multiply(double v) {
        return new DistanceQuantity(value * v, (DistanceUnit) unit);
    }

    public DistanceQuantity divide(double v) {
        return new DistanceQuantity(value / v, (DistanceUnit) unit);
    }

    // mixed type operations
    public AreaQuantity multiply(DistanceQuantity d1) {
        DistanceQuantity dq0 = convert(DistanceUnit.m);
        DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
        return new AreaQuantity(dq0.value * dq1.value, AreaUnit.sqmetre);
    }

    public VolumeQuantity multiply(AreaQuantity a1) {
        DistanceQuantity dq = convert(DistanceUnit.m);
        AreaQuantity aq = a1.convert(AreaUnit.sqmetre);
        return new VolumeQuantity(dq.value * aq.value, VolumeUnit.cumetre);
    }

    // public Speed divide(TimeInterval t1) {
    // return new Speed(scalar /
    // t1.scalar, Speed.refUnit);
    // }
    // public TimeInterval divide(Speed s1) {
    // return new TimeInterval(scalar /
    // s1.scalar, TimeInterval.refUnit);
    // }

    public DistanceQuantity convert(DistanceUnit newUnit) {
        return new DistanceQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(DistanceUnit u, int precision) {
        return super.showInUnits(u, precision);
    }

    public Quantity<?> divide(Quantity<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Length> to(Unit<Length> unit) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Length> subtract(Quantity<Length> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Length> add(Quantity<Length> that) {
        return add((DistanceQuantity) that);
    }

    public Quantity<Length> divide(Number that) {
        return divide(that.doubleValue());
    }

    public Quantity<Length> inverse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Quantity<Length> negate() {
        return new DistanceQuantity(-value, getUnit());
    }

    public Quantity<Length> multiply(Number that) {
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

    public Area multiply(Length l) {
        // TODO Auto-generated method stub
        return null;
    }
}
