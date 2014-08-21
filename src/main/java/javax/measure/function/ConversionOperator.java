/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

/**
 *  Represents an operation to convert values.
 * 
 * <p>
 * This is a <a href=
 * "http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description"
 * >functional interface</a> whose functional method is {@link #to()}.
 * 
 * @author Werner Keil
 * @version 0.4, 2014-08-22
 * @param <T>
 *            The type to convert to.
 * @param <R>
 *            The value to return.            
 * @see <a href="http://en.wikipedia.org/wiki/Data_conversion">Wikipedia: Data Conversion</a>
 * 
 */
// equivalent to @FunctionalInterface
public interface ConversionOperator<T, R> {

    /**
     * Returns a T converted into another U.
     * 
     * @param type
     * @return the converted result.
     */
    R to(T type);
}
