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
package javax.measure.test.format;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.format.UnitFormat;


/**
 * Provides a simple interface for formatting and parsing {@linkplain Unit units}.
 *
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.4.1
 */
public class SimpleTestFormat extends TestFormat {
//    private static final long serialVersionUID = -7753687108842507677L;

    private final Map<String, String> symbolMap = new HashMap<String, String>();

    private static final TestFormat DEFAULT = new SimpleTestFormat();

    // /////////////////
    // Class methods //
    // /////////////////

    /**
     * Returns the instance for formatting and parsing using case insensitive
     * symbols
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
    SimpleTestFormat() {
    }

    // //////////////
    // Formatting //
    // //////////////
    public Appendable format(final Unit<?> unit, final Appendable appendable)
            throws IOException
    {
        CharSequence symbol;
//      CharSequence annotation = null;
//      if (unit instanceof AnnotatedUnit<?>) {
//          AnnotatedUnit<?> annotatedUnit = (AnnotatedUnit<?>) unit;
//          unit = annotatedUnit.getActualUnit();
//          annotation = annotatedUnit.getAnnotation();
//      }
        String mapSymbol = symbolMap.get(unit);
        if (mapSymbol != null) {
            symbol = mapSymbol;
        } else {
            throw new IllegalArgumentException(
                    "Symbol mapping for unit of type " + //$NON-NLS-1$
                    unit.getClass().getName() + " has not been set " + //$NON-NLS-1$
                    "(see UnitFormat.SymbolMap)"); //$NON-NLS-1$
        }
        appendable.append(symbol);
//      if (annotation != null && annotation.length() > 0) {
//          appendAnnotation(unit, symbol, annotation, appendable);
//      }
        return appendable;
    }
    
	public void label(Unit<?> unit, String label) {
	}
	
	public boolean isLocaleSensitive() {
		return false;
	}

    void appendAnnotation(final Unit<?> unit, final CharSequence symbol,
            final CharSequence annotation, final Appendable appendable) throws IOException
    {
        appendable.append('{');
        appendable.append(annotation);
        appendable.append('}');
    }

    /**
     * Formats the given converter to the given StringBuffer. This is similar to
     * what {@link ConverterFormat} does, but there's no need to worry about
     * operator precedence here.
     *
     * @param converter
     *            the converter to be formatted
     * @param continued
     *            <code>true</code> if the converter expression should begin
     *            with an operator, otherwise <code>false</code>. This will
     *            always be true unless the unit being modified is equal to
     *            Unit.ONE.
     * @param buffer
     *            the <code>StringBuffer</code> to append to. Contains the
     *            already-formatted unit being modified by the given converter.
     */
    void formatConverter(final UnitConverter converter, final boolean continued,
            final StringBuffer buffer)
    {
        boolean unitIsExpression = ((buffer.indexOf(".") >= 0) || (buffer //$NON-NLS-1$
                .indexOf("/") >= 0)); //$NON-NLS-1$
        // Prefix prefix = symbolMap.getPrefixObject(converter);
        String prefix = "";
        if ((prefix != null) && (!unitIsExpression)) {
            buffer.insert(0, symbolMap.get(prefix));
        } else {
            throw new IllegalArgumentException(
                    "Unable to format units (unsupported UnitConverter " //$NON-NLS-1$
                            + converter + ")"); //$NON-NLS-1$
        }
    }
}
