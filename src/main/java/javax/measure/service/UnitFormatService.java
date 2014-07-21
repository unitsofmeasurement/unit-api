/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.service;

import java.util.Locale;

import javax.measure.format.UnitFormat;

/**
 * <p>
 * This interface represent the service to obtain {@link UnitFormat} instances.
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @see <a href="http://aurora.regenstrief.org/~ucum/ucum.html">UCUM Full
 *      Specification</a>
 * @version 0.4, $Date: 2014-07-22 $
 */
public interface UnitFormatService {

    /**
     * Returns the default <a href="http://www.unitsofmeasure.org/">UCUM</a>
     * unit format.
     *
     * @return <code>getUnitFormat("UCUM")</code>
     */
	UnitFormat getUnitFormat();

    /**
     * Returns the unit format having the specified name or
     * <code>null</code> if none.
     *
     * @param name the name of the format.
     * @return the corresponding unit format.
     */
	UnitFormat getUnitFormat(String name);

    /**
     * Returns the unit format for the specified locale or
     * <code>null</code> if none.
     *
     * @param locale the locale for the format.
     * @return the corresponding unit format.
     */
	UnitFormat getUnitFormat(Locale locale);

}
