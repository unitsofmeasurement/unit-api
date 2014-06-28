/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import java.util.LinkedList;

import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.unit.DistanceUnit;


/**
 * @author paul.morrison
 */
public class CalcTripLength {

    public static void main(String[] argv)  {

        final DistanceUnit klik = new DistanceUnit("kilometre", DistanceUnit.km, 1.0);

        LinkedList<TripLeg> trip = new LinkedList<>();
        trip.add(new TripLeg("YKK", "NYC", new DistanceQuantity(1200.0, klik)));
        trip.add(new TripLeg("NYC", "LAX", new DistanceQuantity(5000.0, DistanceUnit.km)));

        DistanceQuantity totDist = new DistanceQuantity(0, klik);

        for (TripLeg t : trip) {
            totDist = totDist.add(t.getDist());
        }

        boolean b = totDist.eq(new DistanceQuantity(6200,klik));

        System.out.println(totDist.showInUnits(klik, 2));
        System.out.println(b ? "true" : "false");

    }

}
