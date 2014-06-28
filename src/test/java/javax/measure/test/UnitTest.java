/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import static org.junit.Assert.*;
import static javax.measure.test.TestUnit.TEST;

import javax.measure.Dimension;
import javax.measure.Unit;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Werner
 *
 */
public class UnitTest {
	@SuppressWarnings("rawtypes")
	private Unit sut;
	
	@Before
	public void init() {
		sut = TEST;
	}

	/**
	 * Test method for {@link javax.measure.test.TestUnit#getSymbol()}.
	 */
	@Test
	public void testGetSymbol() {
		assertNotNull(sut.getSymbol());
		assertEquals("t", sut.getSymbol());
	}

	/**
	 * Test method for {@link javax.measure.test.TestUnit#getDimension()}.
	 */
	@Test
	public void testGetDimension() {
		final Dimension dim = TestDimension.getInstance();
		assertEquals(dim, sut.getDimension());
	}

	/**
	 * Test method for {@link javax.measure.test.TestUnit#isCompatible(javax.measure.Unit)}.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIsCompatible() {
		assertTrue(sut.isCompatible(TEST));
	}

}
