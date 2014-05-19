/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
/**
 * 
 */
package javax.measure.test;

import static org.junit.Assert.assertEquals;

import javax.measure.Measurement;
import javax.measure.quantity.Length;
import javax.measure.test.unit.DistanceUnit;

import org.junit.Test;


/**
 * @author Werner Keil
 * @version 1.0, $Date$
 * 
 */
public class TypeTest {

	@Test
	public void testStringMeasurement() {
		Measurement<Length, String> length = new StringMeasurement<>(
				"Ten", DistanceUnit.m);
		assertEquals("Ten", length.getValue());
	}

}
