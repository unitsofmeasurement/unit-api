/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import java.util.Map;

import javax.measure.Dimension;
import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.function.UnitConverter;

/**
 * @author Werner Keil
 *
 */
@SuppressWarnings("rawtypes")
enum EnumUnit implements Unit {
	TEST("t", 1);

    private final String symbol;
    @SuppressWarnings("unused")
	private final double factor;

    private EnumUnit(String symbol, double factor) {
    	this.symbol  = symbol;
    	this.factor  = factor;
    }
    
	public String getSymbol() {
		return symbol;
	}

	public Dimension getDimension() {
		return TestDimension.getInstance();
	}

	public Unit getSystemUnit() {
		return this;
	}

	public Map getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isCompatible(Unit that) {
		return (this.equals(that));
	}

	public Unit asType(Class type) throws ClassCastException {
		// TODO Auto-generated method stub
		return this;
	}

	public UnitConverter getConverterTo(Unit that)
			throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	public UnitConverter getConverterToAny(Unit that)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit alternate(String symbol) {
		return this;
	}

	public Unit transform(UnitConverter operation) {
		// TODO Auto-generated method stub
		return null;
	}

	public Unit shift(double offset) {
		return this;
	}

	public Unit multiply(double factor) {
		return this;
	}

	public Unit multiply(Unit that) {
    	if (!(that instanceof EnumUnit)) {
    		throw new UnconvertibleException("Incompatible unit");
    	}
    	return this;
	}

	public Unit inverse() {
		return this;
	}

	public Unit divide(double divisor) {
		return this;
	}

	public Unit divide(Unit that) {
    	if (!(that instanceof EnumUnit)) {
    		throw new UnconvertibleException("Incompatible unit");
    	}
    	return this;
	}

	public Unit root(int n) {
		return this;
	}

	public Unit pow(int n) {
		return this;
	}

	public String getName() {
		return name();
	}

}
