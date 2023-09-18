package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;

class Task632_2 {

    @Test
    void example1() {
        var nums = List.of(List.of(4, 10, 15, 24, 26), List.of(0, 9, 12, 20), List.of(5, 18, 22, 30));
        Assertions.assertArrayEquals(new int[]{20, 24}, smallestRange(nums));
    }

    @Test
    void example2() {
        var nums = List.of(
                List.of(-89, 1, 69, 89, 90, 98),
                List.of(-43, -36, -24, -14, 49, 61, 66, 69),
                List.of(73, 94, 94, 96),
                List.of(11, 13, 76, 79, 90),
                List.of(-40, -20, 1, 9, 12, 12, 14),
                List.of(-91, -31, 0, 21, 25, 26, 28, 29, 29, 30),
                List.of(23, 88, 89),
                List.of(31, 42, 42, 57),
                List.of(-2, 6, 11, 12, 12, 13, 15),
                List.of(-3, 25, 34, 36, 39),
                List.of(-7, 3, 29, 29, 31, 32, 33),
                List.of(4, 11, 14, 15, 15, 18, 19),
                List.of(-34, 9, 12, 19, 19, 19, 19, 20),
                List.of(-26, 4, 47, 53, 64, 64, 64, 64, 64, 65),
                List.of(-51, -25, 36, 38, 50, 54),
                List.of(17, 25, 38, 38, 38, 38, 40),
                List.of(-30, 12, 15, 19, 19, 20, 22),
                List.of(-14, -13, -10, 68, 69, 69, 72, 74, 75),
                List.of(-39, 42, 70, 70, 70, 71, 72, 72, 73),
                List.of(-67, -34, 6, 26, 28, 28, 28, 28, 29, 30, 31)
        );
        Assertions.assertArrayEquals(new int[]{13, 73}, smallestRange(nums));
    }



    public int[] smallestRange(List<List<Integer>> nums) {
        var slideWindow = new PriorityQueue<Triple>(Comparator.comparingInt((Triple triple) -> triple.value).thenComparingInt(triple -> triple.rowIndex));
        int maxRight = nums.get(0).get(0);
        for (int i = 0; i < nums.size(); i++) {
            slideWindow.add(Triple.of(nums.get(i).get(0), i, 0));
            maxRight = Math.max(maxRight, nums.get(i).get(0));
        }

        var result = new int[]{0, 1_000_000};

        while (true) {
            var lowest = slideWindow.peek().value;
            if (maxRight - lowest < result[1] - result[0]) {
                result[0] = lowest;
                result[1] = maxRight;
            }
            var element = slideWindow.poll();
            if (element.columnIndex + 1 == nums.get(element.rowIndex).size()) {
                break;
            }
            slideWindow.add(Triple.of(nums.get(element.rowIndex).get(element.columnIndex + 1), element.rowIndex, element.columnIndex + 1));
            maxRight = Math.max(maxRight, nums.get(element.rowIndex).get(element.columnIndex + 1));
        }
        return result;
    }

    public static class Triple {
        public int value;
        public int rowIndex;
        public int columnIndex;

        public Triple(int value, int rowIndex, int columnIndex) {
            this.value = value;
            this.rowIndex = rowIndex;
            this.columnIndex = columnIndex;
        }

        public static Triple of(int value, int rowIndex, int columnIndex) {
            return new Triple(value, rowIndex, columnIndex);
        }

    }

}
