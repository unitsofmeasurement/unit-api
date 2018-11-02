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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.measure.Quantity;
import javax.measure.quantity.Area;
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Werner Keil
 */
public class DistanceQuantityTest {

  DistanceQuantity distance;
  DistanceUnit m;

  @Before
  public void setUp() {
    m = DistanceUnit.m;
    distance = new DistanceQuantity(100, m);
  }

  @Test
  public void testAreaQuantity() {
    assertNotNull(distance);
  }

  @Test
  public void testAdd() {
    DistanceQuantity dist2 = new DistanceQuantity(50, m);
    DistanceQuantity result = distance.add(dist2);
    assertEquals(150d, result.scalar, 0);
  }

  @Test
  public void testSubtract() {
    DistanceQuantity dist2 = new DistanceQuantity(50, m);
    DistanceQuantity result = distance.subtract(dist2);
    assertEquals(50d, result.scalar, 0);
  }

  @Test
  public void testEq() {
    DistanceQuantity dist2 = new DistanceQuantity(100, m);
    assertTrue(dist2.eq(distance));
  }

  @Test
  public void testGt() {
    DistanceQuantity dist2 = new DistanceQuantity(120, m);
    assertTrue(dist2.gt(distance));
  }

  @Test
  public void testLt() {
    DistanceQuantity dist2 = new DistanceQuantity(20, m);
    assertTrue(dist2.lt(distance));
  }

  @Test
  public void testGe() {
    DistanceQuantity dist2 = new DistanceQuantity(120, m);
    assertTrue(dist2.ge(distance));
    dist2 = new DistanceQuantity(100, m);
    assertTrue(dist2.ge(distance));
  }

  @Test
  public void testLe() {
    DistanceQuantity dist2 = new DistanceQuantity(20, m);
    assertTrue(dist2.le(distance));
    dist2 = new DistanceQuantity(100, m);
    assertTrue(dist2.le(distance));
  }

  @Test
  public void testMultiplyDouble() {
    DistanceQuantity result = distance.multiply(3d);
    assertEquals(300d, result.scalar, 0d);
  }

  @Test
  public void testDivideDouble() {
    DistanceQuantity result = distance.divide(10d);
    assertEquals(10d, result.scalar, 0d);
  }

  @Test
  public void testMultiplyDistanceQuantity() {
    DistanceQuantity dist = new DistanceQuantity(15, DistanceUnit.m);
    AreaQuantity result = distance.multiply(dist);
    assertEquals(AreaUnit.class, result.getUnit().getClass());
    assertEquals(AreaQuantity.class, result.getClass());
    assertEquals(Area.class, result.getType());
    assertEquals(1500d, result.getValue());
  }

  @Test
  public void testConvert() {
    DistanceQuantity result = distance.convert(DistanceUnit.in);
    assertEquals(100d, result.scalar, 0d);
  }

  @Test
  public void testShowInUnits() {
    String result = distance.showInUnits(DistanceUnit.mile, 2);
    assertEquals("0.062150403977625855 mile", result);
  }

  @Test
  public void testToSystemUnit() {
    assertEquals(distance.toSystemUnit(), distance.to(distance.getUnit().getSystemUnit()));
  }

  @Test
  public void testNegate() {
    assertEquals(distance.negate().getValue(), -distance.getValue().doubleValue());
  }
  
/*  @Test
  public void testAbsolute() {
    assertEquals(Quantity.Scale.ABSOLUTE, distance.getScale());
  }*/
  
  @Test
  public void testLevelNumeric() {
    assertTrue(distance.getLevel().isNumeric());
  }
}
