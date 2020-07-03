/*
 * Units of Measurement API
 * Copyright (c) 2014-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure.format;

import java.io.IOException;
import java.text.ParsePosition;

import javax.measure.Quantity;

/**
 * Formats instances of {@link Quantity}.
 *
 * <dl>
 * <dt><span class="strong"><a id="synchronization">Synchronization</a></span></dt>
 * </dl> 
 * Instances of this class are not required to be thread-safe. It is recommended to use separate format instances for each thread. If multiple threads
 * access a format concurrently, it must be synchronized externally.
 *
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @author <a href="mailto:thodoris.bais@gmail.com">Thodoris Bais</a>
 *
 * @version 1.0, 3 July, 2020
 * @since 2.0
 *
 * @see Quantity
 */
public interface QuantityFormat {

    /**
     * Formats the specified quantity into an {@code Appendable}.
     *
     * @param quantity
     *          the quantity to format.
     * @param destination
     *          the appendable destination.
     * @return the specified {@code Appendable}.
     * @throws IOException
     *           if an I/O exception occurs.
     */
    public Appendable format(Quantity<?> quantity, Appendable destination) throws IOException;

    /**
     * Formats the specified {@link Quantity}.
     *
     * @param quantity
     *            the {@link Quantity} to format, not {@code null}
     * @return the string representation using the settings of this {@link QuantityFormat}.
     */
    String format(Quantity<?> quantity);

    /**
     * Parses a portion of the specified {@code CharSequence} from the specified position to produce a {@link Quantity}.
     * If parsing succeeds, then the index of the {@code pos} argument is updated to the index after the last character used.
     *
     * @param csq
     *          the {@code CharSequence} to parse.
     * @param pos
     *          a ParsePosition object holding the current parsing index and error parsing index information as described above.
     * @return the quantity parsed from the specified character sub-sequence.
     * @throws IllegalArgumentException
     *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
     */
    public Quantity<?> parse(CharSequence csq, ParsePosition pos) throws IllegalArgumentException, MeasurementParseException;

    /**
     * Parses a portion of the specified {@code CharSequence} from the specified position to produce a {@link Quantity}.
     *
     * @param csq
     *          the {@code CharSequence} to parse.
     * @return the quantity parsed from the specified character sub-sequence.
     * @throws IllegalArgumentException
     *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
     */
    public Quantity<?> parse(CharSequence csq) throws MeasurementParseException;

    /**
     * Returns {@code true} if this {@link QuantityFormat} depends on a {@code Locale} to perform its tasks.
     * <p>
     * In environments that do not support a {@code Locale}, e.g. Java ME, this usually returns {@code false}.
     * </p>
     *
     * @return whether this format depends on the locale.
     */
    default boolean isLocaleSensitive() {
        return false;
    }
}
