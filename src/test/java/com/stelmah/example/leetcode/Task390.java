package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task390 {

    @Test
    void example1() {
        var n = 9;
        Assertions.assertEquals(6, lastRemaining(n));
    }

    public int lastRemaining(int n) {
        return asc(n);
    }

    public int asc(int n) {
        if (n < 3) {
            return n;
        }
        return 2 * desc(n / 2);
    }

    public int desc(int n) {
        if (n < 3) {
            return 1;
        }
        return 2 * asc(n / 2) - (n % 2 == 1 ? 0 : 1);
    }

}
