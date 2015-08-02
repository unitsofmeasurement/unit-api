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
 * <p>
 * Formats instances of {@link Unit} to a {@link String} or an {@link Appendable} and parses a {@link CharSequence} to a {@link Unit}.
 * </p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, Dec 3, 2014
 *
 * @see Unit
 * @see Parser
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
    
    String format(Unit<?> unit);
    
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
