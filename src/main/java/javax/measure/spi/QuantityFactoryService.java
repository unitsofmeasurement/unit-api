/*
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014-2015 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.spi;
import javax.measure.Quantity;
import javax.measure.spi.QuantityFactory;

/**
 * Provider of {@link QuantityFactory}
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @author <a href="mailto:otaviojava@java.net">Otavio Santana</a>
 * @version 0.2
 */
public interface QuantityFactoryService {

    /**
     * Return a factory for this {@link Quantity}.
     * @param quantity the quantity
     * @return the {@link QuantityFactory}
     * @throws NullPointerException
     */
    <Q extends Quantity<Q>>  QuantityFactory<Q> getQuantityFactory(Class<Q> quantity);
}
