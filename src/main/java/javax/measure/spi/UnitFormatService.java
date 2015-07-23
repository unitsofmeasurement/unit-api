/*
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
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
 * @version 0.5.1, $Date: 2015-07-24 $
 */
public interface UnitFormatService {

    /**
     * Returns the default unit format.
     * 
     * It is up to implementations what to consider a suitable default.
     * For some implementations it may be a unit format based on <code>Locale.getDefault()</code> while others may return <code>getUnitFormat("SI")</code> or <code>getUnitFormat("ISO")</code>
     *
     * @return the default {@link UnitFormat} implementation.
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
