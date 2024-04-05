
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1680 {


    @Test
    void example1() {
        int n = 1;

        Assertions.assertEquals(1, concatenatedBinary(1));
    }

    @Test
    void example2() {
        int n = 3;

        Assertions.assertEquals(27, concatenatedBinary(n));
    }

    @Test
    void example3() {
        int n = 12;

        Assertions.assertEquals(505379714, concatenatedBinary(n));
    }
    @Test
    void example4() {
        int n = 4;

        Assertions.assertEquals(220, concatenatedBinary(n));
    }

    int modulo = 1_000_000_007;

    public int concatenatedBinary(int n) {
        int bitsUsed = 1;
        int bitsBorder = 2;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (i >= bitsBorder) {
                bitsBorder *= 2;
                bitsUsed += 1;
            }
            for (int j = bitsUsed - 1; j >= 0; j--) {
                answer = ((answer << 1) + (i >>> j & 1)) % modulo;
            }
        }
        return answer;
    }
}
