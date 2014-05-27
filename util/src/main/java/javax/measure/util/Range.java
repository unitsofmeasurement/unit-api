/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.util;

/**
 * A Measurement Range is a pair of <code>T</code> items that represent a range
 * of values.
 * <p>
 * Range limits MUST be presented in the same scale and have the same unit as
 * measured data values.<br/>
 * The Range MUST be immutable.
 * 
 * @param <T>
 *            The value of the range.
 * 
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 0.8.6, May 28, 2014
 * @see <a
 *      href="http://www.botts-inc.com/SensorML_1.0.1/schemaBrowser/SensorML_QuantityRange.html">
 *      SensorML: QuantityRange</a>
 */
public class Range<T> implements MinimumSupplier<T>, MaximumSupplier<T> {
	// TODO do we keep null for min and max to represent infinity?
	// Java 8 Optional was evaluated, but caused conflict with the type-safe
	// Quantity feature of this API, plus it won't work in CLDC8
	private final T min;
	private final T max;
	private T res;

	/**
	 * Construct an instance of Range with a min, max and res value.
	 *
	 * @param min
	 *            The minimum value for the measurement range.
	 * @param max
	 *            The maximum value for the measurement range.
	 * @param res
	 *            The resolution of the measurement range.
	 */
	protected Range(T min, T max, T res) {
		this.min = min;
		this.max = max;
		this.res = res;
	}

	/**
	 * Construct an instance of Range with a min and max value.
	 *
	 * @param min
	 *            The minimum value for the measurement range.
	 * @param max
	 *            The maximum value for the measurement range.
	 */
	protected Range(T min, T max) {
		this.min = min;
		this.max = max;
	}

	/**
	 * Returns an {@code Range} with the specified values.
	 *
	 * @param <T>
	 *            the class of the value
	 * @param minimum
	 *            The minimum value for the measurement range.
	 * @param maximum
	 *            The maximum value for the measurement range.
	 * @param resolution
	 *            The resolution of the measurement range.
	 * @return an {@code MeasurementRange} with the given values
	 */
	public static <T> Range<T> of(T minimum, T maximum, T resolution) {
		return new Range<>(minimum, maximum, resolution);
	}

	/**
	 * Returns an {@code Range} with the specified values.
	 *
	 * @param <T>
	 *            the class of the value
	 * @param minimum
	 *            The minimum value for the measurement range.
	 * @param maximum
	 *            The maximum value for the measurement range.
	 * @return an {@code MeasurementRange} with the given values
	 */
	public static <T> Range<T> of(T minimum, T maximum) {
		return new Range<>(minimum, maximum);
	}

	/**
	 * Returns the smallest value of the range. The value is the same as that
	 * given as the constructor parameter for the smallest value.
	 * 
	 * @return the minimum value
	 */
	@Override
	public T getMinimum() {
		return min;
	}

	/**
	 * Returns the largest value of the measurement range. The value is the same
	 * as that given as the constructor parameter for the largest value.
	 * 
	 * @return the maximum value
	 */
	@Override
	public T getMaximum() {
		return max;
	}

	/**
	 * Returns the resolution of the measurement range. The value is the same as
	 * that given as the constructor parameter for the largest value.
	 * 
	 * @return resolution of the range, the value is the same as that given as
	 *         the constructor parameter for the resolution
	 */
	public T getResolution() {
		return res;
	}

	/**
	 * Method to easily check if {@link #getMinimum()} is not {@code null}.
	 * 
	 * @return {@code true} if {@link #getMinimum()} is not {@code null} .
	 */
	public boolean hasMinimum() {
		return min != null;
	}

	/**
	 * Method to easily check if {@link #getMaximum()} is not {@code null}.
	 * 
	 * @return {@code true} if {@link #getMaximum()} is not {@code null}.
	 */
	public boolean hasMaximum() {
		return max != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals()
	 */
	@Override
	public boolean equals(Object object) {
		if (object instanceof Range<?>) {
			@SuppressWarnings("unchecked")
			final Range<T> that = (Range<T>) object;
			return this == that
					|| (that.getMinimum() == getMinimum()
							&& that.getMaximum() == getMaximum() && that
							.getResolution() == getResolution());
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return min.hashCode() + max.hashCode()
				+ (res != null ? res.hashCode() : 0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder().append("min= ")
				.append(getMinimum()).append(", max= ").append(getMaximum());
		if (res != null) {
			sb.append(", res= ").append(getResolution());
		}
		return sb.toString();
	}
}
