/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;


import java.util.HashMap;
import java.util.Map;

import javax.measure.Dimension;

/**
 * 
 * @author Werner Keil
 * @version 0.2, Date: 2013-12-22
 */
final class TestDimension implements Dimension {
    private static final Dimension INSTANCE = new TestDimension();
    
    public static final Dimension getInstance() {
    	return INSTANCE;
    }

    @Override
    public Dimension multiply(Dimension dimension) {
        return this;
    }

    @Override
    public Dimension divide(Dimension dimension) {
        return this;
    }

    @Override
    public Dimension pow(int i) {
        return this;
    }

    @Override
    public Dimension root(int i) {
        return this;
    }

    @Override
    public Map<? extends Dimension, Integer> getProductDimensions() {
        Map<Dimension, Integer> products = new HashMap<Dimension, Integer>();
        products.put(this, 1);
        return products;
    }
}
