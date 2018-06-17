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
import javax.measure.quantity.Length;
import javax.measure.quantity.Volume;
import javax.measure.test.TestUnit;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.quantity.TestQuantities;
import javax.measure.test.quantity.VolumeQuantity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import static javax.measure.MetricPrefix.*;
import static javax.measure.test.unit.DistanceUnit.*;
import static javax.measure.test.unit.VolumeUnit.*;

public class MetricPrefixTest {
  @Test
  public void testKilo() {
    final Quantity<Length> m1 = new DistanceQuantity(1, m);
    final Unit<Length> km = KILO(m);
    assertEquals("k", KILO.getSymbol());
    assertEquals(1d, m1.getValue());
    assertEquals("m * 1000.0", km.toString());
    if (km instanceof TestUnit) {
      TestUnit testKm = (TestUnit) km;
      assertEquals(1000d, testKm.getMultFactor(), 0);
    }
  }

  @Test
  public void testMega() {
    assertEquals("M", MEGA.getSymbol());
    Quantity<Volume> v1 = TestQuantities.getQuantity(1.0, MEGA(litre));
    assertEquals("1000.0", v1.getUnit().toString());
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
  public void testMilli() {
    Quantity<Volume> m1 = TestQuantities.getQuantity(10, MILLI(litre));
    assertEquals(10d, m1.getValue());
    assertEquals("1.0E-6", m1.getUnit().toString());
  }

  @Test
  public void testMicro() {
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
}
