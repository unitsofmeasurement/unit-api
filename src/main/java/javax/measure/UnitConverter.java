/*
 * Units of Measurement API
 * Copyright (c) 2014-2019, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import java.util.List;

/**
 * A converter of numeric values between different units.
 *
 * <p>
 * Instances of this class are usually obtained through the {@link Unit#getConverterTo(Unit)} method.
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:martin.desruisseaux@geomatys.com">Martin
 *         Desruisseaux</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Thodoris Bais</a>
 * @version 1.2, March 11, 2019
 * @since 1.0
 *
 * @see Unit
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units"> Wikipedia: Conversion of units</a>
 */
public interface UnitConverter {

    /**
     * Indicates if this converter is an identity converter. The identity converter returns its input argument ({@code convert(x) == x}).
     *
     * @return {@code true} if this converter is an identity converter.
     */
    boolean isIdentity();

    /**
     * A linear transformation between two vector spaces V and W is a map T : V -> W such that the following hold:
     *
     * <ul>
     * <li>{@code convert(u + v) == convert(u) + convert(v)}</li>
     * <li>{@code convert(r * u) == r * convert(u)}</li>
     * </ul>
     *
     * A linear transformation may or may not be injective or surjective.
     * When V and W have the same dimension, it is possible for T to be invertible, meaning there exists a T⁻¹ such that
     * TT⁻¹ = I. It is always the case that  T(0)=0.
     * Also, a linear transformation always maps lines to lines (or to zero).
     *
     * <p>
     * For linear converters the following property always hold:
     * </p>
     *
     * <code>
     *   y1 = c1.convert(x1);
     *   y2 = c2.convert(x2);
     *   assert y1*y2 == c1.concatenate(c2).convert(x1*x2);
     * </code>
     *
     * @return {@code true} if this converter is linear; {@code false} otherwise.
     */
    boolean isLinear();

    /**
     * Returns the inverse of this converter. If {@code x} is a valid value, then {@code x == inverse().convert(convert(x))} to within the accuracy of
     * computer arithmetic.
     *
     * @return the inverse of this converter.
     */
    UnitConverter inverse();

    /**
     * Converts a {@code Number} value.
     *
     * @param value
     *          the {@code Number} value to convert.
     * @return the {@code Number} value after conversion.
     */
    Number convert(Number value);

    /**
     * Converts a {@code double} value.
     *
     * @param value
     *          the numeric value to convert.
     * @return the {@code double} value after conversion.
     */
    double convert(double value);

    /**
     * Concatenates this converter with another converter. The resulting converter is equivalent to first converting by the specified converter (right
     * converter), and then converting by this converter (left converter).
     *
     * @param converter
     *          the other converter to concatenate with this converter.
     * @return the concatenation of this converter with the other converter.
     */
    UnitConverter concatenate(UnitConverter converter);

    /**
     * <p>
     * Returns the steps of fundamental converters making up this converter or {@code this} if the converter is a fundamental converter.
     * </p>
     * <p>
     * For example, {@code converter1.getConversionSteps()} returns {@code converter1} while
     * {@code converter1.concatenate(converter2).getConversionSteps()} returns {@code converter1, converter2}.
     * </p>
     *
     * @return the list of fundamental converters which concatenated make up this converter.
     */
    List<? extends UnitConverter> getConversionSteps();
}
