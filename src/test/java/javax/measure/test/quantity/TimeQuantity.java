/*
 * Units of Measurement API
 * Copyright (c) 2014-2023, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
import javax.measure.quantity.Time;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.TimeUnit;

/**
 * @author Werner Keil
 * @version 0.6
 */
public class TimeQuantity extends TestQuantity<Time> {

    public TimeQuantity(double val, TimeUnit un) {
        this();
        value = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public TimeQuantity(Number val, @SuppressWarnings("rawtypes") Unit un) {
        this(val.doubleValue(), (TimeUnit) un);
    }

    public TimeQuantity() {
        super(Time.class);
    }

    /*
     * Time(double val) {
     *
     * value = val; unit = m; // reference Unit scalar = val;
     *
     * }
     */
    public TimeQuantity add(TimeQuantity d1) {
        TimeQuantity dn = new TimeQuantity();
        Object o = super.add(dn, this, d1, TimeUnit.REF_UNIT);
        return (TimeQuantity) o;
    }

    public TimeQuantity subtract(TimeQuantity d1) {
        TimeQuantity dn = new TimeQuantity();
        Object o = super.subtract(dn, this, d1, TimeUnit.REF_UNIT);
        return (TimeQuantity) o;
    }

    public boolean eq(TimeQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(TimeQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(TimeQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(TimeQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(TimeQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(TimeQuantity d1) {
        return super.le(d1);
    }

    public TimeQuantity multiply(double v) {
        return new TimeQuantity(value * v, (TimeUnit) unit);
    }

    public TimeQuantity divide(double v) {
        return new TimeQuantity(value / v, (TimeUnit) unit);
    }

    public TimeQuantity convert(TimeUnit newUnit) {
        return new TimeQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(DistanceUnit u, int precision) {
        return super.showInUnits(u, precision);
    }

    public Quantity<?> divide(Quantity<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Time> subtract(Quantity<Time> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Time> add(Quantity<Time> that) {
        return add((TimeQuantity) that);
    }

    public Quantity<Time> divide(Number that) {
        return divide(that.doubleValue());
    }

    public Quantity<Time> inverse() {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Time> multiply(Number that) {
        return multiply(that.doubleValue());
    }

    public Quantity<Time> to(Unit<Time> unit) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<?> multiply(Quantity<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Quantity<Time> negate() {
        return new TimeQuantity(-value, getUnit());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public final <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException {
        this.getUnit().asType(type); // Raises ClassCastException is dimension
        // mismatches.
        return (Quantity) this;
    }
}
