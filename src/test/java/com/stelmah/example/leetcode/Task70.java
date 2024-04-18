package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task70 {
    @Test
    void example1() {
        var n = 3;
        Assertions.assertEquals(3, climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }
        var step1 = 1;
        var step2 = 1;
        var sum = 0;
        for (int cur = 2; cur <= n; cur++) {
            sum = step1 + step2;
            step1 = step2;
            step2 = sum;
        }
        return sum;
    }

}
