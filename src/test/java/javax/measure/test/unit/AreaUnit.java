/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.unit;

import javax.measure.Unit;
import javax.measure.quantity.Area;
import javax.measure.test.TestUnit;



/**
 * @author Werner Keil
 */
public class AreaUnit extends TestUnit<Area> {

    public static final AreaUnit sqmetre = new AreaUnit("sqmetre", 1.0); // reference Unit
    public static final AreaUnit REF_UNIT = sqmetre; // reference Unit
    public static final AreaUnit sqmile = new AreaUnit("sqmile", 1609.0 * 1609.0);
    public static final AreaUnit acre = new AreaUnit("acre", 4047.0);
    public static final AreaUnit hectare = new AreaUnit("hectare", 1.0e4);

    public AreaUnit(String name2, double convF) {
        name = name2;
        multFactor = convF;
    }

    @Override
    public Unit<Area> getSystemUnit() {
        return REF_UNIT;
    }
}
