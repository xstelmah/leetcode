package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Random;

class Task528 {


    @Test
    void example1() {

        var solution = new Solution(new int[]{3, 14, 1, 7});
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
        System.out.println(solution.pickIndex());
    }


    public static class Solution {

        private int[] w;
        private Random random = new Random();

        public Solution(int[] w) {
            this.w = new int[w.length];
            this.w[0] = w[0];
            for (int i = 1; i < w.length; i++) {
                this.w[i] = this.w[i - 1] + w[i];
            }
        }

        public int pickIndex() {
            var rand = random.nextInt(w[w.length - 1]) + 1;
            return binarySearch(rand);
        }

        private int binarySearch(int num) {
            var l = 0;
            var r = this.w.length - 1;
            while (r - l > 1) {
                var m = (l + r) / 2;
                if (w[m] >= num) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            return w[l] >= num ? l : r;
        }
    }
}
