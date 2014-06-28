/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import javax.measure.test.quantity.DistanceQuantity;


/**
 * @author paul.morrison
 */
public class TripLeg {

    String fromAirport;
    String toAirport;
    DistanceQuantity distance;

    public TripLeg(String fA, String tA, DistanceQuantity dist) {
        fromAirport = fA;
        toAirport = tA;
        distance = dist;
    }

    public DistanceQuantity getDist() {
        return distance;
    }
}
