/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;


/**
 * <p>
 * This interface represents the service to obtain a {@link SystemOfUnits system
 * of units}.
 * </p>
 * 
 * <p>
 * Common system of units are "SI" (System International), "Imperial" (British),
 * "US" (US Customary).
 * </p>
 * 
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.5, $Date: 2014-12-03 $
 */
public interface SystemOfUnitsService {

	/**
	 * Returns the default <a
	 * href=http://en.wikipedia.org/wiki/International_System_of_Units">
	 * International System of Units</a>.
	 * 
	 * @return <code>getSystemOfUnits("SI")</code>
	 */
	SystemOfUnits getSystemOfUnits();

    /**
     * Returns the system of units having the specified name or
     * <code>null</code> if none.
     *
     * @param name the system of unit name.
     * @return the system of units.
     */
	SystemOfUnits getSystemOfUnits(String name);

}
