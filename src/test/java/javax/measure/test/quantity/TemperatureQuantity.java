/*
 * Units of Measurement API
 * Copyright (c) 2014-2021, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Temperature;
import javax.measure.test.unit.TemperatureUnit;

/**
 * @author Werner Keil
 * @version 1.3, $Date: 2018-12-17 $
 */
public final class TemperatureQuantity extends TestQuantity<Temperature> implements Temperature {

    public TemperatureQuantity(Scale s) {
        super(Temperature.class, s);
    }

    public TemperatureQuantity(double val, TemperatureUnit un) {
        this(((TemperatureUnit.KELVIN.equals(un) || TemperatureUnit.RANKINE.equals(un)) ?
            Scale.ABSOLUTE : Scale.RELATIVE));
        unit = un;
        value = val;
        if (un != null) {
            scalar = val * un.getFactor();
        } else
            scalar = -1;
    }

    public TemperatureQuantity(Number val, @SuppressWarnings("rawtypes") Unit u) {
        this(val.doubleValue(), (TemperatureUnit) u);
    }

    public boolean isZero() {
        return 0d == (value);
    }

    public TemperatureQuantity add(TemperatureQuantity d1) {
        final TemperatureQuantity dn = new TemperatureQuantity(Double.valueOf(this.value + d1.value), this.unit);
        return dn;
    }

    public TemperatureQuantity subtract(TemperatureQuantity d1) {
        final TemperatureQuantity dn = new TemperatureQuantity(this.value - d1.value, this.unit);
        return dn;
    }

    protected boolean eq(TemperatureQuantity dq) {
        return dq != null && dq.getValue().equals(getValue()) && dq.getUnit().equals(getUnit()) && dq.getScalar().equals(getScalar());
    }

    boolean ne(TemperatureQuantity d1) {
        return ne((TemperatureQuantity) d1);
    }

    public TemperatureQuantity divide(double v) {
        return new TemperatureQuantity(value / v, unit);
    }

    protected TemperatureQuantity convert(TemperatureUnit newUnit) {
        return new TemperatureQuantity(value / newUnit.getFactor(), newUnit);
    }

    public Double getScalar() {
        return scalar;
    }

    public String toString(boolean withUnit, boolean withSpace, int precision) {
        final StringBuilder sb = new StringBuilder();
        sb.append(getValue());
        if (withUnit) {
            if (withSpace)
                sb.append(" ");
            sb.append(getUnit().getSymbol());
        }
        return sb.toString();
    }

    public Number getValue() {
        return value;
    }

    public Unit<Temperature> getUnit() {
        return unit;
    }

    public Quantity<Temperature> multiply(Number that) {
        return new TemperatureQuantity(value * that.doubleValue(), unit);
    }

    public Quantity<?> multiply(Quantity<?> that) {
        return new TemperatureQuantity(value * that.getValue().doubleValue(), unit);
    }

    public Quantity<Temperature> inverse() {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * Measurement#doubleValue(javax.measure.Unit)
     */
    protected double doubleValue(Unit<Temperature> unit) {
        Unit<Temperature> myUnit = getUnit();
        try {
            UnitConverter converter = unit.getConverterTo(myUnit);
            return converter.convert(getValue().doubleValue());
        } catch (UnconvertibleException e) {
            throw e;
        } // catch (IncommensurableException e) {
        // throw new IllegalArgumentException(e.getMessage());
        // }
    }

    public Quantity<Temperature> to(Unit<Temperature> unit) {
        if (this.unit.equals(unit)) {
            return this;
        }
        if (unit instanceof TemperatureUnit) {
            // final TemperatureUnit asTU = (TemperatureUnit)unit;
            // for (TemperatureUnit tu : TemperatureUnit.values()) {
            // if (asTU.equals(tu)) {
            // return new TemperatureQuantity( asTU)
            // }
            // }
            return convert((TemperatureUnit) unit);
        } else {
            throw new ArithmeticException("Cannot convert " + this.unit + " to " + unit);
        }
    }

    public boolean eq(TestQuantity<Temperature> dq) {
        return eq((TemperatureQuantity) dq);
    }

    public Quantity<?> divide(Quantity<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Temperature> subtract(Quantity<Temperature> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Temperature> add(Quantity<Temperature> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Quantity<Temperature> divide(Number that) {
        // TODO Auto-generated method stub
        return null;
    }

    public int compareTo(Quantity<Temperature> o) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Quantity<Temperature> negate() {
        return new TemperatureQuantity(-value, unit);
    }

    @Override
    public <T extends Quantity<T>> Quantity<T> asType(Class<T> type) throws ClassCastException {
        // TODO Auto-generated method stub
        return null;
    }
}
