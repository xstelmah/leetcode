package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task198 {

    @Test
    void example1() {
        int[] nums = {1, 2, 3, 1};
        Assertions.assertEquals(4, rob(nums));
    }

    public int rob(int[] nums) {
        var n = nums.length;
        var dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) {
            return dp[0];
        }
        dp[1] = nums[1];
        if (n == 2) {
            return Math.max(dp[0], dp[1]);
        }
        dp[2] = nums[0] + nums[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3]) + nums[i];
        }

        return Math.max(dp[n - 1], dp[n - 2]);
    }
}
