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

/**
 * A unit prefix is a specifier or mnemonic that is prepended to units of measurement to indicate multiples or fractions of the units.
 *
 * @see <a href="http://en.wikipedia.org/wiki/Unit_prefix">Wikipedia: Unit Prefix</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 1.3, July 7, 2019
 * @since 2.0
 */
public interface Prefix {
    /**
     * Returns the name of this prefix.
     *
     * @return this prefix name, not {@code null}.
     */
    String getName();

    /**
     * Returns the symbol of this prefix.
     *
     * @return this prefix symbol, not {@code null}.
     */
    public String getSymbol();

    /**
     * Returns the value of this prefix. If the {@code exponent} is different from {@code 1}, this value is the {@code base} part of the associated
     * factor in {@code base^exponent} representation.
     * 
     * @return The prefix value.
     */
    Number getValue();

    /**
     * Exponent part of the associated factor in {@code base^exponent} representation. For different factors, e.g. rational numbers like {@code 1/4}
     * the exponent is always {@code 1}.
     *
     * @return the exponent part of this prefix.
     */
    int getExponent();
}