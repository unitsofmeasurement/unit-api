/*
 * Units of Measurement API
 * Copyright (c) 2014-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import javax.measure.Unit;
import javax.measure.quantity.Volume;
import javax.measure.test.TestUnit;

/**
 * @author Werner Keil
 */
public class VolumeUnit extends TestUnit<Volume> {
    public static final VolumeUnit cumetre = new VolumeUnit("cumetre", 1.0); // reference
    // Unit
    public static final VolumeUnit REF_UNIT = cumetre; // reference Unit
    public static final VolumeUnit cumile = new VolumeUnit("cumile", 1609.0 * 1609.0 * 1609.0);
    public static final VolumeUnit bushel = new VolumeUnit("bushel", 0.03524);
    public static final VolumeUnit litre = new VolumeUnit("litre", 0.001);
    public static final VolumeUnit cc = new VolumeUnit("cc", 1.0e-6);

    public VolumeUnit(String name2, double convF) {
        super(name2);
        multFactor = convF;
    }

    @Override
    public Unit<Volume> getSystemUnit() {
        return REF_UNIT;
    }
}
