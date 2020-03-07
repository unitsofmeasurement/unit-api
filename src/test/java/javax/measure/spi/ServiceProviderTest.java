/*
 * Units of Measurement API
 * Copyright (c) 2014-2020, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
package javax.measure.spi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;

import javax.measure.BinaryPrefix;
import javax.measure.MetricPrefix;
import javax.measure.Prefix;
import javax.measure.Quantity;

/**
 * Tests for {@link ServiceProvider}.
 */
public class ServiceProviderTest {

    @Test
    public void testSetCurrentNull() {
        assertThrows(NullPointerException.class, () -> {
            ServiceProvider.setCurrent(null);
        });
    }

    /**
     * Tests {@link ServiceProvider#current()} and {@link ServiceProvider#setCurrent(ServiceProvider)}. The getter and setter are tested in a single
     * method for avoiding issues with the order in which JUnit executes tests.
     */
    @Test
    public void testGetAndSetCurrent() {
        assertEquals(0, ServiceProvider.available().size());
        try {
            ServiceProvider.current();
            fail("Expected no ServiceProvider before we set one.");
        } catch (IllegalStateException e) {
            // This is the expected exception.
        }
        ServiceProvider testProv = new TestServiceProvider();
        assertNull(ServiceProvider.setCurrent(testProv), "Expected no ServiceProvider before we set one.");
        assertSame(testProv, ServiceProvider.setCurrent(testProv), "Setting the same ServiceProvider twice should be a no-op.");
        assertSame(testProv, ServiceProvider.current());
        assertArrayEquals(new ServiceProvider[] { testProv }, ServiceProvider.available().toArray());
        assertNotNull(ServiceProvider.of("TestServiceProvider"));
    }

    /**
     * Tests {@link ServiceProvider#getPriority()}.
     */
    @Test
    public void testPriority() {
        assertEquals(0, ServiceProvider.current().getPriority());
    }

    /**
     * Tests ServiceProvider#of() by passing null.
     */
    @Test
    public void testOfNull() {
        assertThrows(NullPointerException.class, () -> {
            @SuppressWarnings("unused")
            ServiceProvider dummy = ServiceProvider.of(null);
        });
    }

    /**
     * Tests ServiceProvider#of() by passing a non-existing name.
     */
    @Test
    public void testOfNonExistent() {
        assertThrows(IllegalArgumentException.class, () -> {
            @SuppressWarnings("unused")
            ServiceProvider dummy = ServiceProvider.of("ThisServiceProviderWillNeverExistHere");
        });
    }

    @Test
    public void testGetMetricPrefixes() {
        final ServiceProvider testProv = new TestServiceProvider();
        final SystemOfUnitsService service = testProv.getSystemOfUnitsService();
        Collection<MetricPrefix> prefixes = service.getPrefixes(MetricPrefix.class);
        assertNotNull(prefixes);
        assertEquals(20, prefixes.size());
    }

    @Test
    public void testGetBinaryPrefixes() {
        final ServiceProvider testProv = new TestServiceProvider();
        final SystemOfUnitsService service = testProv.getSystemOfUnitsService();
        assertNotNull(service);
        Collection<BinaryPrefix> prefixes = service.getPrefixes(BinaryPrefix.class);
        assertNotNull(prefixes);
        assertEquals(8, prefixes.size());
    }

    @Test
    public void testWrongPrefixType() {
        final ServiceProvider testProv = new TestServiceProvider();
        final SystemOfUnitsService service = testProv.getSystemOfUnitsService();
        assertNotNull(service);
        assertThrows(ClassCastException.class, () -> {
            @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
            Collection<Prefix> prefixes = service.getPrefixes((Class) String.class);
        });

    }

    @Test
    public void testWrongEnumType() {
        final ServiceProvider testProv = new TestServiceProvider();
        final SystemOfUnitsService service = testProv.getSystemOfUnitsService();
        assertNotNull(service);
        assertThrows(ClassCastException.class, () -> {
            @SuppressWarnings({ "unused", "rawtypes", "unchecked" })
            Collection<Prefix> prefixes = service.getPrefixes((Class) DummyEnum.class);
        });
    }

    private static final class TestServiceProvider extends ServiceProvider {

        @Override
        public SystemOfUnitsService getSystemOfUnitsService() {
            return new TestSystemOfUnitsService();
        }

        @Override
        public UnitFormatService getUnitFormatService() {
            return null;
        }

        @Override
        public <Q extends Quantity<Q>> QuantityFactory<Q> getQuantityFactory(Class<Q> quantity) {
            return null;
        }

        @Override
        public FormatService getFormatService() {
            return null;
        }

        @Override
        public String toString() {
            return "TestServiceProvider";
        }
    }

    private static enum DummyEnum {
        A, B
    }
}
