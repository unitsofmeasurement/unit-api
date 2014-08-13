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
 * @version 0.3, Date: 2014-07-01
 */
final class TestDimension implements Dimension {
    private static final Dimension INSTANCE = new TestDimension();
    
    public static Dimension getInstance() {
    	return INSTANCE;
    }

    public Dimension multiply(Dimension dimension) {
        return this;
    }

    public Dimension divide(Dimension dimension) {
        return this;
    }

    public Dimension pow(int i) {
        return this;
    }
    
    public Dimension root(int i) {
        return this;
    }

    public Map<? extends Dimension, Integer> getProductDimensions() {
        final Map<Dimension, Integer> products = new HashMap<Dimension, Integer>();
        products.put(this, 1);
        return products;
    }
}
