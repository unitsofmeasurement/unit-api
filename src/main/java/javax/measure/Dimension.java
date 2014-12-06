/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;

import java.util.Map;

/**
 * Represents the dimension of a unit.
 *
 * <p>Concrete dimensions are obtained through the {@link Unit#getDimension()} method.</p>
 *
 * <p>Two units {@code u1} and {@code u2} are {@linkplain Unit#isCompatible(Unit) compatible}
 * if and only if {@code u1.getDimension().equals(u2.getDimension())}.</p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.13, December 6, 2014
 *
 * @see <a href="http://en.wikipedia.org/wiki/Dimensional_analysis">Wikipedia: Dimensional Analysis</a>
 */
public interface Dimension {
    /**
     * Returns the product of this dimension with the one specified.
     *
     * @param  multiplicand the dimension multiplicand.
     * @return {@code this * multiplicand}
     */
    Dimension multiply(Dimension multiplicand);

    /**
     * Returns the quotient of this dimension with the one specified.
     *
     * @param  divisor the dimension divisor.
     * @return {@code this / divisor}
     */
    Dimension divide(Dimension divisor);

    /**
     * Returns this dimension raised to an exponent.
     * <tt>(this<sup>n</sup>)</tt>
     *
     * @param  n power to raise this {@code Dimension} to.
     * @return <tt>this<sup>n</sup></tt>
     */
    Dimension pow(int n);

    /**
     * Returns the given root of this dimension.
     *
     * @param  n the root's order.
     * @return the result of taking the given root of this dimension.
     * @throws ArithmeticException if {@code n == 0}.
     */
    Dimension root(int n);

    /**
     * Returns the fundamental dimensions and their exponent whose product is
     * this dimension, or {@code null} if this dimension is a fundamental dimension.
     *
     * @return the mapping between the fundamental dimensions and their exponent.
     */
    Map<? extends Dimension, Integer> getProductDimensions();
}
