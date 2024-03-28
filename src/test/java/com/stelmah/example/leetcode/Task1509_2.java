
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1509_2 {

    @Test
    void example1() {
        int[] nums = {1, 3, 7, 4, 2, 5, 9, 6};
        Assertions.assertEquals(4, minDifference(nums));
    }

    @Test
    void example2() {
        int[] nums = {1, 3, 7, 4, 5};
        Assertions.assertEquals(1, minDifference(nums));
    }

    @Test
    void example3() {
        int[] nums = {1, 3, 7, 4, 2, 5, 9, 6, 8};
        Assertions.assertEquals(5, minDifference(nums));
    }


    public int minDifference(int[] nums) {
        if (nums.length < 5) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            findMinAndMoveToStart(nums, i);
            findMaxAndMoveToEnd(nums, nums.length - 1 - i);
        }

        var answer = Integer.MAX_VALUE;
        for (int l = 0, r = nums.length - 4; r <nums.length ; l++, r++) {
            answer = Math.min(answer, nums[r] - nums[l]);
        }
        return answer;
    }

    public void findMinAndMoveToStart(int[] nums, int start) {
        int minPos = start;
        for (int i = start + 1; i < nums.length; i++) {
            if (nums[i] < nums[minPos]) {
                minPos = i;
            }
        }
        var swap = nums[start];
        nums[start] = nums[minPos];
        nums[minPos] = swap;
    }

    public void findMaxAndMoveToEnd(int[] nums, int end) {
        int maxPos = end;
        for (int i = end; i >= 0; i--) {
            if (nums[i] > nums[maxPos]) {
                maxPos = i;
            }
        }
        var swap = nums[maxPos];
        nums[maxPos] = nums[end];
        nums[end] = swap;
    }


}
