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
package javax.measure.test;

import static org.junit.Assert.*;

import javax.measure.IncommensurableException;
import javax.measure.MeasurementException;
import javax.measure.UnconvertibleException;

import org.junit.Test;

/**
 * @author <a href="mailto:units@catmedia.us">Werner Keil</a>
 * @version 1.1
 */
public class ExceptionsTest {

  @SuppressWarnings("serial")
  static class TestException extends MeasurementException {
    TestException() {
      super();
    }
  }

  @Test(expected = MeasurementException.class)
  public void testMeasurementException() {
    MeasurementException e = new MeasurementException("error");
    assertEquals("error", e.getMessage());
    assertNull(e.getCause());
    throw e;
  }

  @Test(expected = MeasurementException.class)
  public void testMeasurementExceptionWithCause() {
    throw new MeasurementException(new IllegalArgumentException());
  }

  @Test(expected = MeasurementException.class)
  public void testMeasurementExceptionWithMessageAndCause() {
    Exception cause = new IllegalStateException();
    MeasurementException e = new MeasurementException("state error", cause);
    assertEquals("state error", e.getMessage());
    assertEquals(cause, e.getCause());
    throw e;
  }

  @Test(expected = MeasurementException.class)
  public void testDefaultConstructor() {
    MeasurementException e = new TestException();
    assertNull(e.getMessage());
    assertNull(e.getCause());
    throw e;
  }

  @Test
  public void testIncommensurableException() {
    IncommensurableException ie = new IncommensurableException("error");
    assertEquals("error", ie.getMessage());
    assertNull(ie.getCause());
  }

  @Test
  public void testIncommensurableExceptionWithCause() {
    Exception cause = new IllegalArgumentException();
    IncommensurableException ie = new IncommensurableException(cause);
    assertEquals(cause, ie.getCause());
  }

  @Test
  public void testIncommensurableExceptionWithMessageAndCause() {
    Exception cause = new IllegalArgumentException();
    IncommensurableException ie = new IncommensurableException("yet another error", cause);
    assertEquals("yet another error", ie.getMessage());
    assertEquals(cause, ie.getCause());
  }

  @Test(expected = UnconvertibleException.class)
  public void testUnconvertibleException() {
    UnconvertibleException e = new UnconvertibleException("error");
    assertEquals("error", e.getMessage());
    assertNull(e.getCause());
    throw e;
  }

  @Test(expected = UnconvertibleException.class)
  public void testUnconvertibleExceptionWithCause() {
    Exception cause = new IllegalArgumentException();
    UnconvertibleException e = new UnconvertibleException(cause);
    assertEquals(cause, e.getCause());
    throw e;
  }

  @Test(expected = UnconvertibleException.class)
  public void testUnconvertibleExceptionWithMessageAndCause() {
    Exception cause = new IllegalStateException();
    UnconvertibleException e = new UnconvertibleException("state error", cause);
    assertEquals("state error", e.getMessage());
    assertEquals(cause, e.getCause());
    throw e;
  }
}
