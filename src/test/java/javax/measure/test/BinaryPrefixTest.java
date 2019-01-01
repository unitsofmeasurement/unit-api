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

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.quantity.Time;
import javax.measure.quantity.Volume;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.quantity.TestQuantities;
import javax.measure.test.quantity.VolumeQuantity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import static javax.measure.BinaryPrefix.*;
import static javax.measure.test.unit.AreaUnit.*;
import static javax.measure.test.unit.DistanceUnit.*;
import static javax.measure.test.unit.SpeedUnit.*;
import static javax.measure.test.unit.TimeUnit.*;
import static javax.measure.test.unit.VolumeUnit.*;

public class BinaryPrefixTest {
    @Test
    public void testKibi() {
        final Quantity<Length> m1 = new DistanceQuantity(1, m);
        final Unit<Length> km = KIBI(m);
        assertEquals("Ki", KIBI.getSymbol());
        assertEquals("KIBI", KIBI.getName());
        assertEquals(1d, m1.getValue());
        assertEquals("m * 1024.0", km.toString());
        if (km instanceof TestUnit) {
            @SuppressWarnings("rawtypes")
            TestUnit testKm = (TestUnit) km;
            assertEquals(1024d, testKm.getMultFactor());
        }
    }

    @Test
    public void testMebi() {
        assertEquals("Mi", MEBI.getSymbol());
        assertEquals("MEBI", MEBI.getName());
        Quantity<Time> t1 = TestQuantities.getQuantity(1.0, MEBI(s));
        assertNotNull(t1);
        assertEquals("1.0 s * 1048576.0", t1.toString());
    }

    @Test
    public void testExbi() {
        Quantity<Volume> v1 = new VolumeQuantity(1.0, litre);
        assertEquals(1d, v1.getValue());
        assertEquals("litre * 0.001", v1.getUnit().toString());

        Quantity<Volume> v2 = v1.to(EXBI(litre));
        assertNull(v2); // TODO temporary workaround
    }

    @Test
    public void testGibi() {
        assertEquals("Gi", GIBI.getSymbol());
        Quantity<Speed> s1 = TestQuantities.getQuantity(1.0, GIBI(mph));
        assertNotNull(s1);
        assertEquals("1.0 2.779789807058944E15", s1.toString());
    }

    @Test
    public void testTebi() {
        assertEquals("Ti", TEBI.getSymbol());
        Quantity<Volume> v1 = TestQuantities.getQuantity(1.0, TEBI(litre));
        assertNotNull(v1);
        assertEquals("1.0 1.099511627776E9", v1.toString());
    }

    @Test
    public void testPebi() {
        assertEquals("Pi", PEBI.getSymbol());
        Quantity<Area> a1 = TestQuantities.getQuantity(1.0, PEBI(acre));
        assertNotNull(a1);
        assertEquals("1.0 4.5565169229920993E18", a1.toString());
    }

    @Test
    public void testYobi() {
        assertEquals("Yi", YOBI.getSymbol());
        Quantity<Area> a1 = TestQuantities.getQuantity(1.0, YOBI(acre));
        assertNotNull(a1);
        assertEquals("1.0 4.892522791980404E27", a1.toString());
    }

    @Test
    public void testZebi() {
        assertEquals("Zi", ZEBI.getSymbol());
        Quantity<Area> a1 = TestQuantities.getQuantity(1.0, ZEBI(acre));
        assertNotNull(a1);
        assertEquals("1.0 4.7778542890433635E24", a1.toString());
    }
}
