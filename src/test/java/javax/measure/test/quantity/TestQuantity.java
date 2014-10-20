/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.quantity;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.test.TestUnit;

/**
 * @author Werner Keil
 */
abstract class TestQuantity<Q extends Quantity<Q>> implements Quantity<Q>,
		Comparable<Quantity<Q>> {
	
	protected double scalar; // value in reference units
	protected double units; // value in units (Unit unit)
	protected TestUnit<Q> unit; // unit
	private final Class<Q> type; // quantity type

	protected TestQuantity(Class<Q> type) {
		this.type = type;
	}

	public Class<Q> getType() {
		return this.type;
	}

	public TestQuantity<Q> add(TestQuantity<Q> dn, TestQuantity<Q> d1,
			TestQuantity<Q> d2, TestUnit<Q> au) {
		if (d1.unit == d2.unit) {
			dn.unit = d1.unit;
			dn.scalar = d1.scalar + d2.scalar;
			dn.units = d1.units + d2.units;
		} else {
			dn.unit = au;
			dn.scalar = d1.scalar + d2.scalar;
			dn.units = dn.scalar;
		}
		return dn;
	}

	public TestQuantity<Q> subtract(TestQuantity<Q> dn, TestQuantity<Q> d1,
			TestQuantity<Q> d2, TestUnit<Q> au) {
		if (d1.unit == d2.unit) {
			dn.unit = d1.unit;
			dn.scalar = d1.scalar - d2.scalar;
			dn.units = d1.units - d2.units;
		} else {
			dn.unit = au;
			dn.scalar = d1.scalar - d2.scalar;
			dn.units = dn.scalar;
		}
		return dn;
	}

	public boolean eq(TestQuantity<Q> d1) {
		return (scalar == d1.scalar);
	}

	public boolean ne(TestQuantity<Q> d1) {
		return (scalar != d1.scalar);
	}

	public boolean gt(TestQuantity<Q> d1) {
		return (scalar > d1.scalar);
	}

	public boolean lt(TestQuantity<Q> d1) {
		return (scalar < d1.scalar);
	}

	public boolean ge(TestQuantity<Q> d1) {
		return (scalar >= d1.scalar);
	}

	public boolean le(TestQuantity<Q> d1) {
		return (scalar <= d1.scalar);
	}

	@Override
	public String toString() {
		return (Double.valueOf(units)).toString() + ' ' + unit.getName();
	}

	/**
	 * Compares this quantity to the specified Measurement quantity. The default
	 * implementation compares the {@link AbstractQuantity#doubleValue(Unit)} of
	 * both this quantity and the specified Quantity stated in the same unit
	 * (this quantity's {@link #getUnit() unit}).
	 *
	 * @return a negative integer, zero, or a positive integer as this quantity
	 *         is less than, equal to, or greater than the specified Quantity
	 *         quantity.
	 * @return <code>Double.compare(this.doubleValue(getUnit()),
	 *         that.doubleValue(getUnit()))</code>
	 */
	public int compareTo(Quantity<Q> that) {
		Unit<Q> unit = getUnit();
		return Double.compare(units, that.getValue().doubleValue());
	}

	String showInUnits(TestUnit<?> u, int precision) {
		double result = scalar / u.getMultFactor();

		String str = (Double.valueOf(result)).toString();
		char cs[] = str.toCharArray();
		int i = 0;
		while (i < cs.length && (cs[i] >= '0' && cs[i] <= '9' || cs[i] == '.')) {
			i++;
		}
		Double bd = new Double(new String(cs, 0, i));
//		BigDecimal bd2 = bd.setScale(precision, RoundingMode.HALF_UP);
//		str = bd2.toString();
		str = bd.toString();
		
		String exp = "";
		if (i < cs.length) {
			exp = new String(cs, i, cs.length - i);
		}
		return str + exp + ' ' + u.getName();
	}

	public Number getValue() {
		return units;
	}

	public Unit<Q> getUnit() {
		return unit;
	}
}
