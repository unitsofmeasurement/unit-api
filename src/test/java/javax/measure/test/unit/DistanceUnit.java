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
package javax.measure.test.unit;

import java.math.BigDecimal;

import javax.measure.Unit;
import javax.measure.quantity.Length;

/**
 * @author Werner Keil
 */
public class DistanceUnit extends BaseUnit<Length> {

    public static final DistanceUnit m = new DistanceUnit("m", 1.0); // reference
    // Unit
    public static final DistanceUnit REF_UNIT = m; // reference Unit
    public static final DistanceUnit in = new DistanceUnit("in", 0.0254);
    public static final DistanceUnit km = new DistanceUnit("km", 1.0e+3);
    public static final DistanceUnit cm = new DistanceUnit("cm", 1.0e-2);
    public static final DistanceUnit mile = new DistanceUnit("mile", 1609.0);
    public static final DistanceUnit \u00C5ngstr\u00F6m = new DistanceUnit("\u00C5ngstr\u00F6m", 1.0e-10);
    public static final DistanceUnit AU = new DistanceUnit("AU", 1.5e+11);
    public static final DistanceUnit parsec = new DistanceUnit("parsec", 3.08e+16);

    public DistanceUnit(String name2, double convF) {
        super(name2, name2);
        multFactor = BigDecimal.valueOf(convF);
    }

    public DistanceUnit(String name2, DistanceUnit unit, double convF) {
        super("", name2);
        multFactor = unit.multFactor.multiply(BigDecimal.valueOf(convF));
    }

    @Override
    public Unit<Length> getSystemUnit() {
        return REF_UNIT;
    }
}
