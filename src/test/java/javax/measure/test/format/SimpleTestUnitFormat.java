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
package javax.measure.test.format;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.measure.Unit;
import javax.measure.format.UnitFormat;

/**
 * Provides a simple interface for formatting and parsing {@linkplain Unit units}.
 *
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 0.7
 */
public class SimpleTestUnitFormat extends TestUnitFormat {
    private final Map<String, String> symbolMap = new HashMap<>();

    private static final TestUnitFormat DEFAULT = new SimpleTestUnitFormat();

    // /////////////////
    // Class methods //
    // /////////////////

    /**
     * Returns the instance for formatting and parsing using case insensitive symbols
     @return the default instance
     */
    public static UnitFormat geInstance() {
        return DEFAULT;
    }

    // ////////////////
    // Constructors //
    // ////////////////
    /**
     * Base constructor.
     */
    private SimpleTestUnitFormat() {
    }

    // //////////////
    // Formatting //
    // //////////////
    public Appendable format(final Unit<?> unit, final Appendable appendable) throws IOException {
        CharSequence symbol;
        @SuppressWarnings("unlikely-arg-type")
        String mapSymbol = symbolMap.get(unit);
        if (mapSymbol != null) {
            symbol = mapSymbol;
        } else {
            throw new IllegalArgumentException("Symbol mapping for unit of type " + //$NON-NLS-1$
                unit.getClass().getName() + " has not been set " + //$NON-NLS-1$
                "(see UnitFormat.SymbolMap)"); //$NON-NLS-1$
        }
        appendable.append(symbol);
        return appendable;
    }

    public void label(Unit<?> unit, String label) {
    }

    public boolean isLocaleSensitive() {
        return false;
    }
}
