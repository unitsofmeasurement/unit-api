/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import static org.junit.Assert.*;

import javax.measure.Dimension;
import org.junit.Before;
import org.junit.Test;

public class DimensionTest {
	private Dimension sut;
	
	@Before
	public void init() {
		sut = TestDimension.getInstance();
	}

	@Test
	public void testGetInstance() {
		Dimension dim = TestDimension.getInstance();
		assertNotNull(dim);
	}

	@Test
	public void testMultiply() {
		Dimension dim = TestDimension.getInstance();
		Dimension result = sut.multiply(dim);
		assertNotNull(result);
	}

	@Test
	public void testDivide() {
		Dimension dim = TestDimension.getInstance();
		Dimension result = sut.divide(dim);
		assertNotNull(result);
	}

	@Test
	public void testPow() {
		Dimension result = sut.pow(2);
		assertNotNull(result);
	}

	@Test
	public void testRoot() {
		Dimension result = sut.root(2);
		assertNotNull(result);
	}

	@Test
	public void testGetProductDimensions() {
		assertNotNull(sut.getProductDimensions());
		assertEquals(1, sut.getProductDimensions().size());
	}

}
