/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test;

import javax.measure.test.quantity.AreaQuantity;
import javax.measure.test.quantity.DistanceQuantity;
import javax.measure.test.unit.DistanceUnit;

public class CircleInfo {

    public static void main(String[] args) {
        DistanceQuantity radius = new DistanceQuantity(30, DistanceUnit.cm);
        System.out.println("Radius = " + radius);
        double mult = 2 * Math.PI;
        DistanceQuantity circumference = radius.multiply(mult);
        System.out.println("Circumference = " + circumference);
        AreaQuantity area = (radius.multiply(radius)).multiply(Math.PI);
        System.out.println("Area = " + area);
    }

}
