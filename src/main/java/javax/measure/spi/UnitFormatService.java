/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;

import javax.measure.format.UnitFormat;

/**
 * <p>
 * This interface represent the service to obtain {@link UnitFormat} instances.
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, $Date: 2014-12-01 $
 */
public interface UnitFormatService {

    /**
     * Returns the default unit format.
     *
     * @return <code>getUnitFormat("UCUM")</code>
     */
	UnitFormat getUnitFormat();

    /**
     * Returns the unit format having the specified name or
     * <code>null</code> if none.
     * 
     * For example <code>getUnitFormat("UCUM")</code> to return a UCUM specific {@link UnitFormat} implementation. 
     *
     * @param name the name of the format.
     * @return the corresponding unit format.
     */
	UnitFormat getUnitFormat(String name);
}
