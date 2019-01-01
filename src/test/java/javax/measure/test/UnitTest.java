/*
 * Units of Measurement API
 * Copyright (c) 2014-2019, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import static org.junit.jupiter.api.Assertions.*;
import static javax.measure.test.EnumUnit.TEST;

import javax.measure.Dimension;
import javax.measure.UnconvertibleException;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.test.unit.BaseUnit;
import javax.measure.test.unit.DistanceUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Werner
 *
 */
public class UnitTest {
    @SuppressWarnings("rawtypes")
    private Unit sut;

    @BeforeEach
    public void init() {
        sut = TEST;
    }

    /**
     * Test method for {@link javax.measure.test.EnumUnit#getSymbol()}.
     */
    @Test
    public void testGetSymbol() {
        assertNotNull(sut.getSymbol());
        assertEquals("t", sut.getSymbol());
    }

    /**
     * Test method for {@link javax.measure.test.EnumUnit#getDimension()}.
     */
    @Test
    public void testGetDimension() {
        final Dimension dim = TestDimension.getInstance();
        assertEquals(dim, sut.getDimension());
    }

    /**
     * Test method for {@link javax.measure.test.EnumUnit#isCompatible(javax.measure.Unit)}.
     */
    @SuppressWarnings("unchecked")
    @Test
    public void testIsCompatible() {
        assertTrue(sut.isCompatible(TEST));
    }

    @Test
    public void testGetConverterTo() {
        assertThrows(UnconvertibleException.class, () -> {
            sut = DistanceUnit.m;
            @SuppressWarnings("unchecked")
            UnitConverter converter = sut.getConverterTo(BaseUnit.ONE);
            assertNotNull(converter);
        });
    }
}
