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
import javax.measure.quantity.Information;
import javax.measure.test.unit.BitRateUnit;
import javax.measure.test.unit.BitUnit;

/**
 * @author Werner Keil
 * @version 0.5.4
 */
public class BitQuantity extends TestQuantity<Information> {
    public BitQuantity() {
    	super(Information.class);
    }
    
	public BitQuantity(double val, BitUnit un) {
		this();
		units = val;
		unit = un;
		scalar = val * unit.getMultFactor();
	}

	public BitQuantity add(BitQuantity d1) {
		BitQuantity dn = new BitQuantity();
		Object o = super.add(dn, this, d1, BitUnit.REF_UNIT);
		return (BitQuantity) o;
	}

	public BitQuantity subtract(BitQuantity d1) {
		BitQuantity dn = new BitQuantity();
		Object o = super.subtract(dn, this, d1, BitUnit.REF_UNIT);
		return (BitQuantity) o;
	}

	public boolean eq(BitQuantity d1) {
		return super.eq(d1);
	}

	public boolean ne(BitQuantity d1) {
		return super.ne(d1);
	}

	public boolean gt(BitQuantity d1) {
		return super.gt(d1);
	}

	public boolean lt(BitQuantity d1) {
		return super.lt(d1);
	}

	public boolean ge(BitQuantity d1) {
		return super.ge(d1);
	}

	public boolean le(BitQuantity d1) {
		return super.le(d1);
	}

	public BitQuantity multiply(double v) {
		return new BitQuantity(units * v, (BitUnit) unit);
	}

	public BitQuantity divide(double v) {
		return new BitQuantity(units / v, (BitUnit) unit);
	}

	// mixed type operations
	// public AreaQuantity multiply(BitQuantity d1) {
	// BitQuantity dq0 = convert(DistanceUnit.m);
	// BitQuantity dq1 = d1.convert(DistanceUnit.m);
	// return new AreaQuantity(dq0.units * dq1.units, AreaUnit.sqmetre);
	// }
	//
	// public VolumeQuantity multiply(AreaQuantity a1) {
	// BitQuantity dq = convert(DistanceUnit.m);
	// AreaQuantity aq = a1.convert(AreaUnit.sqmetre);
	// return new VolumeQuantity(dq.units * aq.units, VolumeUnit.cumetre);
	// }
	// public Speed divide(TimeInterval t1) {
	// return new Speed(scalar /
	// t1.scalar, Speed.refUnit);
	// }
	// public TimeInterval divide(Speed s1) {
	// return new TimeInterval(scalar /
	// s1.scalar, TimeInterval.refUnit);
	// }

	public BitRateQuantity divide(TimeQuantity t) {
		return new BitRateQuantity(scalar / t.scalar, BitRateUnit.REF_UNIT);
	}

	public BitQuantity convert(BitUnit newUnit) {
		return new BitQuantity(scalar / newUnit.getMultFactor(), newUnit);
	}

	public String showInUnits(BitUnit u, int precision) {
		return super.showInUnits(u, precision);
	}

	public Measurement<Information> add(
			Measurement<Information> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Information> subtract(
			Measurement<Information> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Information> to(Unit<Information> unit) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<?> divide(Quantity<?> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public BitQuantity multiply(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

	public BitQuantity multiply(Measurement<?> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Information> subtract(Quantity<Information> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Information> add(Quantity<Information> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Information> divide(Number that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Information> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T extends Quantity<T>, E extends Quantity<E>> Quantity<E> multiply(
			Quantity<T> that) {
		// TODO Auto-generated method stub
		return null;
	}
}
