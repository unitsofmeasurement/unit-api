/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 * See LICENSE.txt for details.
 */
package javax.measure.function;

/**
 * This interface indices the value can be cast. The classes that can be cast will vary to each implementations.
 * @author Werner Keil
 * @version 0.1, $Date: 2014-05-29 $
 */
public interface Castable {

	/**
	 * converts the value to specified class
	 * @param value class to be converted
	 * @return the number converted
	 * @throws NullPointerException if class is null
	 * @throws UnsupportedOperationException if the class is unsupported
	 */
	<T extends java.lang.Number> T getNumber(Class<T> value);
}
