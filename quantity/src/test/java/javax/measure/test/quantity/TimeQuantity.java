/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.quantity;

import javax.measure.Measurement;
import javax.measure.Unit;
import javax.measure.quantity.Time;
import javax.measure.test.unit.DistanceUnit;
import javax.measure.test.unit.TimeUnit;

/**
 * @author Werner Keil
 * @version 1.1
 */
public class TimeQuantity extends TestQuantity<Time> {

    public TimeQuantity(double val, TimeUnit un) {
        units = val;
        unit = un;
        scalar = val * unit.getMultFactor();
    }

    public TimeQuantity(){
    }

    /*
     * Distance(double val) {
     *
     * units = val; unit = m; // reference Unit scalar = val;
     *
     * }
     */
    public TimeQuantity add(TimeQuantity d1) {
        TimeQuantity dn = new TimeQuantity();
        Object o = super.add(dn, this, d1, TimeUnit.REF_UNIT);
        return (TimeQuantity) o;
    }

    public TimeQuantity subtract(TimeQuantity d1) {
        TimeQuantity dn = new TimeQuantity();
        Object o = super.subtract(dn, this, d1, TimeUnit.REF_UNIT);
        return (TimeQuantity) o;
    }

    public boolean eq(TimeQuantity d1) {
        return super.eq(d1);
    }

    public boolean ne(TimeQuantity d1) {
        return super.ne(d1);
    }

    public boolean gt(TimeQuantity d1) {
        return super.gt(d1);
    }

    public boolean lt(TimeQuantity d1) {
        return super.lt(d1);
    }

    public boolean ge(TimeQuantity d1) {
        return super.ge(d1);
    }

    public boolean le(TimeQuantity d1) {
        return super.le(d1);
    }

    public TimeQuantity multiply(double v) {
        return new TimeQuantity(units * v, (TimeUnit) unit);
    }

    public TimeQuantity divide(double v) {
        return new TimeQuantity(units / v, (TimeUnit) unit);
    }



    // mixed type operations
	// public AreaQuantity multiply(TimeQuantity d1) {
	// TimeQuantity dq0 = convert(DistanceUnit.m);
	// TimeQuantity dq1 = d1.convert(DistanceUnit.m);
	// return new AreaQuantity(dq0.units * dq1.units, AreaUnit.sqmetre);
	// }

	// public VolumeQuantity multiply(AreaQuantity a1) {
	// TimeQuantity dq = convert(DistanceUnit.m);
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
    public TimeQuantity convert(TimeUnit newUnit) {
        return new TimeQuantity(scalar / newUnit.getMultFactor(), newUnit);
    }

    public String showInUnits(DistanceUnit u, int precision) {
        return super.showInUnits(u, precision);
    }

	@Override
	public Measurement<Time, Number> add(Measurement<Time, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Time, Number> substract(Measurement<Time, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> multiply(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> multiply(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> divide(Measurement<?, Number> that) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Time, Number> to(Unit<Time> unit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<Time, Number> inverse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Measurement<?, Number> divide(Number that) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
//	public double doubleValue(Unit<Time> unit) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public long longValue(Unit<Time> unit) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
}
