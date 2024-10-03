/*
 * Units of Measurement API
 * Copyright (c) 2014-2024, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.VolumeUnit;

/**
 * @author Werner Keil
 * @version 0.7
 */
public class AreaQuantity extends TestQuantity<Area> implements Area {
    public AreaQuantity() {
        super(Area.class);
    }

    public AreaQuantity(double val, AreaUnit un) {
        this();
        value = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public AreaQuantity(Number val, Unit u) {
        this(val.doubleValue(), (AreaUnit) u);
    }

    public AreaQuantity add(AreaQuantity d1) {
        AreaQuantity dn = new AreaQuantity();
        Object o = super.add(dn, this, d1, AreaUnit.REF_UNIT);
        return (AreaQuantity) o;
    }

    public AreaQuantity subtract(AreaQuantity d1) {
        AreaQuantity dn = new AreaQuantity();
        Object o = super.subtract(dn, this, d1, AreaUnit.REF_UNIT);
        return (AreaQuantity) o;
    }

    public boolean eq(AreaQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(AreaQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(AreaQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(AreaQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(AreaQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(AreaQuantity d1) {
        return super.le(d1);
    }

    public AreaQuantity multiply(double v) {
        return new AreaQuantity(value * v, (AreaUnit) unit);
    }

    public AreaQuantity divide(double v) {
        return new AreaQuantity(value / v, (AreaUnit) unit);
    }

    // mixed type operations

    public DistanceQuantity divide(DistanceQuantity d1) {
        AreaQuantity dq0 = convert(AreaUnit.sqmetre);
        DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
        return new DistanceQuantity(dq0.value / dq1.value, DistanceUnit.m);
    }

    public VolumeQuantity multiply(DistanceQuantity d1) {
        AreaQuantity dq0 = convert(AreaUnit.sqmetre);
        DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
        return new VolumeQuantity(dq0.value * dq1.value, VolumeUnit.cumetre);
    }

    public AreaQuantity convert(AreaUnit newUnit) {
        return new AreaQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(AreaUnit u, int precision) {
        return super.showInUnits(u, precision);
    }

    public Quantity<Area> multiply(Number that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<?> divide(Quantity<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Area to(Unit<Area> unit) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Area> subtract(Quantity<Area> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Area> add(Quantity<Area> that) {
        return add((AreaQuantity) that);
    }

    public Quantity<Area> divide(Number that) {
        return divide(that.doubleValue());
    }

    public Quantity<Area> inverse() {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<?> multiply(Quantity<?> that) {
        if (that.getClass().equals(DistanceQuantity.class)) {
            return multiply((DistanceQuantity) that);
        }
        return null;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException {
        this.getUnit().asType(type); // Raises ClassCastException is dimension
        // mismatches.
        return (Quantity) this;
    }

    @Override
    public Quantity<Area> negate() {
        return new AreaQuantity(-value, getUnit());
    }
}
