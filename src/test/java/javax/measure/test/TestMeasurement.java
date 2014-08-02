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
 * @version 0.3, $Date: 2014-07-01 $
 */
@SuppressWarnings("hiding")
final class TestMeasurement<Q extends Quantity<Q>> implements
		Measurement<Q, Double> {

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

	public Measurement<Q, Double> add(Measurement<Q, Double> that) {
		
		//TODO use shift on units?
		return new TestMeasurement<Q>(this.val + that.getValue(), this.unit);
	}

	public Measurement<Q, Double> subtract(Measurement<Q, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q, Double> to(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q, Double> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return val + " " + unit;
	}

	public Measurement<Q, Double> multiply(Double that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q, Double> divide(Double that) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public TestMeasurement<?> multiply(Measurement<?, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q, Double> substract(Measurement<Q, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}
}
