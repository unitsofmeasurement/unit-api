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
//
// This source code implements specifications defined by the Java
// Community Process. In order to remain compliant with the specification
// DO NOT add / change / or delete method signatures!
//
package javax.measure;

/**
 * Exception used to indicate a problem while dealing with units of measurement.
 * <p>
 * This exception is used to indicate problems with creating, retrieving and manipulating units of measurement objects.
 *
 * @implSpec This class is intended for use in a single thread. Exception thrown when errors occur during Units of Measurement operations.
 *
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 1.0, Aug 8, 2016
 * @since 1.0
 */
public class MeasurementException extends RuntimeException {

  /**
   * For cross-version compatibility.
   */
  private static final long serialVersionUID = 8959937033300443361L;

  /**
   * Constructs a {@code MeasurementException} with the given message.
   *
   * @param message
   *          the detail message, or {@code null} if none.
   */
  public MeasurementException(final String message) {
    super(message);
  }

  /**
   * Constructs a {@code MeasurementException} with the given cause.
   *
   * @param cause
   *          the cause of this exception, or {@code null} if none.
   */
  public MeasurementException(final Throwable cause) {
    super(cause);
  }

  /**
   * Constructs a {@code MeasurementException} with the given message and cause.
   *
   * @param message
   *          the detail message, or {@code null} if none.
   * @param cause
   *          the cause of this exception, or {@code null} if none.
   *
   */
  public MeasurementException(final String message, final Throwable cause) {
    super(message, cause);
  }

  /**
   * Constructs a {@code MeasurementException} with no given message.
   *
   */
  protected MeasurementException() {
    super();
  }
}
