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
import java.text.ParsePosition;
import java.util.HashMap;
import java.util.Map;

import javax.measure.MeasurementException;
import javax.measure.Unit;
import javax.measure.format.MeasurementParseException;
import javax.measure.format.UnitFormat;
import javax.measure.test.TestUnit;
import javax.measure.test.unit.DistanceUnit;

/**
 * Provides the interface for formatting and parsing {@linkplain Unit units}.
 *
 * <p>
 * The {@linkplain #getInstance standard} instance recognizes all metric units.
 * </p>
 *
 * <p>
 * OSGi bundles should use {@link javax.measure.format.UnitFormat} to parse/format {@linkplain #getInstance() standard} units.
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 *
 */
abstract class TestUnitFormat implements UnitFormat {
    /**
     * Holds the unique symbols collection.
     */
    private static final Map<String, Unit<?>> SYMBOL_TO_UNIT = new HashMap<>();

    /**
     * Returns the unit format for the default locale.
     *
     * @return the locale format.
     */
    public static UnitFormat getInstance() {
        return SimpleTestUnitFormat.geInstance();
    }

    /**
     * Base constructor.
     */
    protected TestUnitFormat() {
        SYMBOL_TO_UNIT.put("m", DistanceUnit.m);
    }

    /**
     * Formats the specified unit.
     *
     * @param unit
     *          the unit to format.
     * @param appendable
     *          the appendable destination.
     * @return The appendable destination passed in as {@code appendable}, with formatted text appended.
     * @throws IOException
     *           if an error occurs.
     */
    public abstract Appendable format(Unit<?> unit, Appendable appendable) throws IOException;

    protected Unit<?> parse(CharSequence csq, int index) throws MeasurementParseException {
        // Parsing reads the whole character sequence from the parse position.
        int start = index; // cursor != null ? cursor.getIndex() : 0;
        int end = csq.length();
        if (end <= start) {
            return TestUnit.ONE;
        }
        final Unit<?> result = SYMBOL_TO_UNIT.get(csq);
        if (result != null) {
            return result;
        }
        throw new MeasurementParseException("Error", csq, index);
    }

    /**
     * Parses the specified character sequence to produce a unit (convenience method). If the specified sequence is empty, the unitary unit
     * (dimensionless) is returned.
     *
     * @param csq
     *          the <code>CharSequence</code> to parse.
     * @return the unit parsed from the specified character sub-sequence.
     * @throws MeasurementParseException
     *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
     */
    public final Unit<?> parse(CharSequence csq) throws MeasurementParseException {
        return parse(csq, 0);
    }

    /**
     * Parses the specified character sequence to produce a unit (convenience method). If the specified sequence is empty, the unitary unit
     * (dimensionless) is returned.
     *
     * @param csq
     *          the <code>CharSequence</code> to parse.
     * @return the unit parsed from the specified character sub-sequence.
     * @throws MeasurementParseException
     *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
     */
    public final Unit<?> parse(CharSequence csq, ParsePosition pos) throws MeasurementParseException {
        return parse(csq, pos.getIndex());
    }

    /**
     * Formats an object to produce a string. This is equivalent to <blockquote> {@link #format(Unit, Appendable) format}<code>(unit,
     *         new StringBuilder()).toString();</code> </blockquote>
     *
     * @param unit
     *          The unit to format
     * @return Formatted string.
     * @exception IllegalArgumentException
     *              if the Format cannot format the given object
     */
    public final String format(Unit<?> unit) {
        if (unit instanceof TestUnit) {
            try {
                return format((TestUnit<?>) unit, new StringBuilder()).toString();
            } catch (IOException ex) {
                throw new MeasurementException(ex); // Should never happen.
            }
        } else {
            try {
                return (this.format(unit, new StringBuilder())).toString();
            } catch (IOException ex) {
                throw new MeasurementException(ex); // Should never happen.
            }
        }
    }
}
