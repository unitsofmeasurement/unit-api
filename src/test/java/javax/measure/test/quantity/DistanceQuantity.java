/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.quantity;

import javax.measure.Measurement;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.Length;
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.VolumeUnit;

/**
 * @author Werner Keil
 * @version 0.3.2
 */
public class DistanceQuantity extends TestQuantity<Length> {

	public DistanceQuantity(double val, DistanceUnit un) {
		units = val;
		unit = un;
		scalar = val * unit.getMultFactor();
	}

	public DistanceQuantity() {
	}

	/*
	 * Distance(double val) {
	 *
	 * units = val; unit = m; // reference Unit scalar = val;
	 *
	 * }
	 */
	public DistanceQuantity add(DistanceQuantity d1) {
		DistanceQuantity dn = new DistanceQuantity();
		Object o = super.add(dn, this, d1, DistanceUnit.REF_UNIT);
		return (DistanceQuantity) o;
	}

	public DistanceQuantity subtract(DistanceQuantity d1) {
		DistanceQuantity dn = new DistanceQuantity();
		Object o = super.subtract(dn, this, d1, DistanceUnit.REF_UNIT);
		return (DistanceQuantity) o;
	}

	public boolean eq(DistanceQuantity d1) {
		return super.eq(d1);
	}

	public boolean ne(DistanceQuantity d1) {
		return super.ne(d1);
	}

	public boolean gt(DistanceQuantity d1) {
		return super.gt(d1);
	}

	public boolean lt(DistanceQuantity d1) {
		return super.lt(d1);
	}

	public boolean ge(DistanceQuantity d1) {
		return super.ge(d1);
	}

	public boolean le(DistanceQuantity d1) {
		return super.le(d1);
	}

	public DistanceQuantity multiply(double v) {
		return new DistanceQuantity(units * v, (DistanceUnit) unit);
	}

	public DistanceQuantity divide(double v) {
		return new DistanceQuantity(units / v, (DistanceUnit) unit);
	}

	// mixed type operations
	public AreaQuantity multiply(DistanceQuantity d1) {
		DistanceQuantity dq0 = convert(DistanceUnit.m);
		DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
		return new AreaQuantity(dq0.units * dq1.units, AreaUnit.sqmetre);
	}

	public VolumeQuantity multiply(AreaQuantity a1) {
		DistanceQuantity dq = convert(DistanceUnit.m);
		AreaQuantity aq = a1.convert(AreaUnit.sqmetre);
		return new VolumeQuantity(dq.units * aq.units, VolumeUnit.cumetre);
	}

	// public Speed divide(TimeInterval t1) {
	// return new Speed(scalar /
	// t1.scalar, Speed.refUnit);
	// }
	// public TimeInterval divide(Speed s1) {
	// return new TimeInterval(scalar /
	// s1.scalar, TimeInterval.refUnit);
	// }

	public DistanceQuantity convert(DistanceUnit newUnit) {
		return new DistanceQuantity(scalar / newUnit.getMultFactor(), newUnit);
	}

	public String showInUnits(DistanceUnit u, int precision) {
		return super.showInUnits(u, precision);
	}

	public Measurement<Length> add(Measurement<Length> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Length> subtract(
			Measurement<Length> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<?> divide(Quantity<?> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Length> to(Unit<Length> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<?> multiply(Measurement<?> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Length> subtract(Quantity<Length> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Length> add(Quantity<Length> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Length> divide(Number that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Length> inverse() {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<?> multiply(Quantity<?> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Length> multiply(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public int compareTo(Quantity<Length> o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
