/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.quantity;

import static javax.measure.test.unit.DistanceUnit.cm;

public class CircleInfo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DistanceQuantity radius = new DistanceQuantity(30, cm);
		System.out.println("Radius = " + radius);
		double mult = 2 * Math.PI;
		DistanceQuantity circumference = radius.multiply(mult);
		System.out.println("Circumference = " + circumference);
		AreaQuantity area = (radius.multiply(radius)).multiply(Math.PI);
		System.out.println("Area = " + area);
		// area.add(radius);
	}

}
