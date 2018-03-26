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
package javax.measure.format;

import java.io.IOException;

import javax.measure.Unit;

/**
 * Formats instances of {@link Unit} to a {@link String} or {@link Appendable} and parses a {@link CharSequence} to a {@link Unit}.
 *
 * <h1><a name="synchronization">Synchronization</a></h1>
 * <p>
 * Instances of this class are not required to be thread-safe. It is recommended to use separate format instances for each thread. If multiple threads
 * access a format concurrently, it must be synchronized externally.
 * <p>
 *
 * @author <a href="mailto:jean-marie@dautelle.com">Jean-Marie Dautelle</a>
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 *
 * @version 1.1, January 26, 2018
 * @since 1.0
 *
 * @see Unit
 */
public interface UnitFormat {
  /**
   * Formats the specified {@link Unit}.
   *
   * @param unit
   *          the {@link Unit} to format, not {@code null}
   * @param appendable
   *          the appendable destination.
   * @return the appendable destination passed in with formatted text appended.
   * @throws IOException
   *           if an error occurs while writing to the destination.
   */
  Appendable format(Unit<?> unit, Appendable appendable) throws IOException;

  /**
   * Formats the specified {@link Unit}.
   *
   * @param unit
   *          the {@link Unit} to format, not {@code null}
   * @return the string representation using the settings of this {@link UnitFormat}.
   */
  String format(Unit<?> unit);

  /**
   * Attaches a system-wide label to the specified unit.
   * <p>
   * If the specified label is already associated to a unit the previous association can be discarded or ignored. Depending on the {@link UnitFormat}
   * implementation, this call may be ignored if the particular unit already has a label.
   * </p>
   * If a {@link UnitFormat} implementation is explicitly <b>immutable</b>, similar to e.g. the result of <tt>Collections.unmodifiableList()</tt>,
   * then an {@linkplain UnsupportedOperationException} may be thrown upon this call.
   * <p>
   * Since <tt>UnitFormat</tt> implementations often apply the Singleton pattern, <b>system-wide</b> means, the label applies to every instance of
   * <tt>UnitFormatA</tt> implementing <tt>UnitFormat</tt> in this case, but not every instance of <tt>UnitFormatB</tt> or <tt>UnitFormatC</tt> both
   * also implementing <tt>UnitFormat</tt>. If a <tt>UnitFormat</tt> #isLocaleSensitive() it is up to the implementation, whether the label is
   * ignored, applied in a local-neutral manner (in addition to its local-sensitive information) or locale-specific.
   * </p>
   *
   * @param unit
   *          the unit being labeled.
   * @param label
   *          the new label for this unit.
   * @throws IllegalArgumentException
   *           if the label is not a valid identifier. This may include characters not supported by a particular {@link UnitFormat} implementation
   *           (e.g. only <b>ASCII</b> characters for certain devices)
   * @throws UnsupportedOperationException
   *           if the <tt>label</tt> operation is not supported by this {@link UnitFormat}
   */
  void label(Unit<?> unit, String label);

  /**
   * Returns <code>true</code> if this {@link UnitFormat} depends on a <code>Locale</code> to perform its tasks.
   * <p>
   * In environments that do not support a <code>Locale</code>, e.g. Java ME, this usually returns <code>false</code>.
   * </p>
   *
   * @return Whether this format depends on the locale.
   */
  default boolean isLocaleSensitive() {
      return false;
  }

  /**
   * Parses the text into an instance of {@link Unit}.
   * <p>
   * The parse must complete normally and parse the entire text. If the parse completes without reading the entire length of the text, an exception is
   * thrown. If any other problem occurs during parsing, an exception is thrown.
   * <p>
   *
   * @param csq
   *          the {@code CharSequence} to parse.
   * @return the unit parsed from the specified character sequence.
   * @throws ParserException
   *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
   * @throws UnsupportedOperationException
   *           if the {@link UnitFormat} is unable to parse.
   */
  Unit<?> parse(CharSequence csq) throws ParserException;
}
