
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task75_2 {


    @Test
    void example1() {
        int[] nums = {2,0,2,1,1,0};
        int[] expected = {0,0,1,1,2,2};
        sortColors(nums);
        Assertions.assertArrayEquals(expected, nums);
    }

    // Dutch National Flag problem
    public void sortColors(int[] nums) {
        var l = 0;
        var m = 0;
        var r = nums.length -1;

        while (m <= r) {
            if (nums[m] == 1) {
                m++;
            } else if (nums[m] == 0) {
                swap(nums, l, m);
                l++;
                m++;
            } else {
                swap(nums, m, r);
                r--;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        var temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
