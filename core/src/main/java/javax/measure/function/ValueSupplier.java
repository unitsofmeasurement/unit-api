/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

/**
 * Represents a supplier of values.
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #getValue()}.
 * 
 * @author Werner Keil
 * @version 0.2, $Date: 2014-04-09 $
 * @param <T> the type of values supplied by this supplier
 */
// equivalent to @FunctionalInterface
public interface ValueSupplier<T> {
	
    /**
     * Gets a value.
     *
     * @return a value
     */
	T getValue();
}
