/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.unit;

import javax.measure.Unit;
import javax.measure.quantity.Time;

/**
 * @author Werner Keil
 * @version 1.1
 */
public class TimeUnit extends BaseUnit<Time> {

    public static final TimeUnit s = new TimeUnit("s", 1.0); // reference Unit
    public static final TimeUnit REF_UNIT = s; // reference Unit
    public static final TimeUnit h = new TimeUnit("h", 60);

    public TimeUnit(String name2, double convF) {
        super(name2, "");
        multFactor = convF;
    }

    @Override
    public Unit<Time> getSystemUnit() {
        return REF_UNIT;
    }
}
