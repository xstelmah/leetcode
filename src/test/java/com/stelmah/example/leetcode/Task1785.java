
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1785 {

    @Test
    void example1() {
        int[] nums = {1, -1, 1};
        int limit = 3;
        int goal = -4;
        Assertions.assertEquals(2, minElements(nums, limit, goal));
    }

    public int minElements(int[] nums, int limit, int goal) {
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum +=nums[i];
        }
        long expected = Math.abs(goal - sum);

        return (int)((expected + limit - 1) / limit);
    }

}
