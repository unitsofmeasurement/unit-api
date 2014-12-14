/**
 *  Unit-API - Units of Measurement API for Java
 *  Copyright (c) 2005-2014, Jean-Marie Dautelle, Werner Keil, V2COM.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-363 nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package javax.measure.test.quantity;

import static javax.measure.test.unit.DistanceUnit.m;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.quantity.*;
import javax.measure.spi.QuantityFactory;
import javax.measure.test.TestUnit;

/**
 * A factory producing simple quantities instances (tuples {@link Number}/{@link Unit}).
 *
 * For example:<br/><code>
 *      Mass m = QuantityFactory.getInstance(Mass.class).create(23.0, KILOGRAM); // 23.0 kg<br/>
 *      Time m = QuantityFactory.getInstance(Time.class).create(124, MILLI(SECOND)); // 124 ms
 * </code>
 * @param <Q> The type of the quantity.
 *
 * @author  <a href="mailto:desruisseaux@users.sourceforge.net">Martin Desruisseaux</a>
 * @author  <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @author  <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @version 0.6, $Date: 2014-10-30 $
 */
public abstract class TestQuantityFactory<Q extends Quantity<Q>> implements QuantityFactory<Q>  {

    /**
     * Holds the current instances.
     */
    @SuppressWarnings("rawtypes")
    private static final Map<Class, QuantityFactory> INSTANCES = new HashMap<Class, QuantityFactory>();

    private static final Logger logger = Logger.getLogger(TestQuantityFactory.class.getName());

    private static final Level LOG_LEVEL = Level.FINE;

    /**
     * Returns the default instance for the specified quantity type.
     *
     * @param <Q> The type of the quantity
     * @param type the quantity type
     * @return the quantity factory for the specified type
     */
    @SuppressWarnings("unchecked")
	public static <Q extends Quantity<Q>> QuantityFactory<Q> getInstance(final Class<Q> type) {

         logger.log(LOG_LEVEL, "Type: " + type + ": " + type.isInterface());
         QuantityFactory<Q> factory;
         if (!type.isInterface()) {
        	 if (type != null && type.getInterfaces() != null & type.getInterfaces().length > 0) {
	        	 logger.log(LOG_LEVEL, "Type0: " + type.getInterfaces()[0]);
	             Class<?> type2 = type.getInterfaces()[0];

	            factory = INSTANCES.get(type2);
	            if (factory != null) return factory;
	            if (!TestQuantity.class.isAssignableFrom(type2))
	                // This exception is not documented because it should never happen if the
	                // user don't try to trick the Java generic types system with unsafe cast.
	                throw new ClassCastException();
	            factory = new Default<Q>((Class<Q>)type2);
	            INSTANCES.put(type2, factory);
        	 } else {
                 factory = INSTANCES.get(type);
                 if (factory != null) return factory;
                 if (!TestQuantity.class.isAssignableFrom(type))
                     // This exception is not documented because it should never happen if the
                     // user don't try to trick the Java generic types system with unsafe cast.
                     throw new ClassCastException();
                 factory = new Default<Q>(type);
                 INSTANCES.put(type, factory);
        	 }
         } else {
            factory = INSTANCES.get(type);
            if (factory != null) return factory;
            if (!Quantity.class.isAssignableFrom(type))
                // This exception is not documented because it should never happen if the
                // user don't try to trick the Java generic types system with unsafe cast.
                throw new ClassCastException();
            factory = new Default<Q>(type);
            INSTANCES.put(type, factory);
         }
        return factory;
    }

    /**
     * Overrides the default implementation of the factory for the specified
     * quantity type.
     *
     * @param <Q> The type of the quantity
     * @param type the quantity type
     * @param factory the quantity factory
     */
    protected static <Q extends Quantity<Q>>  void setInstance(final Class<Q> type, TestQuantityFactory<Q> factory) {
        if (!TestQuantity.class.isAssignableFrom(type))
            // This exception is not documented because it should never happen if the
            // user don't try to trick the Java generic types system with unsafe cast.
            throw new ClassCastException();
        INSTANCES.put(type, factory);
    }

    /**
     * Returns the quantity for the specified number stated in the specified unit.
     *
     * @param value the value stated in the specified unit
     * @param unit the unit
     * @return the corresponding quantity
     */
    public abstract Quantity<Q> create(Number value, Unit<Q> unit);

    /**
     * Returns the metric unit for quantities produced by this factory
     * or <code>null</code> if unknown.
     *
     * @return the metric units for this factory quantities.
     */
    public abstract Unit<Q> getMetricUnit();

    /**
     * The default factory implementation. This factory provides
     * a default implementation for every {@link AbstractQuantity} sub-types.
     *
     * @param <Q> The type of the quantity
     */
    private static final class Default<Q extends Quantity<Q>>  extends TestQuantityFactory<Q> {

        /**
         * The type of the quantities created by this factory.
         */
        @SuppressWarnings("unused")
	private final Class<Q> type;

        /**
         * The metric unit for quantities created by this factory.
         */
        private final Unit<Q> metricUnit;

        /**
         * Creates a new factory for quantities of the given type.
         *
         * @param type The type of the quantities created by this factory.
         */
        @SuppressWarnings("unchecked")
	Default(final Class<Q> type) {
            this.type = type;
            metricUnit = CLASS_TO_METRIC_UNIT.get(type);
        }
        
        @SuppressWarnings("rawtypes")
	static final Map<Class, Unit> CLASS_TO_METRIC_UNIT = new HashMap<Class, Unit>();
        static {
            CLASS_TO_METRIC_UNIT.put(Dimensionless.class, TestUnit.ONE);
            CLASS_TO_METRIC_UNIT.put(Length.class, m);
//            CLASS_TO_METRIC_UNIT.put(Time.class, s);
//            CLASS_TO_METRIC_UNIT.put(Area.class, SQUARE_METRE);
//            CLASS_TO_METRIC_UNIT.put(Volume.class, CUBIC_METRE);
        }

        public Quantity<Q> create(Number value, Unit<Q> unit) {
            //return (Q) new BaseQuantity<Q>(number, unit);
        	return null; // FIXME here we need to instantiate "SOMETHING" (a concrete class;-)
        }

        public Unit<Q> getMetricUnit() {
            return metricUnit;
        }
    }
}
