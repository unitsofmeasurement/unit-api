/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import static javax.measure.test.TestUnit.TEST;
import static org.junit.Assert.*;

import javax.measure.Measurement;
import javax.measure.test.TestMeasurement;
import javax.measure.util.Range;

import org.junit.Before;
import org.junit.Test;

public class RangeTest {
	private Measurement<?, Double> min;
	private Measurement<?, Double> max;
	private Measurement<?, Double> res;
	@SuppressWarnings("rawtypes")
	private Range range;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void init() {
		min = new TestMeasurement(1d, TEST);
		max = new TestMeasurement(10d, TEST);
		res = new TestMeasurement(2d, TEST);
		
		range = Range.of(min, max, res);
	}
	
	@Test
	public void testGetMinimum() {
		assertEquals(min, range.getMinimum());
	}

	@Test
	public void testGetMaximum() {
		assertEquals(max, range.getMaximum());
	}

	@Test
	public void testGetResolution() {
		assertEquals(res, range.getResolution());
	}

	@Test
	public void testToString() {
		assertEquals("min= 1.0 TEST, max= 10.0 TEST, res= 2.0 TEST", range.toString());
	}

}
