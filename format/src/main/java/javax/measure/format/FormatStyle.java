/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.format;


/**
 * Defines the different ways of formatting.
 * 
 * @author Werner Keil
 */
public enum FormatStyle {

	/**
	 * Formatting occurs in a locale-neutral way.
	 * 
	 */
	LOCALE_NEUTRAL,

	/**
	 * Formatting occurs in a locale-sensitive way.
	 * 
	 * @see java.util.Locale
	 */
	LOCALE_SENSITIVE
}