/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;


/**
 * @author Werner Keil
 * @version 0.4.1, $Date: 2014-09-18 $
 */
final class TestMeasurement<Q extends Quantity<Q>> implements
		Measurement<Q> {

	private final Double val;
	private final Unit<Q> unit;

	public TestMeasurement(Double value, Unit<Q> unit) {
		this.val = value;
		this.unit = unit;
	}

    public Unit<Q> getUnit() {
		return unit;
	}

	public Double getValue() {
		return val;
	}

    public Measurement<Q> to(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return null;
	}


	public String toString() {
		return val + " " + unit;
	}

	public Measurement<Q> multiply(Double that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q> divide(Double that) {
		// TODO Auto-generated method stub
		return null;
	}

	public TestMeasurement<?> multiply(Measurement<?> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q> substract(Measurement<Q> that) {
		// TODO Auto-generated method stub
		return null;
	}
}
