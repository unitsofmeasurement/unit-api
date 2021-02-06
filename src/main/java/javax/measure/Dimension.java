/*
 * Units of Measurement API
 * Copyright (c) 2014-2021, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.measure;

import java.util.Map;

/**
 * Represents the dimension of a unit.
 *
 * <p>
 * Concrete dimensions are obtained through the {@link Unit#getDimension()} method.
 * </p>
 *
 * <p>
 * Two units {@code u1} and {@code u2} are {@linkplain Unit#isCompatible(Unit) compatible} if and only if
 * {@code u1.getDimension().equals(u2.getDimension())}.
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 1.0, August 8, 2016
 * @since 1.0
 * @see Unit
 * @see <a href="http://en.wikipedia.org/wiki/Dimensional_analysis">Wikipedia: Dimensional Analysis</a>
 */
public interface Dimension {
    /**
     * Returns the product of this dimension with the one specified.
     *
     * @param multiplicand
     *          the dimension multiplicand.
     * @return {@code this * multiplicand}
     */
    Dimension multiply(Dimension multiplicand);

    /**
     * Returns the quotient of this dimension with the one specified.
     *
     * @param divisor
     *          the dimension divisor.
     * @return {@code this / divisor}
     */
    Dimension divide(Dimension divisor);

    /**
     * Returns this dimension raised to an exponent. <code>(this<sup>n</sup>)</code>
     *
     * @param n
     *          power to raise this {@code Dimension} to.
     * @return <code>this<sup>n</sup></code>
     */
    Dimension pow(int n);

    /**
     * Returns the given root of this dimension.
     *
     * @param n
     *          the root's order.
     * @return the result of taking the given root of this dimension.
     * @throws ArithmeticException
     *           if {@code n == 0}.
     */
    Dimension root(int n);

    /**
     * Returns the (fundamental) base dimensions and their exponent whose product is this dimension, or {@code null} if this dimension is a base
     * dimension.
     *
     * @return the mapping between the fundamental dimensions and their exponent.
     */
    Map<? extends Dimension, Integer> getBaseDimensions();
}
