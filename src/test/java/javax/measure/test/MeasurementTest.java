/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import static org.junit.Assert.*;
import static javax.measure.test.EnumUnit.TEST;

import javax.measure.Measurement;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Werner Keil
 *
 */
public class MeasurementTest {

	private Measurement<?> sut;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void init() {
		sut = new TestMeasurement(20d, TEST);
	}

	@Test
	public void testGetUnit() {
		assertEquals(TEST, sut.getUnit());
	}

//	@Test
//	public void testGetValue() {
//		assertEquals(Double.valueOf(20d), sut.getValue());
//	}

//	@Test
//	public void testAdd() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testSubstract() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMultiplyMeasurementOfQDouble() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testMultiplyDouble() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testDivide() {
//		fail("Not yet implemented");
//	}

}
