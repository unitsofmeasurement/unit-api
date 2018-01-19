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
package javax.measure.test.format;

import static org.junit.Assert.*;

import javax.measure.Quantity;
import javax.measure.format.ParserException;
import javax.measure.format.QuantityFormat;
import javax.measure.quantity.Length;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.unit.DistanceUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 *
 */
public class QuantityFormatTests {
  private Quantity<Length> sut;
  private QuantityFormat format;

  @Before
  public void init() {
    sut = new DistanceQuantity(10, DistanceUnit.m);
    format = DefaultTestQuantityFormat.getInstance();
  }

  @Test
  public void testParseSimple() {
    Quantity<?> q = format.parse("1 s");
    assertNotNull(q);
    assertEquals("one", q.getUnit().getSymbol()); // TODO check why this is not s?
    assertEquals(1d, q.getValue());
  }

  @Test(expected = ParserException.class)
  public void testParseIrregularString() {
    Quantity<?> u = format.parse("bl//^--1a");
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
