package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task1846 {
    @Test
    void example1() {
        var nums = new int[]{100, 1, 1000};
        Assertions.assertEquals(3, maximumElementAfterDecrementingAndRearranging(nums));
    }


    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 1) {
            arr[0] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Math.min(arr[i - 1] + 1, arr[i]);
        }

        return arr[arr.length - 1];
    }

}