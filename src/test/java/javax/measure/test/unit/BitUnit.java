/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.unit;

import javax.measure.Unit;
import javax.measure.quantity.Information;
import javax.measure.test.TestUnit;

/**
 * @author Werner Keil
 * @version 1.0
 */
public class BitUnit extends TestUnit<Information> {

    public static final BitUnit bit = new BitUnit("bit", 1.0); // reference Unit
    public static final BitUnit REF_UNIT = bit; // reference Unit
    public static final BitUnit kb = new BitUnit("kb", 1.0e3);

    public BitUnit(String name2, double convF) {
    	super(name2);
        multFactor = convF;
    }

    @Override
    public Unit<Information> getSystemUnit() {
        return REF_UNIT;
    }
}
