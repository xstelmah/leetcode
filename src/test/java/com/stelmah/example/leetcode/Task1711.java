
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1711 {


    @Test
    void example1() {
        int[] deliciousness = {1, 3, 5, 7, 9};

        Assertions.assertEquals(4, countPairs(deliciousness));
    }

    @Test
    void example2() {
        int[] deliciousness = {1, 1, 1, 3, 3, 3, 7};

        Assertions.assertEquals(15, countPairs(deliciousness));
    }

    @Test
    void example3() {
        int[] deliciousness = {149, 107, 1, 63, 0, 1, 6867, 1325, 5611, 2581, 39, 89, 46, 18, 12, 20, 22, 234};

        Assertions.assertEquals(12, countPairs(deliciousness));
    }

    int modulo = 1_000_000_007;

    public int countPairs(int[] deliciousness) {
        int max = 1 << 21;
        int[] powers = new int[22];
        powers[0] = 1;
        for (int i = 1; i < powers.length; i++) {
            powers[i] = powers[i - 1] * 2;
        }
        int[] arr = new int[max + 1];
        var answer = 0;
        for (int i = 0; i < deliciousness.length; i++) {
            for (int j = 0; j < powers.length; j++) {
                var num = powers[j] - deliciousness[i];
                if (num >= 0 && num <= max) {
                    answer = (answer + arr[num]) % modulo;
                }
            }

            arr[deliciousness[i]] += 1;
        }
        return answer;
    }
}
