package com.stelmah.example.leetcode.util;

import org.junit.jupiter.api.Assertions;

public class AssertionUtils {

    public static void assertMatrixEquals(Object[][] expected, Object[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(boolean[][] expected, boolean[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(byte[][] expected, byte[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(char[][] expected, char[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(short[][] expected, short[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(int[][] expected, int[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(float[][] expected, float[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

    public static void assertMatrixEquals(long[][] expected, long[][] actual) {
        if (expected != actual) {
            Assertions.assertNotNull(expected);
            Assertions.assertNotNull(actual);
            Assertions.assertEquals(expected.length, actual.length);
            for (int i = 0; i < expected.length; i++) {
                Assertions.assertArrayEquals(expected[i], actual[i]);
            }
        }
    }

}
