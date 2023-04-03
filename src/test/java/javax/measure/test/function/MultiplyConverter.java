/*
 * Units of Measurement API
 * Copyright (c) 2014-2023, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure.test.function;

import javax.measure.UnitConverter;
import javax.measure.test.TestConverter;

import java.util.Objects;

/**
 * <p>
 * This class represents a converter multiplying numeric values by a constant scaling factor (<code>double</code> based).
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 1.1, June 28, 2019
 * @since 2.0
 */
public final class MultiplyConverter extends TestConverter implements Comparable<UnitConverter> {

    /**
     * Holds the scale factor.
     */
    private double factor;

    /**
     * Creates a multiply converter with the specified scale factor.
     *
     * @param factor
     *          the scaling factor.
     * @throws IllegalArgumentException
     *           if coefficient is <code>1.0</code> (would result in identity converter)
     */
    public MultiplyConverter(double factor) {
        if (factor == 1.0)
            throw new IllegalArgumentException("Would result in identity converter");
        this.factor = factor;
    }
    
    /**
     * Creates a multiply converter with the specified scale factor.
     *
     * @param factor
     *          the scaling factor.
     * @throws IllegalArgumentException
     *           if coefficient is <code>1.0</code> (would result in identity converter)
     */
    public MultiplyConverter(Number factor) {
    	this(factor.doubleValue());
    }

    /**
     * Returns the scale factor of this converter.
     *
     * @return the scale factor.
     */
    public double getFactor() {
        return factor;
    }

    @Override
    public UnitConverter concatenate(UnitConverter converter) {
        if (!(converter instanceof MultiplyConverter))
            return super.concatenate(converter);
        double newfactor = factor * ((MultiplyConverter) converter).factor;
        return newfactor == 1.0 ? IDENTITY : new MultiplyConverter(newfactor);
    }

    @Override
    public MultiplyConverter inverse() {
        return new MultiplyConverter(1.0 / factor);
    }

    @Override
    public double convert(double value) {
        return value * factor;
    }

    @Override
    public final String toString() {
        return MultiplyConverter.class.getSimpleName() + "(" + factor + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MultiplyConverter) {
            MultiplyConverter that = (MultiplyConverter) obj;
            return Objects.equals(factor, that.factor);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(factor);
    }

    @Override
    public boolean isLinear() {
        return true;
    }

    public Double getValue() {
        return factor;
    }

    @Override
    public int compareTo(UnitConverter o) {
        if (this == o) {
            return 0;
        }
        if (o instanceof MultiplyConverter) {
            return getValue().compareTo(((MultiplyConverter) o).getValue());
        }
        return -1;
    }
}
