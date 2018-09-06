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
package javax.measure;

/**
 * Provides support for the 20 prefixes used in the metric system (decimal multiples and submultiples of units). For example:
 *
 * <pre>
 * {@code
 *     import static tech.units.indriya.unit.Units.*;  // Static import.
 *     import static javax.measure.MetricPrefix.*; // Static import.
 *     import javax.measure.*;
 *     import javax.measure.quantity.*;
 *     ...
 *     Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 *     Unit<Length> KILOMETRE = KILO(METRE);}
 * </pre>
 *
 * @see <a href="http://en.wikipedia.org/wiki/Metric_prefix">Wikipedia: Metric Prefix</a>
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.9, 2018-08-08
 * @since 2.0
 */
public enum MetricPrefix implements Prefix {
    /** Prefix for 10<sup>24</sup>. */
    YOTTA("Y", 24),
    /** Prefix for 10<sup>21</sup>. */
    ZETTA("Z", 21),
    /** Prefix for 10<sup>18</sup>. */
    EXA("E", 18),
    /** Prefix for 10<sup>15</sup>. */
    PETA("P", 15),
    /** Prefix for 10<sup>12</sup>. */
    TERA("T", 12),
    /** Prefix for 10<sup>9</sup>. */
    GIGA("G", 9),
    /** Prefix for 10<sup>6</sup>. */
    MEGA("M", 6),
    /** Prefix for 10<sup>3</sup>. */
    KILO("k", 3),
    /** Prefix for 10<sup>2</sup>. */
    HECTO("h", 2),
    /** Prefix for 10<sup>1</sup>. */
    DEKA("da", 1),
    /** Prefix for 10<sup>-1</sup>. */
    DECI("d", -1),
    /** Prefix for 10<sup>-2</sup>. */
    CENTI("c", -2),
    /** Prefix for 10<sup>-3</sup>. */
    MILLI("m", -3),
    /** Prefix for 10<sup>-6</sup>. */
    MICRO("µ", -6),
    /** Prefix for 10<sup>-9</sup>. */
    NANO("n", -9),
    /** Prefix for 10<sup>-12</sup>. */
    PICO("p", -12),
    /** Prefix for 10<sup>-15</sup>. */
    FEMTO("f", -15),
    /** Prefix for 10<sup>-18</sup>. */
    ATTO("a", -18),
    /** Prefix for 10<sup>-21</sup>. */
    ZEPTO("z", -21),
    /** Prefix for 10<sup>-24</sup>. */
    YOCTO("y", -24);

    /**
     * The symbol of this prefix, as returned by {@link #getSymbol}.
     *
     * @serial
     * @see #getSymbol()
     */
    private final String symbol;

    /**
     * Exponent part of the associated factor in base^exponent representation.
     */
    private final int exponent;

    /**
     * Creates a new prefix.
     *
     * @param symbol
     *          the symbol of this prefix.
     * @param exponent
     *          part of the associated factor in base^exponent representation.
     */
    private MetricPrefix(String symbol, int exponent) {
        this.symbol = symbol;
        this.exponent = exponent;
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>24</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e24)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> YOTTA(Unit<Q> unit) {
        return unit.prefix(YOTTA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>21</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e21)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> ZETTA(Unit<Q> unit) {
        return unit.prefix(ZETTA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>18</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e18)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> EXA(Unit<Q> unit) {
        return unit.prefix(EXA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>15</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e15)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> PETA(Unit<Q> unit) {
        return unit.prefix(PETA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>12</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e12)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> TERA(Unit<Q> unit) {
        return unit.prefix(TERA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>9</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e9)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> GIGA(Unit<Q> unit) {
        return unit.prefix(GIGA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>6</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e6)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> MEGA(Unit<Q> unit) {
        return unit.prefix(MEGA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>3</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e3)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> KILO(Unit<Q> unit) {
        return unit.prefix(KILO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>2</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e2)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> HECTO(Unit<Q> unit) {
        return unit.prefix(HECTO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>1</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e1)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> DEKA(Unit<Q> unit) {
        return unit.prefix(DEKA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-1</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-1)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> DECI(Unit<Q> unit) {
        return unit.prefix(DECI);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-2</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-2)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> CENTI(Unit<Q> unit) {
        return unit.prefix(CENTI);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-3</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-3)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> MILLI(Unit<Q> unit) {
        return unit.prefix(MILLI);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-6</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-6)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> MICRO(Unit<Q> unit) {
        return unit.prefix(MICRO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-9</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-9)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> NANO(Unit<Q> unit) {
        return unit.prefix(NANO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-12</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-12)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> PICO(Unit<Q> unit) {
        return unit.prefix(PICO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-15</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-15)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> FEMTO(Unit<Q> unit) {
        return unit.prefix(FEMTO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-18</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-18)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> ATTO(Unit<Q> unit) {
        return unit.prefix(ATTO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-21</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-21)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> ZEPTO(Unit<Q> unit) {
        return unit.prefix(ZEPTO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-24</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-24)</code>.
     */
    public static <Q extends Quantity<Q>> Unit<Q> YOCTO(Unit<Q> unit) {
        return unit.prefix(YOCTO);
    }

    /**
     * Returns the symbol of this prefix.
     *
     * @return this prefix symbol, not {@code null}.
     */
    @Override
    public String getSymbol() {
        return symbol;
    }

    /**
     * Base part of the associated factor in base^exponent representation. For metric prefix, this is always 10.
     */
    @Override
    public int getBase() {
        return 10;
    }

    /**
     * Exponent part of the associated factor in base^exponent representation.
     */
    @Override
    public int getExponent() {
        return exponent;
    }

    /**
     * Returns the name of this prefix.
     *
     * @return this prefix name, not {@code null}.
     */
    @Override
    public String getName() {
        return name();
    }
}
