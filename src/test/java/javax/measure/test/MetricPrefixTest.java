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
import static org.junit.jupiter.api.Assertions.assertNull;

import static javax.measure.MetricPrefix.*;
import static javax.measure.test.unit.AreaUnit.*;
import static javax.measure.test.unit.DistanceUnit.*;
import static javax.measure.test.unit.SpeedUnit.*;
import static javax.measure.test.unit.TimeUnit.*;
import static javax.measure.test.unit.VolumeUnit.*;

public class MetricPrefixTest {
    @Test
    public void testAtto() {
        assertEquals("a", ATTO.getSymbol());
        assertEquals("ATTO", ATTO.getName());
        Quantity<Time> t1 = TestQuantities.getQuantity(1.0, ATTO(min));
        assertEquals("min * 6.0E-17", t1.getUnit().toString());
    }

    @Test
    public void testCenti() {
        assertEquals("c", CENTI.getSymbol());
        assertEquals("CENTI", CENTI.getName());
        Quantity<Length> l1 = TestQuantities.getQuantity(1.0, CENTI(m));
        assertEquals("m * 0.01", l1.getUnit().toString());
    }

    @Test
    public void testDeci() {
        Quantity<Volume> m1 = new VolumeQuantity(1.0, litre);
        assertEquals(1d, m1.getValue());
        assertEquals("litre * 0.001", m1.getUnit().toString());

        Quantity<Volume> m2 = m1.to(DECI(litre));
        assertNull(m2); // TODO temporary workaround
    }

    @Test
    public void testDeka() {
        assertEquals("da", DEKA.getSymbol());
        Quantity<Volume> v1 = TestQuantities.getQuantity(1.0, DEKA(litre));
        assertEquals("0.01", v1.getUnit().toString());
    }

    @Test
    public void testExa() {
        assertEquals("E", EXA.getSymbol());
        Quantity<Length> l1 = TestQuantities.getQuantity(1.0, EXA(m));
        assertEquals("m * 1.0E+18", l1.getUnit().toString());
    }

    @Test
    public void testFemto() {
        assertEquals("f", FEMTO.getSymbol());
        Quantity<Time> t1 = TestQuantities.getQuantity(1.0, FEMTO(s));
        assertEquals("s * 1.0E-15", t1.getUnit().toString());
    }

    @Test
    public void testGiga() {
        assertEquals("G", GIGA.getSymbol());
        Quantity<Area> a1 = TestQuantities.getQuantity(1.0, GIGA(acre));
        assertEquals("4.047E+12", a1.getUnit().toString());
    }

    @Test
    public void testHecto() {
        assertEquals("h", HECTO.getSymbol());
        Quantity<Volume> v1 = TestQuantities.getQuantity(1.0, HECTO(litre));
        assertEquals("0.1", v1.getUnit().toString());
    }

    @Test
    public void testKilo() {
        final Quantity<Length> m1 = new DistanceQuantity(1, m);
        final Unit<Length> km = KILO(m);
        assertEquals("k", KILO.getSymbol());
        assertEquals(1d, m1.getValue());
        assertEquals("m * 1000.0", km.toString());
        if (km instanceof TestUnit) {
            @SuppressWarnings("rawtypes")
            final TestUnit testKm = (TestUnit) km;
            assertEquals(1000d, testKm.getMultFactor());
        }
    }

    @Test
    public void testMega() {
        assertEquals("M", MEGA.getSymbol());
        Quantity<Volume> v1 = TestQuantities.getQuantity(1.0, MEGA(litre));
        assertEquals("1000.0", v1.getUnit().toString());
    }

    @Test
    public void testMilli() {
        Quantity<Volume> m1 = TestQuantities.getQuantity(10, MILLI(litre));
        assertEquals(10d, m1.getValue());
        assertEquals("0.0000010", m1.getUnit().toString());
    }

    @Test
    public void testMicro() {
        assertEquals("\\u00b5", toUnicode(MICRO.getSymbol().charAt(0)));
        assertEquals("\u00b5", MICRO.getSymbol());
        Quantity<Length> m1 = TestQuantities.getQuantity(1.0, m);
        assertEquals(1d, m1.getValue());
        assertEquals("m", m1.getUnit().getSymbol());

        Quantity<Length> m2 = m1.to(MICRO(m));
        assertNull(m2); // TODO temporary workaround
    }

    @Test
    public void testNano() {
        Quantity<Length> m1 = TestQuantities.getQuantity(1.0, m);
        assertEquals(1d, m1.getValue());
        assertEquals("m", m1.getUnit().getSymbol());

        Quantity<Length> m2 = m1.to(NANO(m));
        assertNull(m2); // TODO temporary workaround
    }

    @Test
    public void testPeta() {
        assertEquals("P", PETA.getSymbol());
        Quantity<Speed> s1 = TestQuantities.getQuantity(10, PETA(kmh));
        assertEquals(10d, s1.getValue());
        assertEquals("1.0E+15", s1.getUnit().toString());
    }

    @Test
    public void testPico() {
        assertEquals("p", PICO.getSymbol());
        Quantity<Volume> v1 = TestQuantities.getQuantity(10, PICO(litre));
        assertEquals(10d, v1.getValue());
        assertEquals("1.0E-15", v1.getUnit().toString());
    }

    @Test
    public void testTera() {
        assertEquals("T", TERA.getSymbol());
        Quantity<Length> l1 = TestQuantities.getQuantity(10, TERA(m));
        assertEquals(10d, l1.getValue());
        assertEquals("m * 1.0E+12", l1.getUnit().toString());
    }

    @Test
    public void testYocto() {
        assertEquals("y", YOCTO.getSymbol());
        Quantity<Volume> v1 = TestQuantities.getQuantity(10, YOCTO(litre));
        assertEquals(10d, v1.getValue());
        assertEquals("9.999999999999999E-28", v1.getUnit().toString());
    }

    @Test
    public void testYotta() {
        assertEquals("Y", YOTTA.getSymbol());
        Quantity<Area> a1 = TestQuantities.getQuantity(10, YOTTA(sqmetre));
        assertEquals(10d, a1.getValue());
        assertEquals("1.0E+24", a1.getUnit().toString());
    }

    @Test
    public void testZepto() {
        assertEquals("z", ZEPTO.getSymbol());
        Quantity<Time> t1 = TestQuantities.getQuantity(10, ZEPTO(s));
        assertEquals(10d, t1.getValue());
        assertEquals("s * 1.0E-21", t1.getUnit().toString());
    }

    @Test
    public void testZetta() {
        assertEquals("Z", ZETTA.getSymbol());
        Quantity<Length> l1 = TestQuantities.getQuantity(10, ZETTA(m));
        assertEquals(10d, l1.getValue());
        assertEquals("m * 1.0E+21", l1.getUnit().toString());
    }

    private static String toUnicode(char ch) {
        return String.format("\\u%04x", (int) ch);
    }
}
