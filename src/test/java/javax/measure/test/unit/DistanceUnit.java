/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.unit;

import javax.measure.Unit;
import javax.measure.quantity.Length;

/**
 * @author werner.keil
 */
public class DistanceUnit extends BaseUnit<Length> {

    public static final DistanceUnit m = new DistanceUnit("m", 1.0); // reference
    // Unit
    public static final DistanceUnit REF_UNIT = m; // reference Unit
    public static final DistanceUnit in = new DistanceUnit("in", 0.0254);
    public static final DistanceUnit km = new DistanceUnit("km", 1.0e+3);
    public static final DistanceUnit cm = new DistanceUnit("cm", 1.0e-2);
    public static final DistanceUnit mile = new DistanceUnit("mile", 1609.0);
    public static final DistanceUnit \u00C5ngstr\u00F6m = new DistanceUnit("\u00C5ngstr\u00F6m", 1.0e-10);
    public static final DistanceUnit AU = new DistanceUnit("AU", 1.5e+11);
    public static final DistanceUnit parsec = new DistanceUnit("parsec", 3.08e+16);

    public DistanceUnit(String name2, double convF) {
        super("", name2);
        name = name2;
        multFactor = convF;
    }

    public DistanceUnit(String name2, DistanceUnit unit, double convF) {
        super("", name2);
        name = name2;
        multFactor = unit.multFactor * convF;
    }

    @Override
    public Unit<Length> getSystemUnit() {
        return REF_UNIT;
    }
}
