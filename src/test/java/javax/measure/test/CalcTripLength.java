/*
 * Units of Measurement API
 * Copyright (c) 2014-2025, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
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
package javax.measure.test;

import java.util.LinkedList;

import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.unit.DistanceUnit;

/**
 * @author paul.morrison
 */
public class CalcTripLength {

    public static void main(String[] argv) {

        final DistanceUnit klik = new DistanceUnit("kilometre", DistanceUnit.km, 1.0);

        LinkedList<TripLeg> trip = new LinkedList<TripLeg>();
        trip.add(new TripLeg("YKK", "NYC", new DistanceQuantity(1200.0, klik)));
        trip.add(new TripLeg("NYC", "LAX", new DistanceQuantity(5000.0, DistanceUnit.km)));

        DistanceQuantity totDist = new DistanceQuantity(0, klik);

        for (TripLeg t : trip) {
            totDist = totDist.add(t.getDist());
        }

        boolean b = totDist.eq(new DistanceQuantity(6200, klik));

        System.out.println(totDist.showInUnits(klik, 2));
        System.out.println(b ? "true" : "false");

    }
}
