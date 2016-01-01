/*
 * Units of Measurement API
 * Copyright (c) 2014-2016, Jean-Marie Dautelle, Werner Keil, V2COM.
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
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products
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
 * Signals that a problem of some sort has occurred due to incommensurable of
 * some quantities/units. Only commensurable quantity (quantities with the same
 * dimensions) may be compared, equated, added, or subtracted. Also, one unit
 * can be converted to another unit only if both units are commensurable.
 * <p>
 * This is a <strong>checked</strong> exception, so it deliberately doesn't
 * inherit from <code>MeasurementException</code> like most other exceptions.
 * </p>
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.15, $Date: 2014-06-28 $
 *
 * @see <a href="http://en.wikipedia.org/wiki/Unit_commensurability#Commensurability">Wikipedia: Unit Commensurability</a>
 */
public class IncommensurableException extends Exception {
    /**
     * For cross-version compatibility.
     */
    //private static final long serialVersionUID = -3676414292638136515L;

    /**
     * Constructs a {@code IncommensurableException} with the given message.
     *
     * @param message the detail message, or {@code null} if none.
     */
    public IncommensurableException(final String message) {
        super(message);
    }

    /**
     * Constructs a {@code IncommensurableException} with the given cause.
     *
     * @param cause the cause of this exception, or {@code null} if none.
     *
     */
    public IncommensurableException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a {@code IncommensurableException} with the given message and cause.
     *
     * @param message the detail message, or {@code null} if none.
     * @param cause the cause of this exception, or {@code null} if none.
     *
     */
    public IncommensurableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
