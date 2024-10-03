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
import javax.measure.quantity.Dimensionless;
import javax.measure.test.TestUnit;
import javax.measure.test.unit.BaseUnit;

/**
 * @author Werner Keil
 * @version 2.0
 * @since 1.0
 */
public abstract class TestQuantity<Q extends Quantity<Q>> implements Quantity<Q>, Comparable<Quantity<Q>> {

    @SuppressWarnings("rawtypes")
	public static final Quantity<Dimensionless> ONE = new DimensionlessQuantity(1d, (BaseUnit) TestUnit.ONE);

    protected double scalar; // value in reference value
    protected double value; // value in value (Unit unit)
    protected TestUnit<Q> unit; // unit
    private final Class<Q> type; // quantity type
    private final Scale scale;

    protected TestQuantity(Class<Q> type, Scale scale) {
        this.type = type;
        this.scale = scale;
    }

    protected TestQuantity(Class<Q> type) {
        this(type, Scale.ABSOLUTE);
    }

    public Class<Q> getType() {
        return this.type;
    }

    public TestQuantity<Q> add(TestQuantity<Q> dn, TestQuantity<Q> d1, TestQuantity<Q> d2, TestUnit<Q> au) {
        if (d1.unit == d2.unit) {
            dn.unit = d1.unit;
            dn.scalar = d1.scalar + d2.scalar;
            dn.value = d1.value + d2.value;
        } else {
            dn.unit = au;
            dn.scalar = d1.scalar + d2.scalar;
            dn.value = dn.scalar;
        }
        return dn;
    }

    public TestQuantity<Q> subtract(TestQuantity<Q> dn, TestQuantity<Q> d1, TestQuantity<Q> d2, TestUnit<Q> au) {
        if (d1.unit == d2.unit) {
            dn.unit = d1.unit;
            dn.scalar = d1.scalar - d2.scalar;
            dn.value = d1.value - d2.value;
        } else {
            dn.unit = au;
            dn.scalar = d1.scalar - d2.scalar;
            dn.value = dn.scalar;
        }
        return dn;
    }

    public boolean eq(TestQuantity<Q> d1) {
        return (scalar == d1.scalar);
    }

    public boolean ne(TestQuantity<Q> d1) {
        return (scalar != d1.scalar);
    }

    public boolean gt(TestQuantity<Q> d1) {
        return (scalar > d1.scalar);
    }

    public boolean lt(TestQuantity<Q> d1) {
        return (scalar < d1.scalar);
    }

    public boolean ge(TestQuantity<Q> d1) {
        return (scalar >= d1.scalar);
    }

    public boolean le(TestQuantity<Q> d1) {
        return (scalar <= d1.scalar);
    }

    @Override
    public String toString() {
        return (Double.valueOf(value)).toString() + ' ' + String.valueOf(unit);
    }

    /**
     * Compares this quantity to the specified Measurement quantity. The default implementation compares the {@link Quantity#getValue()} of both this
     * quantity and the specified Quantity stated in the same unit (this quantity's {@link #getUnit() unit}).
     *
     * @return a negative integer, zero, or a positive integer as this quantity is less than, equal to, or greater than the specified Quantity
     *         quantity.
     */
    public int compareTo(Quantity<Q> that) {
        return Double.compare(value, that.getValue().doubleValue());
    }

    protected String showInUnits(TestUnit<?> u, int precision) {
        double result = scalar / u.getMultFactor();

        String str = (Double.valueOf(result)).toString();
        char cs[] = str.toCharArray();
        int i = 0;
        while (i < cs.length && (cs[i] >= '0' && cs[i] <= '9' || cs[i] == '.')) {
            i++;
        }
        Double bd = new Double(new String(cs, 0, i));
        // BigDecimal bd2 = bd.setScale(precision, RoundingMode.HALF_UP);
        // str = bd2.toString();
        str = bd.toString();

        String exp = "";
        if (i < cs.length) {
            exp = new String(cs, i, cs.length - i);
        }
        return str + exp + ' ' + u.getName();
    }

    public Number getValue() {
        return value;
    }

    public Unit<Q> getUnit() {
        return unit;
    }

    public Scale getScale() {
        return scale;
    }
    
    @Override
    public boolean isEquivalentTo(Quantity<Q> that) {
        return this.compareTo(that) == 0;
    }
}
