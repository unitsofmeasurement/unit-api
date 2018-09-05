/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.measure.format.QuantityFormat;
import javax.measure.format.UnitFormat;

/**
 * Tests for {@link FormatService}.
 */
public class FormatServiceTest {

  /**
   * Tests {@link ServiceProvider#current()} and {@link ServiceProvider#setCurrent(ServiceProvider)}. The getter and setter are tested in a single
   * method for avoiding issues with the order in which JUnit executes tests.
   */
  @Test
  public void testGetDefault() {
    FormatService service = new TestFormatService();
    assertEquals(0, service.getAvailableFormatNames().size());
  }

  /**
   * Tests {@link FormatService#FormatType}.
   */
  @Test
  public void testTypes() {
    assertEquals(2, FormatService.FormatType.values().length);
  }

  /**
   * Test format service.
   */
  private static final class TestFormatService implements FormatService {
    private final Map<String, UnitFormat> unitFormats = new HashMap<>();
    private final Map<String, QuantityFormat> quantityFormats = new HashMap<>();

    /*
     * (non-Javadoc)
     *
     * @see UnitFormatService#getUnitFormat(String)
     */
    @Override
    public UnitFormat getUnitFormat(String formatName) {
      Objects.requireNonNull(formatName, "Format name required");
      return unitFormats.get(formatName);
    }

    /*
     * (non-Javadoc)
     *
     * @see UnitFormatService#getUnitFormat()
     */
    @Override
    public UnitFormat getUnitFormat() {
      return getUnitFormat("");
    }

    public Set<String> getAvailableFormatNames() {
      return getAvailableFormatNames(FormatType.UNIT_FORMAT);
    }

    @Override
    public QuantityFormat getQuantityFormat() {
      return getQuantityFormat("");
    }

    @Override
    public QuantityFormat getQuantityFormat(String name) {
      Objects.requireNonNull(name, "Format name required");
      return quantityFormats.get(name);
    }

    @Override
    public Set<String> getAvailableFormatNames(FormatType type) {
      switch (type) {
        case QUANTITY_FORMAT:
          return quantityFormats.keySet();
        default:
          return unitFormats.keySet();
      }
    }
  }
}
