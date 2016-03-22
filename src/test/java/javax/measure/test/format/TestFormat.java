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

import javax.measure.Unit;
import javax.measure.format.ParserException;
import javax.measure.format.UnitFormat;
import javax.measure.test.TestUnit;

/**
 * Provides the interface for formatting and parsing {@linkplain Unit units}.
 *
 * <p>
 * The {@linkplain #getInstance standard} instance recognizes all metric units
 * and the 20 SI prefixes used to form decimal multiples and some customary
 * units. For example:
 * </p>
 *
 * <code>
 *     TestFormat.getInstance().parse("kW").equals(KILO(WATT))<br>
 *     TestFormat.getInstance().parse("[ft_i]").equals(METRE.multiply(3048).divide(10000))<br>
 *     TestFormat.getInstance().parse("ft").equals(METRE.multiply(3048).divide(10000))
 * </code>
 *
 * <p>
 * OSGi bundles should use {@link javax.measure.format.UnitFormat} to
 * parse/format {@linkplain #getInstance() standard} units.
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.3
 *
 */
abstract class TestFormat implements UnitFormat {

	/** The serialVersionUID */
	// private static final long serialVersionUID = 7765623276257908888L;

	/**
	 * Returns the unit format for the default locale.
	 *
	 * @return the locale format.
	 */
	public static UnitFormat getInstance() {
		return SimpleTestFormat.geInstance();
	}

	/**
	 * Base constructor.
	 */
	protected TestFormat() {
	}

	/**
	 * Formats the specified unit.
	 *
	 * @param unit
	 *            the unit to format.
	 * @param appendable
	 *            the appendable destination.
	 * @return The appendable destination passed in as {@code appendable}, with
	 *         formatted text appended.
	 * @throws IOException
	 *             if an error occurs.
	 */
	public abstract Appendable format(Unit<?> unit, Appendable appendable)
			throws IOException;

	protected Unit<?> parse(CharSequence csq, int index) throws ParserException {
		// Parsing reads the whole character sequence from the parse position.
		int start = index; // cursor != null ? cursor.getIndex() : 0;
		int end = csq.length();
		if (end <= start) {
			return TestUnit.ONE;
		}
		throw new ParserException("Error", csq, index);
	}

	/**
	 * Parses the specified character sequence to produce a unit (convenience
	 * method). If the specified sequence is empty, the unitary unit
	 * (dimensionless) is returned.
	 *
	 * @param csq
	 *            the <code>CharSequence</code> to parse.
	 * @return the unit parsed from the specified character sub-sequence.
	 * @throws ParseException
	 *             if any problem occurs while parsing the specified character
	 *             sequence (e.g. illegal syntax).
	 */
	public final Unit<?> parse(CharSequence csq) throws ParserException {
		return parse(csq, 0);
	}

	/**
	 * Formats an object to produce a string. This is equivalent to <blockquote>
	 * {@link #format(Unit, StringBuilder) format}<code>(unit,
	 *         new StringBuilder()).toString();</code> </blockquote>
	 *
	 * @param obj
	 *            The object to format
	 * @return Formatted string.
	 * @exception IllegalArgumentException
	 *                if the Format cannot format the given object
	 */
	public final String format(Unit<?> unit) {
		if (unit instanceof TestUnit) {
			try {
				return format((TestUnit<?>) unit, new StringBuilder())
						.toString();
			} catch (IOException ex) {
				throw new ParserException(ex); // Should never happen.
			}
		} else {
			try {
				return (this.format(unit, new StringBuilder())).toString();
			} catch (IOException ex) {
				throw new ParserException(ex); // Should never happen.
			}
		}
	}
}
