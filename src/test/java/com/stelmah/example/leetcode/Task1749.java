package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1749 {

    @Test
    void example1() {
        int[] nums = {1, -3, 2, 3, -4};
        Assertions.assertEquals(5, maxAbsoluteSum(nums));
    }

    @Test
    void example2() {
        int[] nums = {2, -5, 1, -4, 3, -2};
        Assertions.assertEquals(8, maxAbsoluteSum(nums));
    }

    public int maxAbsoluteSum(int[] nums) {
        int pos = 0;
        int neg = 0;
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                neg += nums[i];
                if (pos > -nums[i]) {
                    pos += nums[i];
                } else {
                    pos = 0;
                }
            }
            if (nums[i] > 0) {
                pos += nums[i];
                if (-neg > nums[i]) {
                    neg += nums[i];
                } else {
                    neg = 0;
                }
            }
            answer = Math.max(answer, Math.max(pos, -neg));
        }
        return answer;
    }

}
