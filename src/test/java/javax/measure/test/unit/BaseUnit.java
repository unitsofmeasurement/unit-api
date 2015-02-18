/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.unit;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.test.TestUnit;



/**
 * Building blocks on top of which all others units are created.
 * Base units are always unscaled metric units.
 *
 * <p>When using the standard model (default),
 * all seven base units are dimensionally independent.</p>
 *
 * @param <Q> The type of the quantity measured by this unit.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.9
 *
 * @see <a href="http://en.wikipedia.org/wiki/SI_base_unit">Wikipedia: SI base unit</a>
 */
public class BaseUnit<Q extends Quantity<Q>> extends TestUnit<Q> {
    /**
     * Creates a base unit having the specified symbol.
     *
     * @param symbol the symbol of this base unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public BaseUnit(String symbol, String name) {
        super(name);
        this.symbol = symbol;
    }

    /**
     * Creates a base unit having the specified symbol.
     *
     * @param symbol the symbol of this base unit.
     * @throws IllegalArgumentException if the specified symbol is
     *         associated to a different unit.
     */
    public BaseUnit(String symbol) {
        this(symbol, null);
    }

    @Override
    public String getSymbol() {
        return symbol;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BaseUnit<?>) {
        	BaseUnit<?> other = (BaseUnit<?>) obj;
        	return symbol != null && symbol.equals(other.symbol);
        }
        return false;
    }

    @Override
    public int hashCode() {
        //return Objects.hashCode(symbol);
    	return 0;
    }

    @Override
    public Unit<Q> getSystemUnit() {
        return this;
    }
}
