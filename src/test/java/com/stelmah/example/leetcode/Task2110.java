
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task2110 {


    @Test
    void example1() {
        int[] prices = {3, 2, 1, 4};
        Assertions.assertEquals(7, getDescentPeriods(prices));
    }
    @Test
    void example2() {
        int[] prices = {3, 2, 1, 0};
        Assertions.assertEquals(10, getDescentPeriods(prices));
    }

    public long getDescentPeriods(int[] prices) {
        long cnt = 1;
        long answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                cnt++;
            } else {
                answer += cnt * (cnt + 1) / 2;
                cnt = 1;
            }
        }

        answer += cnt * (cnt + 1) / 2;
        return answer;
    }
}
