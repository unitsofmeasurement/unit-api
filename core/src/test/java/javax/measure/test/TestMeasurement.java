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
 * @version 1.2, $Date: 2014-01-27 23:16:02 +0100 (Mo, 27 Jän 2014) $
 */
@SuppressWarnings("hiding")
final class TestMeasurement<Q extends Quantity<Q>, Number> implements
		Measurement<Q, Double> {

	private final Double val;
	private final Unit<Q> unit;
	
	public TestMeasurement(Double value, Unit<Q> unit) {
		this.val = value;
		this.unit = unit;
	}
	
	@Override
	public Unit<Q> getUnit() {
		return unit;
	}

	@Override
	public Double getValue() {
		return val;
	}

	@Override
	public Measurement<Q, Double> add(Measurement<Q, Double> that) {
		
		//TODO use shift on units?
		return new TestMeasurement<>(this.val + that.getValue().doubleValue(), this.unit);
	}

	@Override
	public Measurement<Q, Double> substract(Measurement<Q, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Double> multiply(Measurement<?, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Double> multiply(Double that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Double> divide(Measurement<?, Double> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Double> to(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Q, Double> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		return val + " " + unit;
	}

	@Override
	public Measurement<?, Double> divide(Double that) {
		// TODO Auto-generated method stub
		return null;
	}
}
