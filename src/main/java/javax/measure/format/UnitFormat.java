/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.format;

import java.io.IOException;

import javax.measure.Unit;

/**
 * Formatting and parsing of {@code Unit} instances.
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.3
 *
 * @see Unit
 */
public interface UnitFormat extends Parser<CharSequence, Unit<?>> {
    /**
     * Formats the specified unit.
     *
     * @param  unit the unit to format.
     * @param  appendable the appendable destination.
     * @return the appendable destination passed in with formatted text appended.
     * @throws IOException if an error occurs while writing to the destination.
     */
    Appendable format(Unit<?> unit, Appendable appendable) throws IOException;

    /**
     * Parses a portion of the specified {@code CharSequence} from the
     * specified position to produce a unit. If there is no unit to parse
     * the unitary unit (dimensionless) is returned.
     *
     * @param  csq the {@code CharSequence} to parse.
     * @param  cursor the cursor holding the current parsing index, or {@code null}
     *         to parse the whole character sequence.
     * @return the unit parsed from the specified character sub-sequence.
     * @throws UnitParseException if any problem occurs while parsing the
     *         specified character sequence (e.g. illegal syntax).
     */
    //Unit<?> parse(CharSequence csq, ParsePosition cursor) throws ParserException;
    
    /**
     * Parses a portion of the specified {@code CharSequence} from the
     * specified position to produce a unit. If there is no unit to parse
     * the unitary unit (dimensionless) is returned.
     *
     * @param  csq the {@code CharSequence} to parse.
     * @return the unit parsed from the specified character sub-sequence.
     * @throws ParserException if any problem occurs while parsing the
     *         specified character sequence (e.g. illegal syntax).
     */
    Unit<?> parse(CharSequence csq) throws ParserException;
}
