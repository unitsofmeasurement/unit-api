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
package javax.measure.test.unit;

import javax.measure.Prefix;
import javax.measure.Quantity;
import javax.measure.Unit;
import javax.measure.UnitConverter;
import javax.measure.quantity.Temperature;
import javax.measure.test.TestUnit;

/**
 * @author Werner Keil
 * @version 0.7, $Date: 2019-02-06 $
 */
public class TemperatureUnit extends TestUnit<Temperature> {
	private static final char DEG = '\u00B0';
	/** Kelvin, commonly used in scientific endeavors. */
	public static final TemperatureUnit KELVIN = new TemperatureUnit(1d, 0d, null, 273.15d, 373.15d, "K",
			"William Thomson, 1st Baron Kelvin");

	/** Rankine, used in scientific endeavors. */
	public static final TemperatureUnit RANKINE = new TemperatureUnit(5 / 9, 0d, KELVIN, 491.67d, 671.641d, DEG + "R",
			"William John Macquorn Rankine");

	/** Celsius, used by most of the world's population. */
	public static final TemperatureUnit CELSIUS = new TemperatureUnit(0d, 273.15d, KELVIN, 0d, 100d, DEG + "C",
			"Anders Celsius");

	/** Fahrenheit, commonly used in the United States. */
	public static final TemperatureUnit FAHRENHEIT = new TemperatureUnit(0d, 459.67d, RANKINE, 32d, 212d, DEG + "F",
			"Daniel Gabriel Fahrenheit");

	/** Units by which this temperature scale is expressed. */
	private final String description;

	private final double multFactor;

	/** Name of person that this temperature scale is named for. */
	private final String namedFor;

	/**
	 * Constructor for TemperatureUnit that accepts key characteristics of each
	 * temperature scale.
	 * @param rel The temperature unit this is relative to.
	 * @param newFreezingPoint Freezing point for this temperature scale.
	 * @param newBoilingPoint  Boiling point for this temperature scale.
	 * @param newSymbol        Unit symbol for this temperature scale.
	 * @param newNamedFor      Name of person after which temperature scale was
	 *                         named.
	 * @param newMult          new multiplier
	 * @param shift            the shift factor
	 */
	public TemperatureUnit(double newMult, double shift, final TemperatureUnit rel, double newFreezingPoint,
			double newBoilingPoint, final String newSymbol, final String newNamedFor) {
		this.multFactor = newMult;
		this.description = newSymbol;
		this.namedFor = newNamedFor;
	}

	public String getSymbol() {
		return description;
	}

	public double getFactor() {
		return multFactor;
	}

	public String getName() {
		return namedFor;
	}

	public Unit<Temperature> getSystemUnit() {
		return KELVIN;
	}

	public static TemperatureUnit getBySymbol(String symbol) {
		if (CELSIUS.getSymbol().equals(symbol)) {
			return CELSIUS;
		}
		if (FAHRENHEIT.getSymbol().equals(symbol)) {
			return FAHRENHEIT;
		}
		return KELVIN;
	}

	public boolean isCompatible(Unit<?> that) {
		return that instanceof TemperatureUnit;
	}

	@SuppressWarnings({ "unchecked" })
	public final <T extends Quantity<T>> Unit<T> asType(Class<T> type) {
		Unit<T> metricUnit = (Unit<T>) getSystemUnit();
		if ((metricUnit == null) || metricUnit.isCompatible(this))
			return (Unit<T>) this;
		throw new ClassCastException("The unit: " + this //$NON-NLS-1$
				+ " is not of parameterized type " + type); //$NON-NLS-1$
	}

	public Unit<Temperature> multiply(double factor) {
		return this;
	}

	public Unit<?> multiply(Unit<?> that) {
		return this;
	}

	public Unit<?> pow(int n) {
		return this;
	}

	public Unit<?> root(int n) {
		return this;
	}

	public Unit<Temperature> transform(UnitConverter operation) {
		return this;
	}

	public Unit<Temperature> shift(double v) {
		return this;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public Unit<Temperature> prefix(Prefix prefix) {
		return this.multiply(Math.pow(prefix.getValue().doubleValue(), 
				prefix.getExponent()));
	}
}
