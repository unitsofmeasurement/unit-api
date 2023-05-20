/*
 * Units of Measurement API
 * Copyright (c) 2014-2023, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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
 * Provides support for the 24 prefixes used in the metric system (decimal multiples and submultiples of units). For example:
 *
 * <pre>
 * {@code import static tech.units.indriya.unit.Units.*;  // Static import (from the RI).
 * import static javax.measure.MetricPrefix.*; // Static import.
 * import javax.measure.*;
 * import javax.measure.quantity.*;
 * ...
 * Unit<Pressure> HECTOPASCAL = HECTO(PASCAL);
 * Unit<Length> KILOMETRE = KILO(METRE);} 
 * </pre>
 * You could also apply <code>Unit.prefix</code>:
 * <pre>
 * {@code ...
 * Unit<Pressure> HECTOPASCAL = PASCAL.prefix(HECTO);
 * Unit<Length> KILOMETRE = METRE.prefix(KILO);}
 * </pre>
 * 
 * <p>
 * <b>Do not use ordinal() to obtain the numeric representation of MetricPrefix. Use getValue() and getExponent() instead.</b>
 * </p>
 * 
 * <dl>
 * <dt><span class="strong">Implementation Requirements</span></dt><dd>This is an immutable and thread-safe enum.</dd>
 * </dl>
 * 
 * @see <a href="https://en.wikipedia.org/wiki/Metric_prefix">Wikipedia: Metric Prefix</a>
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@units.tech">Werner Keil</a>
 * @version 2.3, May 20, 2023
 * @since 2.0
 */
public enum MetricPrefix implements Prefix {
	/** Prefix for 10<sup>30</sup>. */
    QUETTA("Q", 30),
	/** Prefix for 10<sup>27</sup>. */
    RONNA("R", 27),
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
    /** Prefix for 10<sup>9</sup>.
     * @see <a href="https://en.wikipedia.org/wiki/Giga-">Wikipedia: Giga</a>  
     */
    GIGA("G", 9),
    /** Prefix for 10<sup>6</sup>. 
     * @see <a href="https://en.wikipedia.org/wiki/Mega-">Wikipedia: Mega</a> */
    MEGA("M", 6),
    /** Prefix for 10<sup>3</sup>.
     * @see <a href="https://en.wikipedia.org/wiki/Kilo-">Wikipedia: Kilo</a> 
     */
    KILO("k", 3),
    /** Prefix for 10<sup>2</sup>. 
     * @see <a href="https://en.wikipedia.org/wiki/Hecto-">Wikipedia: Hecto</a> */
    HECTO("h", 2),
    /** Prefix for 10<sup>1</sup>. 
     * @see <a href="https://en.wikipedia.org/wiki/Deca-">Wikipedia: Deca</a> */
    DECA("da", 1),
    /** Prefix for 10<sup>-1</sup>. 
     * @see <a href="https://en.wikipedia.org/wiki/Deci-">Wikipedia: Deci</a> */
    DECI("d", -1),
    /** Prefix for 10<sup>-2</sup>.
     * @see <a href="https://en.wikipedia.org/wiki/Centi-">Wikipedia: Centi</a> */     
    CENTI("c", -2),
    /** Prefix for 10<sup>-3</sup>.
     * @see <a href="https://en.wikipedia.org/wiki/Milli-">Wikipedia: Milli</a> */
    MILLI("m", -3),
    /** Prefix for 10<sup>-6</sup>.
     * @see <a href="https://en.wikipedia.org/wiki/Micro-">Wikipedia: Micro</a> */
    MICRO("\u00b5", -6),
    /** Prefix for 10<sup>-9</sup>.
     * @see <a href="https://en.wikipedia.org/wiki/Nano-">Wikipedia: Nano</a> */
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
    YOCTO("y", -24),
	/** Prefix for 10<sup>-27</sup>. */
    RONTO("r", -27),
    /** Prefix for 10<sup>-30</sup>. */
    QUECTO("q", -30);

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
     * Returns the specified unit multiplied by the factor <code>10<sup>30</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e30)</code>.
     * @see #QUETTA
     */
    public static <Q extends Quantity<Q>> Unit<Q> QUETTA(Unit<Q> unit) {
        return unit.prefix(QUETTA);
    }
    
    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>27</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e27)</code>.
     * @see #RONNA
     */
    public static <Q extends Quantity<Q>> Unit<Q> RONNA(Unit<Q> unit) {
        return unit.prefix(RONNA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>24</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e24)</code>.
     * @see #YOTTA
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
     * @see #ZETTA
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
     * @see #EXA
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
     * @see #PETA
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
     * @see #TERA
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
     * @see #GIGA
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
     * @see #MEGA
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
     * @see #KILO
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
     * @see #HECTO
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
     * @see #DECA
     */
    public static <Q extends Quantity<Q>> Unit<Q> DECA(Unit<Q> unit) {
        return unit.prefix(DECA);
    }
    
    /**
     * US alias for <code>DECA</code>.
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e1)</code>.
     * @see #DECA
     */
    public static <Q extends Quantity<Q>> Unit<Q> DEKA(Unit<Q> unit) {
        return unit.prefix(DECA);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-1</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-1)</code>.
     * @see #DECI 
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
     * @see #CENTI
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
     * @see #MILLI
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
     * @see #MICRO 
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
     * @see #NANO 
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
     * @see #PICO
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
     * @see #FEMTO
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
     * @see #ATTO 
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
     * #see ZEPTO
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
     * @see #YOCTO
     */
    public static <Q extends Quantity<Q>> Unit<Q> YOCTO(Unit<Q> unit) {
        return unit.prefix(YOCTO);
    }
    
    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-27</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-27)</code>.
     * @see #RONTO
     */
    public static <Q extends Quantity<Q>> Unit<Q> RONTO(Unit<Q> unit) {
        return unit.prefix(RONTO);
    }

    /**
     * Returns the specified unit multiplied by the factor <code>10<sup>-30</sup></code>
     *
     * @param <Q>
     *          type of the quantity measured by the unit.
     * @param unit
     *          any unit.
     * @return <code>unit.times(1e-30)</code>.
     * @see #QUECTO
     */
    public static <Q extends Quantity<Q>> Unit<Q> QUECTO(Unit<Q> unit) {
        return unit.prefix(QUECTO);
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
     * Base part of the associated factor in {@code base^exponent} representation. For metric prefix, this is always 10.
     */
    @Override
    public Integer getValue() {
        return 10;
    }

    /**
     * Exponent part of the associated factor in {@code base^exponent} representation.
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
