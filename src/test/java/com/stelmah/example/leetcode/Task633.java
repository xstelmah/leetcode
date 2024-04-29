package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task633 {

    @Test
    void example1() {

        var n = 5;
        Assertions.assertEquals(true, judgeSquareSum(n));
    }

    public boolean judgeSquareSum(int c) {
        var csqrt = Math.sqrt(c);
        for (int a = 0; a <= csqrt; a++) {
            var b = c - a * a;
            var bsqrt = (int) Math.sqrt(b);
            if (bsqrt * bsqrt == b) {
                return true;
            }
        }
        return false;
    }
}
