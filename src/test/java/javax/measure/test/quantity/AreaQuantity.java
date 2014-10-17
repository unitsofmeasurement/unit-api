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
import javax.measure.quantity.Area;
import javax.measure.test.unit.AreaUnit;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.VolumeUnit;

/**
 * @author Werner Keil
 * @version 0.3
 */
public class AreaQuantity extends TestQuantity<Area> {
    public AreaQuantity() {
    	super(Area.class);
    }

    public AreaQuantity(double val, AreaUnit un) {
    	this();
        units = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public AreaQuantity add(AreaQuantity d1) {
        AreaQuantity dn = new AreaQuantity();
        Object o = super.add(dn, this, d1, AreaUnit.REF_UNIT);
        return (AreaQuantity) o;
    }

    public AreaQuantity subtract(AreaQuantity d1) {
        AreaQuantity dn = new AreaQuantity();
        Object o = super.subtract(dn, this, d1, AreaUnit.REF_UNIT);
        return (AreaQuantity) o;
    }

    public boolean eq(AreaQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(AreaQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(AreaQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(AreaQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(AreaQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(AreaQuantity d1) {
        return super.le(d1);
    }

    public AreaQuantity multiply(double v) {
        return new AreaQuantity(units * v, (AreaUnit) unit);
    }

    public AreaQuantity divide(double v) {
        return new AreaQuantity(units / v, (AreaUnit) unit);
    }

    // mixed type operations

    public DistanceQuantity divide(DistanceQuantity d1) {
        AreaQuantity dq0 = convert(AreaUnit.sqmetre);
        DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
        return new DistanceQuantity(dq0.units / dq1.units, DistanceUnit.m);
    }

    public VolumeQuantity multiply(DistanceQuantity d1) {
        AreaQuantity dq0 = convert(AreaUnit.sqmetre);
        DistanceQuantity dq1 = d1.convert(DistanceUnit.m);
        return new VolumeQuantity(dq0.units * dq1.units, VolumeUnit.cumetre);
    }

    public AreaQuantity convert(AreaUnit newUnit) {
        return new AreaQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(AreaUnit u, int precision) {
        return super.showInUnits(u, precision);
    }

	public Measurement<Area> add(Measurement<Area> that) {
		// TODO Auto-generated method stub
		return null;
	}

	public Measurement<Area> subtract(Measurement<Area> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Area> multiply(Number that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<?> divide(Quantity<?> that) {
		// TODO Auto-generated method stub
		return null;
	}



    public Area to(Unit<Area> unit) {
		// TODO Auto-generated method stub
		return null;
	}


	public AreaQuantity multiply(Measurement<?> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Area> subtract(Quantity<Area> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Area> add(Quantity<Area> that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Area> divide(Number that) {
		// TODO Auto-generated method stub
		return null;
	}


    public Quantity<Area> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	public <T extends Quantity<T>, E extends Quantity<E>> Quantity<E> multiply(
			Quantity<T> that) {
    	if (that.getClass().equals(DistanceQuantity.class)) {
    		return (Quantity<E>) multiply((DistanceQuantity) that);
    	}
    	return null;
	}


}
