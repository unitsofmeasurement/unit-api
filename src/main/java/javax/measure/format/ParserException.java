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

/**
 * Signals that an error has been reached unexpectedly while parsing.
 *
 * @author Werner Keil
 * @version 1.2, October 7, 2018
 * @since 1.0
 * @deprecated Use {@link MeasurementParseException}, this exception will be removed in a future version, it is here for backward compatibility only.
 */
@Deprecated
public class ParserException extends MeasurementParseException {

    private static final long serialVersionUID = -3179553925611520368L;

    /**
     * Constructs a ParserException with the specified detail message, parsed text and index. A detail message is a String that describes this
     * particular exception.
     *
     * @param message
     *            the detail message
     * @param parsedData
     *            the parsed text, should not be null
     * @param position
     *            the position where the error was found while parsing.
     */
    public ParserException(String message, CharSequence parsedData, int position) {
        super(message, parsedData, position);
    }

    /**
     * Constructs a ParserException with the parsed text and offset. A detail message is a String that describes this particular exception.
     *
     * @param parsedData
     *            the parsed text, should not be null
     * @param position
     *            the position where the error is found while parsing.
     */
    public ParserException(CharSequence parsedData, int position) {
        super(parsedData, position);
    }

    /**
     * Constructs a ParserException with the specified cause.
     *
     * @param cause
     *            the root cause
     */
    public ParserException(Throwable cause) {
        super(cause);
    }
}
