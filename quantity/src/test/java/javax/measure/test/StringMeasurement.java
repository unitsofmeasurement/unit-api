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

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;


/**
 * @author Werner Keil
 * @version 1.1
 */
@SuppressWarnings("hiding")
public final class StringMeasurement<Q extends Quantity<Q>, String> implements
		Measurement<Q, String> {
	private String v;
	private Unit<Q> u;

	public StringMeasurement(String value, Unit<Q> unit) {
		this.v = value;
		this.u = unit;
	}

	public Measurement<Q, String> add(Measurement<Q, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<Q, String> substract(Measurement<Q, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, String> multiply(Measurement<?, String> that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, String> multiply(String that) {
		// TODO Auto-generated method stub
		return null;
	}


	public Measurement<?, String> divide(Measurement<?, String> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Q, String> to(Unit<Q> unit) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public double doubleValue(Unit<Q> unit) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public long longValue(Unit<Q> unit) {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public Unit<Q> getUnit() {
		return u;
	}

	@Override
	public String getValue() {
		return v;
	}

	@Override
	public Measurement<Q, String> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, String> divide(String that) {
		// TODO Auto-generated method stub
		return null;
	}

}
