package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task339 {

    @Test
    void example1() {

        var n = 16;
        var result = countBits(n);
        for (var r : result) {
            System.out.println(r + " ");
        }
        Assertions.assertArrayEquals(new int[] {0,1,1,2,1,2,2,3,1,2,2,3,2,3,3,4,1}, result);
    }

    @Test
    void example2() {
        var n = 0;
        var result = countBits(n);
        for (var r : result) {
            System.out.println(r + " ");
        }
    }

    public int[] countBits(int n) {
        var result = new int[n + 1];
        for (int i = 1; i <= n; i++) {

            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
