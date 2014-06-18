/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.function;

/**
 * A converter of values that produces a result of the
 * same type as its operand. 
 *
 * <p>There is no requirement that a new or distinct result be returned each
 * time the supplier is invoked.
 * 
 * <p>This is a <a href="http://download.java.net/jdk8/docs/api/java/util/function/package-summary.html">functional interface</a>
 * whose functional method is {@link #convert()}.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, $Date: 2014-06-18 $
 *
 */
public interface Converter<T> {
    /**
     * Indicates if this converter is an identity converter.
     * The identity converter returns its input argument ({@code convert(x) == x}).
     *
     * @return {@code true} if this converter is an identity converter.
     */
    boolean isIdentity();

    /**
     * Converts a {@code T} value.
     *
     * @param  value the {@code T} value to convert.
     * @return the {@code T} value after conversion.
     */
    T convert(T value);
 }
