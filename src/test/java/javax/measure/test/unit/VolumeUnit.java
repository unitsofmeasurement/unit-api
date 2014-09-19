/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.unit;

import javax.measure.Unit;
import javax.measure.quantity.Volume;
import javax.measure.test.TestUnit;

/**
 * @author Werner Keil
 */
public class VolumeUnit extends TestUnit<Volume> {
    public static final VolumeUnit cumetre = new VolumeUnit("cumetre", 1.0); // reference Unit
    public static final VolumeUnit REF_UNIT = cumetre; // reference Unit
    public static final VolumeUnit cumile = new VolumeUnit("cumile", 1609.0 * 1609.0 * 1609.0);
    public static final VolumeUnit bushel = new VolumeUnit("bushel", 0.03524);
    public static final VolumeUnit litre = new VolumeUnit("litre", 0.001);
    public static final VolumeUnit cc = new VolumeUnit("cc", 1.0e-6);

    public VolumeUnit(String name2, double convF) {
    	super(name2);
        multFactor = convF;
    }

    @Override
    public Unit<Volume> getSystemUnit() {
        return REF_UNIT;
    }
}
