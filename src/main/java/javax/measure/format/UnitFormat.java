/*
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
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
 * @version 0.6, Sep 13, 2015
 *
 * @see Unit
 * @see Parser
 */
public interface UnitFormat extends Parser<CharSequence, Unit<?>> {
    /**
     * Formats the specified {@link Unit}.
     *
     * @param  unit the {@link Unit} to format, not {@code null}
     * @param  appendable the appendable destination.
     * @return the appendable destination passed in with formatted text appended.
     * @throws IOException if an error occurs while writing to the destination.
     */
    Appendable format(Unit<?> unit, Appendable appendable) throws IOException;
    
    /**
     * Formats the specified {@link Unit}.
     *
     * @param  unit the {@link Unit} to format, not {@code null}
     * @return the string representation using the settings of this {@link UnitFormat}.
     * @throws IOException if an error occurs while writing to the destination.
     */
    String format(Unit<?> unit);
    
	/**
	 * Attaches a system-wide label to the specified unit.<br>If
	 * the specified label is already associated to an unit the previous
	 * association is discarded or ignored.
	 * 
	 * @param unit
	 *            the unit being labeled.
	 * @param label
	 *            the new label for this unit.
	 * @throws IllegalArgumentException
	 *             if the label is not a valid identifier.
	 */
	public abstract void label(Unit<?> unit, String label);
    
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
