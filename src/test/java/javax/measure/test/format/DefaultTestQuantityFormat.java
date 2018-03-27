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
package javax.measure.test.format;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParsePosition;

import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.format.MeasurementParseException;
import javax.measure.format.ParserException;
import javax.measure.format.QuantityFormat;
import javax.measure.test.TestUnit;
import javax.measure.test.quantity.TestQuantities;

/**
 * Holds standard implementation
 */
@SuppressWarnings("rawtypes")
class DefaultTestQuantityFormat extends TestQuantityFormat {

  /**
   * Returns the Quantity format for the default locale.
   *
   * @return the locale format.
   */
  public static QuantityFormat getInstance() {
    return new DefaultTestQuantityFormat();
  }

  @Override
  public Appendable format(Quantity measure, Appendable dest) throws IOException {
    Unit unit = measure.getUnit();

    dest.append(measure.getValue().toString());
    if (measure.getUnit().equals(TestUnit.ONE))
      return dest;
    dest.append(' ');
    return SimpleTestUnitFormat.getInstance().format(unit, dest);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Quantity<?> parse(CharSequence csq, ParsePosition cursor) throws MeasurementParseException {
    int startDecimal = cursor.getIndex();
    while ((startDecimal < csq.length()) && Character.isWhitespace(csq.charAt(startDecimal))) {
      startDecimal++;
    }
    int endDecimal = startDecimal + 1;
    while ((endDecimal < csq.length()) && !Character.isWhitespace(csq.charAt(endDecimal))) {
      endDecimal++;
    }
    BigDecimal decimal = new BigDecimal(csq.subSequence(startDecimal, endDecimal).toString());
    cursor.setIndex(endDecimal + 1);
    Unit unit = SimpleTestUnitFormat.getInstance().parse(csq);
    return TestQuantities.getQuantity(decimal, unit);
  }

  @SuppressWarnings("unchecked")
  @Override
  public Quantity<?> parse(CharSequence csq, int index) throws MeasurementParseException {
    int startDecimal = index; // cursor.getIndex();
    while ((startDecimal < csq.length()) && Character.isWhitespace(csq.charAt(startDecimal))) {
      startDecimal++;
    }
    int endDecimal = startDecimal + 1;
    while ((endDecimal < csq.length()) && !Character.isWhitespace(csq.charAt(endDecimal))) {
      endDecimal++;
    }
    try {
      final Double decimal = new Double(csq.subSequence(startDecimal, endDecimal).toString());
      final String uStr = csq.subSequence(endDecimal + 1, csq.length()).toString();
      Unit unit = SimpleTestUnitFormat.getInstance().parse(uStr);
      return TestQuantities.getQuantity(decimal, unit);
    } catch (NumberFormatException nfe) {
      throw new MeasurementParseException(nfe);
    }
  }
}
