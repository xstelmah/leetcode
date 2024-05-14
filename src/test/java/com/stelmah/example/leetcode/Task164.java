package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class Task164 {

    @Test
    void example1() {
        int[] nums = {3, 6, 9, 1};
        var expected = 3;
        Assertions.assertEquals(expected, maximumGap(nums));
    }

    @Test
    void example2() {
        int[] nums = {1, 2, 1, 2, 1, 2};
        var expected = 1;
        Assertions.assertEquals(expected, maximumGap(nums));
    }

    @Test
    void example3() {
        int[] nums = {1, 1, 2, 1, 2, 1, 2, 1, 2, 4};
        var expected = 2;
        Assertions.assertEquals(expected, maximumGap(nums));
    }

    @Test
    void example4() {
        int[] nums = {1, 1, 1, 1};
        var expected = 0;
        Assertions.assertEquals(expected, maximumGap(nums));
    }

    @Test
    void example5() {
        int[] nums = {1};
        var expected = 0;
        Assertions.assertEquals(expected, maximumGap(nums));
    }

    @Test
    void example6() {
        int[] nums = {1,100};
        var expected = 99;
        Assertions.assertEquals(expected, maximumGap(nums));
    }

    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int[][] buckets = new int[2][nums.length + 1];
        Arrays.fill(buckets[0], Integer.MAX_VALUE);
        Arrays.fill(buckets[1], Integer.MIN_VALUE);

        var min = Integer.MAX_VALUE;
        var max = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }

        int bucketSize = (int) Math.ceil((max - min + 1.0)  /(nums.length));

        for (var num : nums) {
            var bucket = (num - min) / bucketSize;
            buckets[0][bucket] = Math.min(buckets[0][bucket], num);
            buckets[1][bucket] = Math.max(buckets[1][bucket], num);
        }

        var answer = 0;
        var prev = buckets[0][0];
        for (int i = 0; i < nums.length; i++) {
            if (buckets[0][i] == Integer.MAX_VALUE) {
                continue;
            }
            answer = Math.max(answer, buckets[0][i] - prev);
            prev = buckets[1][i];
        }

        answer = Math.max(answer, max - prev);

        return answer;
    }

}