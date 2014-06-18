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
 * "http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html"
 * >functional interface</a> whose functional method is {@link #to()}.
 * 
 * @author Werner Keil
 * @version 0.1, $Date: 2014-06-18 $
 * @param <T>
 *            The value to return.
 * @param <U>
 *            The type to convert to.
 *            
 * @see <a href="http://en.wikipedia.org/wiki/Data_conversion">Wikipedia: Data Conversion</a>
 * 
 */
// equivalent to @FunctionalInterface
public interface ConversionOperator<T, U> {

    /**
     * Returns a T converted into another U.
     * 
     * @param unit
     * @return the converted result.
     */
    T to(U unit);
}
