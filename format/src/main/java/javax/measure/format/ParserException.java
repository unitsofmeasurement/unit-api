/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.format;

import javax.measure.MeasurementException;

/**
 * Signals that an error has been reached unexpectedly while parsing.
 * 
 * @author Werner Keil
 * @version 0.3.1, $Date: 2014-01-08 22:42:36 +0100 (Mi, 08 Jän 2014) $
 */
public class ParserException extends MeasurementException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3179553925611520368L;

	/**
	 * The zero-based character position in the string being parsed at which the
	 * error was found while parsing.
	 * 
	 * @serial
	 */
	private int position;

	/** The original input data. */
	private CharSequence data;

	/**
	 * Constructs a ParserException with the specified detail message,
	 * parsed text and index. A detail message is a String that describes this
	 * particular exception.
	 * 
	 * @param message
	 *            the detail message
	 * @param parsedData
	 *            the parsed text, should not be null
	 * @param position
	 *            the position where the error was found while parsing.
	 */
	public ParserException(String message, CharSequence parsedData,
			int position) {
		super(message);
		this.data = parsedData;
		this.position = position;
	}

	/**
	 * Constructs a ParserException with the parsed text and offset. A
	 * detail message is a String that describes this particular exception.
	 * 
	 * @param parsedData
	 *            the parsed text, should not be null
	 * @param errorIndex
	 *            the position where the error is found while parsing.
	 */
	public ParserException(CharSequence parsedData,
			int errorIndex) {
		super("Parse Error");
		this.data = parsedData;
		this.position = errorIndex;
	}
	
	/**
	 * Constructs a ParserException with the specified cause.
	 * 
	 * @param cause
	 *            the root cause
	 */
	public ParserException(Throwable cause) {
		super(cause);
	}

	/**
	 * Returns the position where the error was found.
	 * 
	 * @return the position of the error
	 */
	public int getPosition() {
		return position;
	}

	/**
	 * Returns the string that was being parsed.
	 * 
	 * @return the parsed string, or {@code null}, if {@code null} was passed as
	 *         input.
	 */
	public String getParsedString() {
		if (data == null)
			return null;
		return data.toString();
	}

}
