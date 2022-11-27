/*
 * Units of Measurement API
 * Copyright (c) 2014-2022, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
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

import static org.junit.jupiter.api.Assertions.*;

import javax.measure.IncommensurableException;
import javax.measure.MeasurementError;
import javax.measure.MeasurementException;
import javax.measure.UnconvertibleException;

import org.junit.jupiter.api.Test;

/**
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 2.0
 */
public class ExceptionsTest {

    @SuppressWarnings("serial")
    static class TestException extends MeasurementException {
        TestException() {
            super();
        }
    }
    
    @Test
    public void testMeasurementException() {
        MeasurementException e = assertThrows(MeasurementException.class, () -> {
            throw new TestException();
        });
        assertNull(e.getMessage());
        assertNull(e.getCause());
    }

    @Test
    public void testMeasurementExceptionWithMessage() {
        MeasurementException e = assertThrows(MeasurementException.class, () -> {
            throw new MeasurementException("error");
        });

        assertEquals("error", e.getMessage());
        assertNull(e.getCause());
    }

    @Test
    public void testMeasurementExceptionWithCause() {
        assertThrows(MeasurementException.class, () -> {
            throw new MeasurementException(new IllegalArgumentException());
        });
    }

    @Test
    public void testMeasurementExceptionWithMessageAndCause() {
        Exception cause = new IllegalStateException();
        MeasurementException e = assertThrows(MeasurementException.class, () -> {
            throw new MeasurementException("state error", cause);
        });
        assertEquals("state error", e.getMessage());
        assertEquals(cause, e.getCause());
    }    

    @Test
    public void testMeasurementError() {
        MeasurementError e = assertThrows(MeasurementError.class, () -> {
            throw new MeasurementError();
        });

        assertNull(e.getMessage());
        assertNull(e.getCause());
    }
    
    @Test
    public void testMeasurementErrorWithMessage() {
        MeasurementError e = assertThrows(MeasurementError.class, () -> {
            throw new MeasurementError("error");
        });

        assertEquals("error", e.getMessage());
        assertNull(e.getCause());
    }
    
    @Test
    public void testMeasurementErrorWithCause() {
        MeasurementError e = assertThrows(MeasurementError.class, () -> {
            throw new MeasurementError(new TestException());
        });

        assertNotNull(e.getMessage());
        assertEquals("javax.measure.test.ExceptionsTest$TestException", e.getMessage()); 
        // Throwable stores the toString() of a cause
        assertNotNull(e.getCause());
    }
    
    @Test
    public void testMeasurementErrorWithMessageAndCause() {
        MeasurementError e = assertThrows(MeasurementError.class, () -> {
            throw new MeasurementError("error", new TestException());
        });

        assertNotNull(e.getMessage());
        assertEquals("error", e.getMessage()); 
        assertNotNull(e.getCause());
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

    @Test
    public void testUnconvertibleException() {
        UnconvertibleException e = assertThrows(UnconvertibleException.class, () -> {
            throw new UnconvertibleException("error");
        });
        assertEquals("error", e.getMessage());
        assertNull(e.getCause());
    }

    @Test
    public void testUnconvertibleExceptionWithCause() {
        assertThrows(UnconvertibleException.class, () -> {
            Exception cause = new IllegalArgumentException();
            UnconvertibleException e = new UnconvertibleException(cause);
            assertEquals(cause, e.getCause());
            throw e;
        });
    }

    @Test
    public void testUnconvertibleExceptionWithMessageAndCause() {
        Exception cause = new IllegalStateException();
        UnconvertibleException e = assertThrows(UnconvertibleException.class, () -> {
            throw new UnconvertibleException("state error", cause);
        });
        assertEquals("state error", e.getMessage());
        assertEquals(cause, e.getCause());
    }
}
