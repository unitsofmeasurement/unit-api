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
import javax.measure.quantity.Volume;
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.VolumeUnit;

/**
 * @author Werner Keil
 * @version 0.3.1
 */
public class VolumeQuantity extends TestQuantity<Volume> {
	public VolumeQuantity() {
	}

	public VolumeQuantity(double val, VolumeUnit un) {
		units = val;
		unit = un;
		scalar = val * unit.getMultFactor();
	}

	/*
	 * Volume(double val) {
	 *
	 * units = val; unit = cumetre; // reference Unit scalar = val;
	 *
	 * }
	 */
	public VolumeQuantity add(VolumeQuantity d1) {
		VolumeQuantity dn = new VolumeQuantity();
		Object o = super.add(dn, this, d1, VolumeUnit.REF_UNIT);
		return (VolumeQuantity) o;
	}

	public VolumeQuantity subtract(VolumeQuantity d1) {
		VolumeQuantity dn = new VolumeQuantity();
		Object o = super.subtract(dn, this, d1, VolumeUnit.REF_UNIT);
		return (VolumeQuantity) o;
	}

	public boolean eq(VolumeQuantity d1) {
		return super.eq(d1);
	}

	public boolean ne(VolumeQuantity d1) {
		return super.ne(d1);
	}

	public boolean gt(VolumeQuantity d1) {
		return super.gt(d1);
	}

	public boolean lt(VolumeQuantity d1) {
		return super.lt(d1);
	}

	public boolean ge(VolumeQuantity d1) {
		return super.ge(d1);
	}

	public boolean le(VolumeQuantity d1) {
		return super.le(d1);
	}

	public VolumeQuantity multiply(double v) {
		return new VolumeQuantity(units * v, (VolumeUnit) unit);
	}

	public VolumeQuantity divide(double v) {
		return new VolumeQuantity(units / v, (VolumeUnit) unit);
	}

	// mixed type operations

	public AreaQuantity divide(DistanceQuantity d1) {
		VolumeQuantity dq0 = convert(VolumeUnit.cumetre);
		DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
		return new AreaQuantity(dq0.units / dq1.units, AreaUnit.sqmetre);
	}

	public DistanceQuantity divide(AreaQuantity a1) {
		VolumeQuantity dq0 = convert(VolumeUnit.cumetre);
		AreaQuantity dq1 = a1.convert(AreaUnit.sqmetre);
		return new DistanceQuantity(dq0.units / dq1.units, DistanceUnit.m);
	}

	public VolumeQuantity convert(VolumeUnit newUnit) {
		return new VolumeQuantity(scalar / newUnit.getMultFactor(), newUnit);
	}

	public String showInUnits(VolumeUnit u, int precision) {
		return super.showInUnits(u, precision);
	}

	public Quantity<?> divide(Quantity<?> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<Volume> subtract(Quantity<Volume> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<Volume> add(Quantity<Volume> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<Volume> divide(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<Volume> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<?> multiply(Quantity<?> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<Volume> multiply(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Quantity<Volume> to(Unit<Volume> unit) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
    public int compareTo(Measurement<Volume> o) {
        // TODO Auto-generated method stub
        return 0;
    }
}
