package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1753 {

    @Test
    void example1() {
        Assertions.assertEquals(18, maximumScore(12,12,12));
    }
    @Test
    void example2() {
        Assertions.assertEquals(1, maximumScore(1,1,1));
    }


    public int maximumScore(int a, int b, int c) {
        var a1 = Math.min(Math.min(a, b), c);
        var c1 = Math.max(Math.max(a, b), c);
        var b1 = a + b + c - a1 - c1;

        if (a1 + b1 <= c1) {
            return a1 + b1;
        }
        return (a1 + b1 + c1) /2;
    }

}
