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
enum TestUnit implements Unit {
	TEST("t", 1);

    private final String symbol;
    @SuppressWarnings("unused")
	private final double factor;

    private TestUnit(String symbol, double factor) {
    	this.symbol  = symbol;
    	this.factor  = factor;
    }
    
	@Override
	public String getSymbol() {
		return symbol;
	}

	@Override
	public Dimension getDimension() {
		return TestDimension.getInstance();
	}

	@Override
	public Unit getSystemUnit() {
		return this;
	}

	@Override
	public Map getProductUnits() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isCompatible(Unit that) {
		return (this.equals(that));
	}

	@Override
	public Unit asType(Class type) throws ClassCastException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterTo(Unit that)
			throws UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UnitConverter getConverterToAny(Unit that)
			throws IncommensurableException, UnconvertibleException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit alternate(String symbol) {
		return this;
	}

	@Override
	public Unit transform(UnitConverter operation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Unit shift(double offset) {
		return this;
	}

	@Override
	public Unit multiply(double factor) {
		return this;
	}

	@Override
	public Unit multiply(Unit that) {
    	if (!(that instanceof TestUnit)) {
    		throw new UnconvertibleException("Incompatible unit");
    	}
    	return this;
	}

	@Override
	public Unit inverse() {
		return this;
	}

	@Override
	public Unit divide(double divisor) {
		return this;
	}

	@Override
	public Unit divide(Unit that) {
    	if (!(that instanceof TestUnit)) {
    		throw new UnconvertibleException("Incompatible unit");
    	}
    	return this;
	}

	@Override
	public Unit root(int n) {
		return this;
	}

	@Override
	public Unit pow(int n) {
		return this;
	}

	@Override
	public String getName() {
		return name();
	}

}
