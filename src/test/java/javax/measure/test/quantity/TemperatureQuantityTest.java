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
package javax.measure.test.quantity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.measure.Quantity;
import javax.measure.quantity.Temperature;
import javax.measure.test.unit.TemperatureUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Werner Keil
 */
public class TemperatureQuantityTest {

  private TemperatureQuantity temp;
  private TemperatureUnit k;

  @Before
  public void setUp() {
    k = TemperatureUnit.KELVIN;
    temp = new TemperatureQuantity(100, k);
  }

  @Test
  public void testQuantity() {
    assertNotNull(temp);
  }

  @Test
  public void testAdd() {
    TemperatureQuantity temp2 = new TemperatureQuantity(50, k);
    TemperatureQuantity result = temp.add(temp2);
    assertEquals(150d, result.scalar, 0);
  }

  @Test
  public void testSubtract() {
    TemperatureQuantity temp2 = new TemperatureQuantity(50, k);
    TemperatureQuantity result = temp.subtract(temp2);
    assertEquals(50d, result.scalar, 0);
  }

  @Test
  public void testEq() {
    TemperatureQuantity temp2 = new TemperatureQuantity(100, k);
    assertTrue(temp2.eq(temp));
  }

  @Test
  public void testGt() {
    TemperatureQuantity temp2 = new TemperatureQuantity(120, k);
    assertTrue(temp2.gt(temp));
  }

  @Test
  public void testLt() {
    TemperatureQuantity temp2 = new TemperatureQuantity(20, k);
    assertTrue(temp2.lt(temp));
  }

  @Test
  public void testGe() {
    TemperatureQuantity temp2 = new TemperatureQuantity(120, k);
    assertTrue(temp2.ge(temp));
    temp2 = new TemperatureQuantity(100, k);
    assertTrue(temp2.ge(temp));
  }

  @Test
  public void testLe() {
    TemperatureQuantity temp2 = new TemperatureQuantity(20, k);
    assertTrue(temp2.le(temp));
    temp2 = new TemperatureQuantity(100, k);
    assertTrue(temp2.le(temp));
  }

  @Test
  public void testMultiplyDouble() {
    Quantity<Temperature> result = temp.multiply(3d);
    assertEquals(300d, result.getValue());
  }

  @Test
  public void testDivideDouble() {
    TemperatureQuantity result = temp.divide(10d);
    assertEquals(10d, result.scalar, 0d);
  }

  @Test
  public void testConvert() {
    TemperatureQuantity result = temp.convert(TemperatureUnit.KELVIN);
    assertEquals(100d, result.scalar, 0d);
  }

  @Test
  public void testToSystemUnit() {
    assertEquals(temp.toSystemUnit(), temp.to(temp.getUnit().getSystemUnit()));
  }

  @Test
  public void testNegate() {
    assertEquals(temp.negate().getValue(), -temp.getValue().doubleValue());
  }
  
  @Test
  public void testScale() {
      assertEquals(Quantity.Scale.ABSOLUTE, temp.getScale());
  }
  
  @Test
  public void testLevelCelsius() {
    TemperatureQuantity temp2 = new TemperatureQuantity(20, TemperatureUnit.CELSIUS);
    assertEquals(Quantity.Scale.RELATIVE, temp2.getScale());
  }
  
  @Test
  public void testLevelFahrenheit() {
    TemperatureQuantity temp2 = new TemperatureQuantity(60, TemperatureUnit.FAHRENHEIT);
    assertEquals(Quantity.Scale.RELATIVE, temp2.getScale());
  }
  
  @Test
  public void testAbsolute() {
      assertEquals(Quantity.Scale.ABSOLUTE, temp.getScale());
  }
}
