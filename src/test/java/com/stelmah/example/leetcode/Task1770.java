package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1770 {

    @Test
    void example1() {
        int[] nums = {1, 2, 3};
        int[] multipliers = {3, 2, 1};
        Assertions.assertEquals(14, maximumScore(nums, multipliers));
    }

    @Test
    void example2() {
        int[] nums = {-5, -3, -3, -2, 7, 1};
        int[] multipliers = {-10, -5, 3, 4, 6};
        Assertions.assertEquals(102, maximumScore(nums, multipliers));
    }

    public int maximumScore(int[] nums, int[] multipliers) {
        var arr = new int[multipliers.length * 2];
        for (int i = 0; i < multipliers.length; i++) {
            arr[i] = nums[i];
            arr[arr.length - 1 - i] = nums[nums.length - 1 - i];
        }
        var answer = Integer.MIN_VALUE;
        var dp = new int[arr.length][arr.length];
        for (int size = arr.length - 1; size >= multipliers.length; size--) {
            for (int left = 0, right = left + size - 1; right < arr.length; left++, right++) {
                if (left == 0 && right == arr.length - 1) {
                    continue;
                }
                Integer leftVal = null;
                Integer rightVal = null;
                if (left != 0) {
                    leftVal = dp[left - 1][right] + arr[left - 1] * multipliers[arr.length - size - 1];
                }
                if (right != arr.length - 1) {
                    rightVal = dp[left][right + 1] + arr[right + 1] * multipliers[arr.length - size - 1];
                }

                if (leftVal != null && rightVal != null) {
                    dp[left][right] = Math.max(leftVal, rightVal);
                } else if (leftVal != null) {
                    dp[left][right] = leftVal;
                } else {
                    dp[left][right] = rightVal;
                }

                if (size == multipliers.length && answer < dp[left][right]) {
                    answer = dp[left][right];
                }
            }

        }
        return answer;
    }

}
