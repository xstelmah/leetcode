
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;


class Task1509 {

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
        var arr = nums;
        if (nums.length < 9) {
            Arrays.sort(arr);
        } else {
            arr = new int[8];
            var st1 = new HashSet<Integer>();
            var st2 = new HashSet<Integer>();
            var n = arr.length - 1;
            Arrays.fill(arr, -1);
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < nums.length; j++) {
                    if ((arr[i] == -1 || nums[arr[i]] > nums[j]) && !st1.contains(j)) {
                        arr[i] = j;
                    }
                    if ((arr[n - i] == -1 || nums[arr[n - i]] < nums[j]) && !st2.contains(j)) {
                        arr[n - i] = j;
                    }
                }
                st1.add(arr[i]);
                st2.add(arr[n - i]);
            }
            for (int i = 0; i < arr.length; i++) {
                arr[i] = nums[arr[i]];
            }
        }

        var answer = Integer.MAX_VALUE;
        for (int l = 0, r = arr.length - 4 + l; l <= 3; l++, r++) {
            if (l >= r || r >= arr.length) {
                continue;
            }
            answer = Math.min(answer, arr[r] - arr[l]);
        }

        return answer;
    }
}
