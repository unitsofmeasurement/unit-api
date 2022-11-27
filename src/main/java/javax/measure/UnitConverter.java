/*
 * Units of Measurement API
 * Copyright (c) 2014-2022, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
 * @author <a href="mailto:ahuber@apache.org">Andi Huber</a>
 * @version 1.4, May 12, 2019
 * @since 1.0
 *
 * @see Unit
 * @see <a href="http://en.wikipedia.org/wiki/Conversion_of_units"> Wikipedia: Conversion of units</a>
 */
public interface UnitConverter {

    /**
     * Indicates if this converter is an identity converter. The identity converter returns its input argument ({@code convert(x) == x}).
     * <p>
     * Note: Identity converters are also always 'linear', see {@link UnitConverter#isLinear()}.
     * </p>
     *
     * @return {@code true} if this converter is an identity converter.
     */
    boolean isIdentity();

    /**
     * Indicates whether this converter represents a (one-dimensional) linear transformation, that is
     * a <a href="https://en.wikipedia.org/wiki/Linear_map">linear map (wikipedia)</a> from a one-dimensional 
     * vector space (a scalar) to a one-dimensional vector space. Typically from 'R' to 'R', with 'R' the 
     * real numbers.  
     *
     * <p>
     * Given such a 'linear' converter 'A', let 'u', 'v' and 'r' be arbitrary numbers, then the following 
     * must hold by definition: 
     *
     * <ul>
     * <li>{@code A(u + v) == A(u) + A(v)}</li>
     * <li>{@code A(r * u) == r * A(u)}</li>
     * </ul>
     *
     * <p>
     * Given a second 'linear' converter 'B', commutativity of composition follows by above definition:
     *
     * <ul>
     * <li>{@code (A o B) (u) == (B o A) (u)}</li>
     * </ul>
     * 
     * In other words, two 'linear' converters do have the property that {@code A(B(u)) == B(A(u))}, meaning 
     * for 'A' and 'B' the order of their composition does not matter. Expressed as Java code:
     *
     * <p>
     *{@code A.concatenate(B).convert(u) == B.concatenate(A).convert(u)}
     * </p>
     * 
     * Note: For composing UnitConverters see also {@link UnitConverter#concatenate(UnitConverter)}.
     *
     * @return {@code true} if this converter represents a linear transformation; 
     * {@code false} otherwise.
     * 
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
