/**
 * Unit-API - Units of Measurement API for Java
 * Copyright (c) 2014 Jean-Marie Dautelle, Werner Keil, V2COM
 * All rights reserved.
 *
 * See LICENSE.txt for details.
 */
package javax.measure.test.format;

/**
 * A static helper class, checking e.g. if some tests require optional console
 * output XXX this could have options for using a logging framework eventually
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
