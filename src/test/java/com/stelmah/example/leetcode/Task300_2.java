package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Task300_2 {

    @Test
    void example1() {
        int[] nums = {10,9,2,5,3,7,101,18};

        Assertions.assertEquals(4, lengthOfLIS(nums));
    }


    /**
     * 3ms. 95.07%
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        var count = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[count - 1]) {
                nums[count++] = nums[i];
            } else {
                var l = 0;
                var r = count - 1;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (nums[m] >= nums[i]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                nums[l] = nums[i];
            }
        }
        return count;
    }

}
