package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task80 {

    @Test
    void example1() {
        var board = new int[]{1, 1, 1, 2, 2, 3};
        var expected = new int[]{1, 1, 2, 2, 3, 3};

        Assertions.assertEquals(5, removeDuplicates(board));
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
        if (nums.length < 3) {
            return nums.length;
        }
        int l = 1;
        int r = 2;
        while (r < nums.length) {
            if (nums[l] != nums[r]) {
                nums[++l] = nums[r++];
            } else if (nums[l] == nums[l - 1]) {
                r++;
            } else {
                nums[++l] = nums[r++];
            }
        }
        return l + 1;
    }

}
