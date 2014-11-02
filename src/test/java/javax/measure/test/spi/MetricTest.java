/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.spi;

import static org.junit.Assert.assertNull;

import javax.measure.spi.SystemOfUnitsService;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;


@Ignore
public class MetricTest {

    private SystemOfUnitsService metric;

    @Before
    public void setUp() {
//      metric = Metric.getInstance();
    }

    @Test
    public void testGetUnits() {
        assertNull(metric);
    }
}
