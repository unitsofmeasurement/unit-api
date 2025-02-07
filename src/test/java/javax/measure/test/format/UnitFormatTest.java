/*
 * Units of Measurement API
 * Copyright (c) 2014-2025, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure.test.format;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.MeasurementParseException;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.SpeedUnit;
import javax.measure.test.unit.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 *
 */
public class UnitFormatTest {
    private Quantity<Length> sut;
    private UnitFormat format;

    @BeforeEach
    public void init() {
        sut = new DistanceQuantity(10, DistanceUnit.m);
        format = SimpleTestUnitFormat.getInstance();
    }

    @Test
    public void testFormatKph() {
        Unit<Speed> kph = SpeedUnit.kmh;
        assertEquals("km/h", kph.toString());
    }

    @Test
    public void testParseSimple() {
        assertThrows(MeasurementParseException.class, () -> {
            Unit<?> u = format.parse("s");
            assertNotNull(u);
            assertEquals("s", u.getSymbol());
        });
    }

    @Test
    public void testFormatFromQuantity() {
        assertThrows(IllegalArgumentException.class, () -> {
            final Appendable a = new StringBuilder();
            try {
                format.format(DistanceUnit.m, a);
            } catch (IOException e) {
                fail(e.getMessage());
            }
            assertEquals(DistanceUnit.m, sut.getUnit());
            assertEquals("m", a.toString());

            final Appendable a2 = new StringBuilder();
            @SuppressWarnings("unchecked")
            Unit<Speed> v = (Unit<Speed>) sut.getUnit().divide(TimeUnit.s);
            try {
                format.format(v, a2);
            } catch (IOException e) {
                fail(e.getMessage());
            }
            assertEquals("m/s", a2.toString());
        });

    }

    @Test
    public void testParseIrregularString() {
        assertThrows(MeasurementParseException.class, () -> {
            @SuppressWarnings("unused")
            Unit<?> u = format.parse("bl//^--1a");
        });
    }

    @Test
    public void testParserException() {
        assertThrows(MeasurementParseException.class, () -> {
            throw new MeasurementParseException(new IllegalArgumentException());
        });
    }

    @Test
    public void testParserExceptionWithPosition() {
        MeasurementParseException pe = assertThrows(MeasurementParseException.class, () -> {
            throw new MeasurementParseException("test", 1);
        });
        assertEquals(1, pe.getPosition());
        assertEquals("test", pe.getParsedString());
    }

    @Test
    public void testParserExceptionWithNullString() {
        final MeasurementParseException pe = assertThrows(MeasurementParseException.class, () -> {
            throw new MeasurementParseException(null, 0);
        });
        assertEquals(0, pe.getPosition());
        assertNull(pe.getParsedString());
    }

    @Test
    public void testLocalSensitive() {
        assertFalse(format.isLocaleSensitive());
    }

    @Test
    public void testMoreLocalSensitive() {
        final UnitFormat simple = SimpleTestUnitFormat.getInstance();
        assertFalse(simple.isLocaleSensitive());
    }
}
