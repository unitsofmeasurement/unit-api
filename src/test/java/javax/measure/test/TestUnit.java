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
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.IncommensurableException;
import javax.measure.UnconvertibleException;
import javax.measure.function.UnitConverter;
import javax.measure.quantity.Dimensionless;
import javax.measure.test.unit.BaseUnit;


/**
 * @author Werner Keil
 */
public abstract class TestUnit<Q extends Quantity<Q>> implements Unit<Q> {

    public static final Unit<Dimensionless> ONE = new BaseUnit<Dimensionless>("one");

    // public static final Unit<Mass> METRIC_MASS = QuantityFactory.getInstance(Mass.class).getMetricUnit();

    protected String symbol; // e.g. "A"
    protected final String name; // e.g. "Angstrom"
    protected double multFactor; // e.g. 1E-10
    double addFactor = 0.0; // used for temperatures
    final Dimension dimension = TestDimension.getInstance();
    		
    protected TestUnit() {
    	name = "";
    }

    public TestUnit(String name, double factor) {
        this.name = name;
        this.multFactor = factor;
    }

    protected TestUnit(String name) {
        this(name, 0);
    }

    public Unit<Q> shift(double offset) {
        // TODO Auto-generated method stub
        return null;
    }

    public Unit<Q> alternate(String symbol) {
        // TODO Auto-generated method stub
        return null;
    }

    public <T extends Quantity<T>> Unit<T> asType(Class<T> type) throws ClassCastException {
//      Unit<T> metricUnit = QuantityFactory.getInstance(type).getMetricUnit();
//      if ((metricUnit == null) || metricUnit.isCompatible(this))
//          return (Unit<T>) this;
//      throw new ClassCastException("The unit: " + this //$NON-NLS-1$
//              + " is not of parameterized type " + type); //$NON-NLS-1$
        return null;
    }

    public Unit<Q> divide(double divisor) {
        // TODO Auto-generated method stub
        return null;
    }

    public Unit<?> divide(Unit<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public UnitConverter getConverterTo(Unit<Q> that) throws UnconvertibleException {
        // TODO Auto-generated method stub
        return null;
    }

    public UnitConverter getConverterToAny(Unit<?> that)
            throws IncommensurableException, UnconvertibleException
    {
        // TODO Auto-generated method stub
        return null;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public String getName() {
        return name;
    }

    public Map<Unit<?>, Integer> getProductUnits() {
        // TODO Auto-generated method stub
        return null;
    }

    public String getSymbol() {
        return symbol;
    }

    public Unit<?> inverse() {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean isCompatible(Unit<?> that) {
        // TODO Auto-generated method stub
        return false;
    }

    public Unit<Q> multiply(double factor) {
        // TODO Auto-generated method stub
        return null;
    }

    public Unit<?> multiply(Unit<?> that) {
        // TODO Auto-generated method stub
        return null;
    }

    public Unit<?> pow(int n) {
        // TODO Auto-generated method stub
        return null;
    }

    public Unit<?> root(int n) {
        // TODO Auto-generated method stub
        return null;
    }

    public abstract Unit<Q> getSystemUnit();

    public Unit<Q> transform(UnitConverter operation) {
        // TODO Auto-generated method stub
        return null;
    }

    public double getMultFactor() {
        return multFactor;
    }
}
