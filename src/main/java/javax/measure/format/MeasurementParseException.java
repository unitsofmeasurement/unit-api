/*
 * Units of Measurement API
 * Copyright (c) 2014-2025, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import javax.measure.MeasurementException;

/**
 * Signals that an error has been reached unexpectedly while parsing.
 *
 * @author Werner Keil
 * @version 1.1, March 27, 2018
 * @since 2.0
 */
public class MeasurementParseException extends MeasurementException {

    /**
     * For cross-version compatibility.
     */
    private static final long serialVersionUID = 2727457045794254852L;

    /**
     * The zero-based character position in the string being parsed at which the error was found while parsing.
     *
     * @serial
     */
    private int position;

    /** The original input data. */
    private CharSequence data;

    /**
     * Constructs a MeasurementParseException with the specified detail message, parsed text and index. A detail message is a String that describes
     * this particular exception.
     *
     * @param message
     *            the detail message
     * @param parsedData
     *            the parsed text, should not be null
     * @param position
     *            the position where the error was found while parsing.
     */
    public MeasurementParseException(String message, CharSequence parsedData, int position) {
        super(message);
        this.data = parsedData;
        this.position = position;
    }

    /**
     * Constructs a MeasurementParseException with the parsed text and offset. A detail message is a String that describes this particular exception.
     *
     * @param parsedData
     *            the parsed text, should not be null
     * @param position
     *            the position where the error is found while parsing.
     */
    public MeasurementParseException(CharSequence parsedData, int position) {
        this("Parse Error", parsedData, position);
    }

    /**
     * Constructs a MeasurementParseException with the specified cause.
     *
     * @param cause
     *            the root cause
     */
    public MeasurementParseException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a MeasurementParseException with the specified detail message.
     *
     * @param message
     *            the detail message
     */
    public MeasurementParseException(String message) {
        super(message);
    }

    /**
     * Returns the position where the error was found.
     *
     * @return the position of the error
     */
    public int getPosition() {
        return position;
    }

    /**
     * Returns the string that was being parsed.
     *
     * @return the parsed string, or {@code null}, if {@code null} was passed as input.
     */
    public String getParsedString() {
        if (data == null) {
            return null;
        }
        return data.toString();
    }
}
