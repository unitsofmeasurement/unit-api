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
import javax.measure.function.ValueSupplier;


/**
 * @author Werner Keil
 * @version 0.5
 */
public final class StringMeasurement<Q extends Quantity<Q>> implements
		Measurement<Q>, ValueSupplier<String> {
	private final String v;
	private final Unit<Q> u;

	public StringMeasurement(String value, Unit<Q> unit) {
		this.v = value;
		this.u = unit;
	}

    public Measurement<Q> to(Unit<Q> unit) {
		return new StringMeasurement<Q>(v, unit);
	}

    public Unit<Q> getUnit() {
		return u;
	}

    public String getValue() {
		return v;
	}

	
	public String toString() {
		return v + " " + u.getSymbol();
	}

	public int compareTo(Measurement<Q> o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
