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

import javax.measure.Quantity;
import javax.measure.Unit;

/**
 * <p>
 * This class provides support for the 20 prefixes used in the metric system (decimal multiples and submultiples of units). For example:
 * 
 * <pre>
 * <code>
 *     import static tech.units.indriya.unit.Units.*;  // Static import.
 *     import static tech.units.indriya.unit.MetricPrefix.*; // Static import.
 *     import javax.measure.*;
 *     import javax.measure.quantity.*;
 *     ...
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 *     Unit<Length> KILOMETRE = KILO(METRE);
 *     </code>
 * </pre>
 * 
 * </p>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Metric_prefix">Wikipedia: Metric Prefix</a>
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.6, 2018-04-17
 * @since 2.0
 */
public enum MetricPrefix implements Prefix {
  YOTTA("Y", Math.pow(10, 24)), //
  ZETTA("Z", Math.pow(10, 21)), //
  EXA("E", Math.pow(10, 18)), //
  PETA("P", Math.pow(10, 15)), //
  TERA("T", Math.pow(10, 12)), //
  GIGA("G", Math.pow(10, 9)), //
  MEGA("M", Math.pow(10, 6)), //
  KILO("k", Math.pow(10, 3)), //
  HECTO("h", Math.pow(10, 2)), //
  DEKA("da", Math.pow(10, 1)), //
  DECI("d", Math.pow(10, -1)), //
  CENTI("c", Math.pow(10, -2)), //
  MILLI("m", Math.pow(10, -3)), //
  MICRO("µ", Math.pow(10, -6)), //
  NANO("n", Math.pow(10, -9)), //
  PICO("p", Math.pow(10, -12)), //
  FEMTO("f", Math.pow(10, -15)), //
  ATTO("a", Math.pow(10, -18)), //
  ZEPTO("z", Math.pow(10, -21)), //
  YOCTO("y", Math.pow(10, -24));

  /**
   * The symbol of this prefix, as returned by {@link #getSymbol}.
   *
   * @serial
   * @see #getSymbol()
   */
  private final String symbol;

  /**
   * The <code>UnitConverter</code> of this prefix, as returned by {@link #getConverter}.
   *
   * @serial
   * @see #getConverter()
   * @see {@link UnitConverter}
   */
  private final Number converter;

  /**
   * Creates a new prefix.
   *
   * @param symbol
   *          the symbol of this prefix.
   * @param converter
   *          the associated unit converter.
   */
  private MetricPrefix(String symbol, Number converter) {
    this.symbol = symbol;
    this.converter = converter;
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>24</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e24)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> YOTTA(Unit<Q> unit) {
    return unit.multiply(YOTTA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>21</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e21)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> ZETTA(Unit<Q> unit) {
    return unit.multiply(ZETTA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>18</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e18)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> EXA(Unit<Q> unit) {
    return unit.multiply(EXA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>15</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e15)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> PETA(Unit<Q> unit) {
    return unit.multiply(PETA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>12</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e12)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> TERA(Unit<Q> unit) {
    return unit.multiply(TERA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>9</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e9)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> GIGA(Unit<Q> unit) {
    return unit.multiply(GIGA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>6</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e6)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> MEGA(Unit<Q> unit) {
    return unit.multiply(MEGA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>3</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e3)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> KILO(Unit<Q> unit) {
    return unit.multiply(KILO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>2</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e2)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> HECTO(Unit<Q> unit) {
    return unit.multiply(HECTO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>1</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e1)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> DEKA(Unit<Q> unit) {
    return unit.multiply(DEKA.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-1</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-1)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> DECI(Unit<Q> unit) {
    return unit.multiply(DECI.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-2</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-2)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> CENTI(Unit<Q> unit) {
    return unit.multiply(CENTI.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-3</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-3)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> MILLI(Unit<Q> unit) {
    return unit.multiply(MILLI.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-6</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-6)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> MICRO(Unit<Q> unit) {
    return unit.multiply(MICRO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-9</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-9)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> NANO(Unit<Q> unit) {
    return unit.multiply(NANO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-12</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-12)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> PICO(Unit<Q> unit) {
    return unit.multiply(PICO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-15</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-15)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> FEMTO(Unit<Q> unit) {
    return unit.multiply(FEMTO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-18</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-18)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> ATTO(Unit<Q> unit) {
    return unit.multiply(ATTO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-21</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-21)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> ZEPTO(Unit<Q> unit) {
    return unit.multiply(ZEPTO.getFactor().doubleValue());
  }

  /**
   * Returns the specified unit multiplied by the factor <code>10<sup>-24</sup></code>
   *
   * @param <Q>
   *          The type of the quantity measured by the unit.
   * @param unit
   *          any unit.
   * @return <code>unit.times(1e-24)</code>.
   */
  public static <Q extends Quantity<Q>> Unit<Q> YOCTO(Unit<Q> unit) {
    return unit.multiply(YOCTO.getFactor().doubleValue());
  }

  /**
   * Returns the corresponding conversion factor.
   *
   * @return the conversion factor.
   */
  public Number getFactor() {
    return converter;
  }

  /**
   * Returns the symbol of this prefix.
   *
   * @return this prefix symbol, not {@code null}.
   */
  public String getSymbol() {
    return symbol;
  }
}
