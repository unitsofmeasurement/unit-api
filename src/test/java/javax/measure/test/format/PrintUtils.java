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

/**
 * A static helper class, checking e.g. if some tests require optional console output XXX this could have options for using a logging framework
 * eventually
 *
 * @author Werner Keil
 */
public final class PrintUtils {
  private static final String CONSOLE_OUTPUT = "consoleOutput";

  private PrintUtils() {
  }

  public static boolean isConsoleOutput() {
    return ("true".equals(System.getProperty(CONSOLE_OUTPUT)));
  }

  public static void print(String message) {
    if (isConsoleOutput()) {
      System.out.print(message);
    }
  }

  public static void println(String message) {
    if (isConsoleOutput()) {
      System.out.println(message);
    }
  }

  public static void print(Object object) {
    print(String.valueOf(object));
  }

  public static void println(Object object) {
    println(String.valueOf(object));
  }

  /**
   * This is a Fantom-style convenience method for console output
   */
  public static void echo(Object obj) {
    println(obj);
  }

  /**
   * This is a Fantom-style convenience method for console output
   */
  public static void echo(String str) {
    println(str);
  }
}
