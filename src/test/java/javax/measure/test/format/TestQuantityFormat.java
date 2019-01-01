/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure.test.format;

import java.io.IOException;

import javax.measure.Quantity;
import javax.measure.format.MeasurementParseException;
import javax.measure.format.QuantityFormat;
import javax.measure.test.quantity.TestQuantity;

/**
 * Provides the interface for formatting and parsing {@linkplain Quantity quantities}.
 *
 * <p>
 * OSGi bundles should use {@link javax.measure.format.QuantityFormat} to parse/format {@linkplain #getInstance() standard} Quantitys.
 * </p>
 *
 * @author <a href="mailto:Quantitys@catmedia.us">Werner Keil</a>
 * @version 0.2
 *
 */
abstract class TestQuantityFormat implements QuantityFormat {

    /** The serialVersionUID */
    // private static final long serialVersionUID = 7765623276257908888L;

    /**
     * Base constructor.
     */
    protected TestQuantityFormat() {
    }

    /**
     * Formats the specified Quantity.
     *
     * @param Quantity
     *          the Quantity to format.
     * @param appendable
     *          the appendable destination.
     * @return The appendable destination passed in as {@code appendable}, with formatted text appended.
     * @throws IOException
     *           if an error occurs.
     */
    public abstract Appendable format(Quantity<?> Quantity, Appendable appendable) throws IOException;

    protected Quantity<?> parse(CharSequence csq, int index) throws MeasurementParseException {
        // Parsing reads the whole character sequence from the parse position.
        int start = index; // cursor != null ? cursor.getIndex() : 0;
        int end = csq.length();
        if (end <= start) {
            return TestQuantity.ONE;
        }
        throw new MeasurementParseException("Error", csq, index);
    }

    /**
     * Parses the specified character sequence to produce a Quantity (convenience method). If the specified sequence is empty, the Quantityary Quantity
     * (dimensionless) is returned.
     *
     * @param csq
     *          the <code>CharSequence</code> to parse.
     * @return the Quantity parsed from the specified character sub-sequence.
     * @throws ParseException
     *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
     */
    public final Quantity<?> parse(CharSequence csq) throws MeasurementParseException {
        return parse(csq, 0);
    }

    /**
     * Formats an object to produce a string. This is equivalent to <blockquote> {@link #format(Quantity, Appendable) format}<code>(Quantity,
     *         new StringBuilder()).toString();</code> </blockquote>
     *
     * @param Quantity
     *          The Quantity to format
     * @return Formatted string.
     * @exception IllegalArgumentException
     *              if the Format cannot format the given object
     */
    public final String format(Quantity<?> Quantity) {
        if (Quantity instanceof TestQuantity) {
            try {
                return format((TestQuantity<?>) Quantity, new StringBuilder()).toString();
            } catch (IOException ex) {
                throw new MeasurementParseException(ex); // Should never happen.
            }
        } else {
            try {
                return (this.format(Quantity, new StringBuilder())).toString();
            } catch (IOException ex) {
                throw new MeasurementParseException(ex); // Should never happen.
            }
        }
    }
}
