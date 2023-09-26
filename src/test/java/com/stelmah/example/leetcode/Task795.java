package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task795 {

    @Test
    void example1() {
        // [[1],[2],[3],[]]
        var nums = new int[]{2, 1, 4, 3};
        var left = 2;
        var right = 3;
        Assertions.assertEquals(3, numSubarrayBoundedMax(nums, left, right));
    }

    @Test
    void example2() {
        // [2,9,2,5,6]
        var nums = new int[]{2, 9, 2, 5, 6};
        var left = 2;
        var right = 8;
        Assertions.assertEquals(7, numSubarrayBoundedMax(nums, left, right));
    }

    @Test
    void example3() {
        // [73,55,36,5,55,14,9,7,72,52]
        var nums = new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52};
        var left = 32;
        var right = 69;
        Assertions.assertEquals(22, numSubarrayBoundedMax(nums, left, right));
    }

    @Test
    void example4() {
        var nums = new int[50000];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = 50000 - i;
        }
        var left = 1;
        var right = 50000;
        Assertions.assertEquals(1250025000, numSubarrayBoundedMax(nums, left, right));
    }

    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        long answer = 0;
        var totalCount = 0;
        var smallCount = 0;
        var faced = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                faced = true;
                answer -= sum(smallCount);
                smallCount = 0;
            }
            if (nums[i] < left) {
                smallCount++;
            }
            if (nums[i] <= right) {
                totalCount++;
            } else {
                if (faced) {
                    answer += sum(totalCount);
                    answer -= sum(smallCount);
                }
                faced = false;
                totalCount = 0;
                smallCount = 0;
            }
        }
        return (int) (answer + sum(totalCount) - sum(smallCount));
    }

    int sum(int n) {
        return (n == 0) ? 0 : (int)((long)n * (n + 1) / 2);
    }
}