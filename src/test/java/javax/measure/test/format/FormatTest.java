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
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
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

import static org.junit.Assert.*;

import java.io.IOException;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.ParserException;
import javax.measure.format.UnitFormat;
import javax.measure.quantity.Length;
import javax.measure.quantity.Speed;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.SpeedUnit;
import javax.measure.test.unit.TimeUnit;

import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 *
 */
public class FormatTest {
  private Quantity<Length> sut;
  private UnitFormat format;

  @Before
  public void init() {
    sut = new DistanceQuantity(10, DistanceUnit.m);
    format = SimpleTestFormat.getInstance();
  }

  @Test
  public void testFormatKph() {
    Unit<Speed> kph = SpeedUnit.kmh;
    assertEquals("km/h", kph.toString());
  }

  @Test(expected = ParserException.class)
  public void testParseSimple() {
    Unit<?> u = format.parse("s");
    assertNotNull(u);
    assertEquals("s", u.getSymbol());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testFormatFromQuantity() {
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
  }

  @Test(expected = ParserException.class)
  public void testParseIrregularString() {
    Unit<?> u = format.parse("bl//^--1a");
  }

  @Test(expected = ParserException.class)
  public void testParserException() {
    throw new ParserException(new IllegalArgumentException());
  }

  @Test(expected = ParserException.class)
  public void testParserExceptionWithPosition() {
    ParserException pe = new ParserException("test", 1);
    assertEquals(1, pe.getPosition());
    assertEquals("test", pe.getParsedString());
    throw pe;
  }

  @Test(expected = ParserException.class)
  public void testParserExceptionWithNullString() {
    ParserException pe = new ParserException(null, 0);
    assertEquals(0, pe.getPosition());
    assertNull(pe.getParsedString());
    throw pe;
  }
}
