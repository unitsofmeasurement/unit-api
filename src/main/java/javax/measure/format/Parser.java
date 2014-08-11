/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.format;

/**
 * Represents a function that parses an input value and produces an output.
 * 
 * <p>
 * This is a <a href=
 * "http://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html#package.description"
 * >functional interface</a> whose functional method is {@link #parse()}.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, 2014-08-11
 * @param <I>
 *            the input
 * @param <O>
 *            the output
 * @see ParserException
 */
// equivalent to @FunctionalInterface
public interface Parser<I, O> {
	/**
	 * Parses the specified {@code I} to produce a {@code O}.
	 * @throws ParserException if any problem occurs while parsing the
     *         specified input (e.g. illegal syntax).
	 */
	O parse(I input) throws ParserException;
}
