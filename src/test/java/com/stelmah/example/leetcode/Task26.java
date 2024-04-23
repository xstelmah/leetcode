package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task26 {

    @Test
    void example1() {
        var board = new int[]{1, 1, 1, 2, 2, 3};
        var expected = new int[]{1, 2, 3, 2, 2, 3};

        Assertions.assertEquals(3, removeDuplicates(board));
        Assertions.assertArrayEquals(expected, board);
    }

    @Test
    void example2() {
        var board = new int[]{1, 2, 3, 4, 5, 6};
        var expected = new int[]{1, 2, 3, 4, 5, 6};

        Assertions.assertEquals(6, removeDuplicates(board));
        Assertions.assertArrayEquals(expected, board);
    }

    /** Beats 100% */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 1) {
            return nums.length;
        }
        var len = nums.length;
        int l = 0;
        int r = 1;
        while (r < len) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r++];
            } else {
                r++;
            }
        }
        return l + 1;
    }

}
