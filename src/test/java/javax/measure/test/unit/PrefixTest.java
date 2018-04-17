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
package javax.measure.test.unit;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Area;
import javax.measure.quantity.Length;
import javax.measure.quantity.Mass;
import javax.measure.quantity.Volume;
import javax.measure.test.TestUnit;
import javax.measure.test.quantity.AreaQuantity;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.quantity.VolumeQuantity;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import static javax.measure.test.unit.AreaUnit.*;
import static javax.measure.test.unit.DistanceUnit.*;
import static javax.measure.test.unit.VolumeUnit.*;
import static javax.measure.spi.BinaryPrefix.*;
import static javax.measure.spi.MetricPrefix.*;

public class PrefixTest {
  @Test
  public void testKilo() {
    final Quantity<Length> m1 = new DistanceQuantity(1, m);
    final Unit<Length> km = m.multiply(KILO.getFactor().doubleValue());
    assertEquals("k", KILO.getSymbol());
    assertEquals(1d, m1.getValue());
    assertEquals("m", km.toString());
    if (km instanceof TestUnit) {
      TestUnit testKm = (TestUnit) km;
      assertEquals(1000d, testKm.getMultFactor(), 0);
    }
  }

  @Test
  public void testMega() {
    assertEquals("M", MEGA.getSymbol());
    // Quantity<Volume> m1 = new VolumeQuantity(1.0, MEGA(litre));
    // assertEquals(1d, m1.getValue());
    // assertEquals("Mg", m1.getUnit().toString());
  }

  @Test
  public void testDeci() {
    Quantity<Volume> m1 = new VolumeQuantity(1.0, litre);
    assertEquals(1d, m1.getValue());
    assertEquals("litre", m1.getUnit().toString());

    Quantity<Volume> m2 = m1.to(DECI(litre));
    // assertEquals(10.0d, m2.getValue());
    // assertEquals("dl", m2.getUnit().toString());
    assertNull(m2); // TODO temporary workaround
  }
  /*
    @Test
    public void testMilli() {
      Quantity<Mass> m1 = Quantities.getQuantity(1.0, MILLI(Units.GRAM));
      assertEquals(1d, m1.getValue());
      assertEquals("mg", m1.getUnit().toString());
    }

    @Test
    public void testMilli2() {
      Quantity<Volume> m1 = Quantities.getQuantity(10, MILLI(litre));
      assertEquals(10, m1.getValue());
      assertEquals("ml", m1.getUnit().toString());
    }

    @Test
    public void testMilli3() {
      Quantity<Volume> m1 = Quantities.getQuantity(1.0, litre);
      assertEquals(1d, m1.getValue());
      assertEquals("l", m1.getUnit().toString());

      Quantity<Volume> m2 = m1.to(MILLI(litre));
      assertEquals(1000.0d, m2.getValue());
      assertEquals("ml", m2.getUnit().toString());
    }

    @Test
    public void testMilli4() {
      Quantity<Volume> m1 = Quantities.getQuantity(1.0, MILLI(litre));
      assertEquals(1d, m1.getValue());
      assertEquals("ml", m1.getUnit().toString());

      Quantity<Volume> m2 = m1.to(litre);
      assertEquals(0.001d, m2.getValue());
      assertEquals("l", m2.getUnit().toString());
    }

    @Test
    public void testMicro2() {
      Quantity<Length> m1 = Quantities.getQuantity(1.0, Units.METRE);
      assertEquals(1d, m1.getValue());
      assertEquals("m", m1.getUnit().toString());

      Quantity<Length> m2 = m1.to(MICRO(Units.METRE));
      assertEquals(1000000.0d, m2.getValue());
      assertEquals("µm", m2.getUnit().toString());
    }

    @Test
    public void testNano() {
      Quantity<Mass> m1 = Quantities.getQuantity(1.0, Units.GRAM);
      assertEquals(1d, m1.getValue());
      assertEquals("g", m1.getUnit().toString());

      Quantity<Mass> m2 = m1.to(NANO(Units.GRAM));
      assertEquals(1000000000.0d, m2.getValue());
      assertEquals("ng", m2.getUnit().toString());
    }

    @Test
    public void testNano2() {
      Quantity<Length> m1 = Quantities.getQuantity(1.0, Units.METRE);
      assertEquals(1d, m1.getValue());
      assertEquals("m", m1.getUnit().toString());

      Quantity<Length> m2 = m1.to(NANO(Units.METRE));
      assertEquals(1000000000.0d, m2.getValue());
      assertEquals("nm", m2.getUnit().toString());
    }

    @Test
    public void testHashMapAccessingMap() {
      assertThat(litre.toString(), is("l"));
      assertThat(MILLI(litre).toString(), is("ml"));
      assertThat(MILLI(GRAM).toString(), is("mg"));
    }

    @Test
    public void testSingleOperation() {
      assertEquals(MICRO(GRAM), GRAM.divide(1000000));
    }

    @Test
    public void testNestedOperationsNotTheSame() {
      Unit<Mass> m1 = MICRO(GRAM);
      Unit<Mass> m2 = GRAM.divide(1000).divide(2000);
      UnitConverter c1 = m1.getConverterTo(m2);
      List steps1 = c1.getConversionSteps();
      UnitConverter c2 = m2.getConverterTo(m1);
      List steps2 = c2.getConversionSteps();
      assertNotEquals(c1, c2);
      assertNotEquals(m1, m2);
    }
    
    @Test
    public void testKibi() {
      final UnitConverter expected = new RationalConverter(128, 125);
      final UnitConverter actual = KIBI(METRE).getConverterTo(KILO(METRE));
      assertEquals("Ki", KIBI.getSymbol());
      assertEquals(expected, actual);
    }

    @Test
    public void testMebi() {
      final UnitConverter expected = new RationalConverter(8, 15625);
      final UnitConverter actual = MEBI(METRE).getConverterTo(MEGA(METRE));
      assertEquals(expected, actual);
    }

    @Test
    public void testGibi() {
      final UnitConverter expected = new RationalConverter(2, 5859375);
      final UnitConverter actual = GIBI(METRE).getConverterTo(GIGA(METRE));
      assertEquals(expected, actual);
    }

    @Test
    public void testTebi() {
      final UnitConverter expected = new RationalConverter(1, 3906250000l);
      final UnitConverter actual = TEBI(litre).getConverterTo(TERA(litre));
      assertEquals(expected, actual);
    }

    @Test
    public void testPebi() {
      final UnitConverter expected = new RationalConverter(1, 4882812500000L);
      final UnitConverter actual = PEBI(litre).getConverterTo(PETA(litre));
      assertEquals(expected, actual);
    }
    
    @Test
    public void testZebi() {
      final UnitConverter expected = new RationalConverter(1, 6835937500000000000L);
      final UnitConverter actual = ZEBI(GRAM).getConverterTo(ZETTA(GRAM));
      assertEquals(expected, actual);
    }
    
    @Test
    public void testYobi() {
      final UnitConverter expected = new RationalConverter(BigInteger.ONE, 
      		  BigDecimal.valueOf(7812500000000000000000D).toBigInteger());
      final UnitConverter actual = YOBI(GRAM).getConverterTo(YOTTA(GRAM));
      assertEquals(expected, actual);
    }
    */
}
