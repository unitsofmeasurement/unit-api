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
package javax.measure.spi;

import java.util.Set;

import javax.measure.format.QuantityFormat;
import javax.measure.format.UnitFormat;

/**
 * This interface represent the service to obtain instances of {@link UnitFormat} and {@link QuantityFormat}.
 *
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 2.1, November 16, 2020
 * @since 2.0
 */
public interface FormatService {

    public static enum FormatType {
        UNIT_FORMAT, QUANTITY_FORMAT
    }

    /**
     * Returns the default quantity format.
     *
     * It is up to implementations what to consider a suitable default. For some (locale-sensitive) implementations it may be a quantity format based on
     * {@code Locale.current()} while others may return {@code getQuantityFormat("Simple")} or {@code getQuantityFormat("ISO")}.
     *
     * @return the default {@link QuantityFormat} implementation.
     */
    QuantityFormat getQuantityFormat();

    /**
     * Returns the quantity format having the specified name or {@code null} if none.
     *
     * For example (@code getQuantityFormat("Simple")} to return the simple {@link QuantityFormat} implementation.
     *
     * @param name
     *          the name of the format.
     * @return the corresponding quantity format.
     */
    QuantityFormat getQuantityFormat(String name);

    /**
     * Returns the default unit format.
     *
     * It is up to implementations what to consider a suitable default. For some (locale-sensitive) implementations it may be a unit format based on
     * {@code Locale.current()} while others may return {@code getUnitFormat("Simple")} or {@code getUnitFormat("ISO")}.
     *
     * @return the default {@link UnitFormat} implementation.
     */
    UnitFormat getUnitFormat();

    /**
     * Returns the unit format having the specified name or {@code null} if none.
     *
     * For example {@code getUnitFormat("Simple")} to return a simple {@link UnitFormat} implementation.
     *
     * @param name
     *          the name of the format.
     * @return the corresponding unit format.
     */
    UnitFormat getUnitFormat(String name);
    
    /**
     * Returns the unit format having the specified name or {@code null} if none.
     *
     * For example {@code getUnitFormat("Simple")} to return a simple {@link UnitFormat} implementation.<br>
     * The variant is an arbitrary value to allow a variation of a <code>UnitFormat</code>, for example <code>case sensitive</code> vs. <code>case insensitive</code> <a href="https://ucum.org/ucum.html">UCUM</a> format.
     * <p>If no variant is applicable, the <code>UnitFormat</code> matching the name only is returned.</p> 
     * @param name
     *          the name of the format.
     * @param variant any arbitrary value used to indicate a variation of a <code>UnitFormat</code>.
     * @return the corresponding unit format.
     */
    UnitFormat getUnitFormat(String name, String variant);
    
    /**
     * Gets a list with available format names of a given type for this format service.
     *
     * @param type
     *          the {@link FormatType}
     * @return list of available formats, never null.
     */
    Set<String> getAvailableFormatNames(FormatType type);
}
