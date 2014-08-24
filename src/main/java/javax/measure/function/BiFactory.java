/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

/**
 * Represents a factory that accepts two arguments and creates a result.
 *
 * <p>This is a <a href="http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description">functional interface</a>
 * whose functional method is {@link #create(T, U)}.
 *
 * @param <T> the type of the first argument to the factory
 * @param <U> the type of the second argument to the factory
 * @param <R> the type of the result of the factory
 * 
 * @author Werner Keil
 * @version 0.3, $Date: 2014-08-24 $
 */
// TODO this is only used by QuantityFactory, consider replacing it with QF (which needed another name then)
public interface BiFactory<T, U, R> {
	R create(T t, U u);
}
