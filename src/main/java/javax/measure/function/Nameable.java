/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

/**
 * Provides String name to implementations
 *
 * <p>There is no requirement that a distinct result be returned each
 * time the supplier is invoked, unless implementing classes enforce it.
 * 
 * <p>This is a <a href="http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description">functional interface</a>
 * whose functional method is {@link #getName()}.
 * 
 * @version 0.5, 2014-06-28
 * @author Werner Keil
 */
//equivalent to @FunctionalInterface
public interface Nameable {
	
    /**
     * @return a name
     */
    String getName();
}
