package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1808 {
    @Test
    void example1() {
        var primeFactors = 5;
        Assertions.assertEquals(6, maxNiceDivisors(primeFactors));
    }

    @Test
    void example2() {
        var primeFactors = 8;
        Assertions.assertEquals(18, maxNiceDivisors(primeFactors));
    }

    @Test
    void example3() {
        var primeFactors = 100;
        Assertions.assertEquals(703522804, maxNiceDivisors(primeFactors));
    }

    public int maxNiceDivisors(int primeFactors) {
        if (primeFactors <= 4) {
            return primeFactors;
        }
        var answerMultiplier = 1;
        if (primeFactors % 3 == 2) {
            answerMultiplier = 2;
            primeFactors -= 2;
        }
        if (primeFactors % 3 == 1) {
            answerMultiplier = 4;
            primeFactors -= 4;
        }
        var power = primeFactors / 3;
        var modulo = 1_000_000_007;

        return (int) ((calculate(3, power, modulo) * answerMultiplier) % modulo);
    }

    private static long calculate(long base, int power, int modulo) {
        if (power == 1) {
            return base % modulo;
        }
        return (calculate((base * base) % modulo, power / 2, modulo) * (power % 2 == 1 ? base : 1)) % modulo;
    }

}