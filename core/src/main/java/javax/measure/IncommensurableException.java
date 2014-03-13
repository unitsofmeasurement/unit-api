/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure;


/**
 * Signals that a problem of some sort has occurred due to incommensurable of
 * some quantities/units. Only commensurable quantity (quantities with the same
 * dimensions) may be compared, equated, added, or subtracted. Also, one unit
 * can be converted to another unit only if both units are commensurable.
 * <p>
 * This is a <strong>checked</strong> exception, so it deliberately doesn't
 * inherit from <code>MeasurementException</code> like most other exceptions.
 * </p>
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.5, $Date: 2014-01-27 23:16:02 +0100 (Mo, 27 Jän 2014) $
 *
 * @see <a href="http://en.wikipedia.org/wiki/Unit_commensurability#Commensurability">Wikipedia: Unit Commensurability</a>
 */
public class IncommensurableException extends Exception {
    /**
     * For cross-version compatibility.
     */
    private static final long serialVersionUID = -3676414292638136515L;

    /**
     * Constructs a {@code IncommensurableException} with the given message.
     *
     * @param message the detail message, or {@code null} if none.
     */
    public IncommensurableException(final String message) {
        super(message);
    }

    /**
     * Constructs a {@code IncommensurableException} with the given cause.
     *
     * @param cause the cause of this exception, or {@code null} if none.
     *
     */
    public IncommensurableException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a {@code IncommensurableException} with the given message and cause.
     *
     * @param message the detail message, or {@code null} if none.
     * @param cause the cause of this exception, or {@code null} if none.
     *
     */
    public IncommensurableException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
