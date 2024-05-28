package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class Task300 {

    @Test
    void example1() {
        int[] nums = {10,9,2,5,3,7,101,18};

        Assertions.assertEquals(4, lengthOfLIS(nums));
    }

    /**
     * 6ms. 88.03%
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        var state = new ArrayList<Integer>();

        state.add(nums[0]);
        for (int i = 1; i < n; i++) {
            if (nums[i] > state.get(state.size() - 1)) {
                state.add(nums[i]);
            } else {
                var l = 0;
                var r = state.size() - 1;
                while (l < r) {
                    int m = (l + r) / 2;
                    if (state.get(m) >= nums[i]) {
                        r = m;
                    } else {
                        l = m + 1;
                    }
                }
                state.set(l, nums[i]);
            }
        }
        return state.size();
    }

}
