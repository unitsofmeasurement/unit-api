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
 * <h4><a name="synchronization">Synchronization</a></h4>
 * <p>
 * <p>
 * Instances of this class are not required to be thread-safe. It is recommended to of separate
 * format instances for each thread. If multiple threads access a format concurrently, it must be
 * synchronized externally.
 * <p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 *
 * @version 0.7, Sep 14, 2015
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
	 * Attaches a system-wide label to the specified unit.<p>
	 * If the specified label is already associated to a unit the previous
	 * association can be discarded or ignored. 
	 * Depending on the {@link UnitFormat} implementation, this call may be ignored if the particular unit already has a label.</p>
	 * If a {@link UnitFormat} implementation is explicitly <b>immutable</b>, similar to e.g. the result of <tt>Collections.unmodifiableList()</tt>, then an {@linkplain UnsupportedOperationException} may be thrown upon this call.<p>
	 * Since <tt>UnitFormat</tt> implementations are often singletons, <b>system-wide</b> means, the label applies to every instance of <tt>UnitFormatA</tt> implementing <tt>UnitFormat</tt> in this case, but not every instance of <tt>UnitFormatB</tt> or <tt>UnitFormatC</tt> both also implementing <tt>UnitFormat</tt>.  
	 * </p>
	 * @param unit
	 *            the unit being labeled.
	 * @param label
	 *            the new label for this unit.
	 * @throws IllegalArgumentException
	 *             if the label is not a valid identifier.
	 * @throws UnsupportedOperationException if the <tt>label</tt> operation
     *         is not supported by this {@link UnitFormat}
	 */
	void label(Unit<?> unit, String label);
    
	/**
	 * Returns <code>true</code> if this {@link UnitFormat} depends on a <code>Locale</code> to perform its tasks.<p>
	 * In environments that do not support a <code>Locale</code>, e.g. Java ME, this usually returns <code>false</code>.</p>
	 * @return Whether this format depends on the locale.
	 */
	boolean isLocaleSensitive();
	
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
