/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.format;


/**
 * Defines the different variants of unit formatting.
 * 
 * @author Werner Keil
 */
public enum UnitStyle {

	/**
	 * The unit will be rendered as its localized display name. If no display
	 * name is known for the required {@link javax.measure.Unit}, the unit symbol
	 * should be used as a fall-back.
	 * 
	 * @see javax.measure.Unit#getName()
	 */
	NAME,

	/**
	 * The unit will be rendered as its (non localized) unit symbol.
	 * 
	 * @see javax.measure.Unit#getSymbol()
	 */
	SYMBOL
}