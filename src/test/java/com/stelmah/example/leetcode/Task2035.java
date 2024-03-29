
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;


class Task2035 {

    @Test
    void example1() {
        int[] nums = {3, 9, 7, 3};
        Assertions.assertEquals(2, minimumDifference(nums));
    }

    @Test
    void example2() {
        int[] nums = {3, 3, 7, 9};
        Assertions.assertEquals(2, minimumDifference(nums));
    }

    @Test
    void example3() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
        Assertions.assertEquals(1, minimumDifference(nums));
    }

    @Test
    void example4() {
        int[] nums = {-36, 36};
        Assertions.assertEquals(72, minimumDifference(nums));
    }

    @Test
    void example5() {
        int[] nums = {2, -1, 0, 4, -2, -9};
        Assertions.assertEquals(0, minimumDifference(nums));
    }

    @Test
    void example6() {
        int[] nums = {-65941, -93008, -16458, -95021, 268107, 60734, -35654, -38922, -757, 18532};
        Assertions.assertEquals(6254, minimumDifference(nums));
    }


    /**
     * my first solution of this task... to complex... to slow...
     **/
    public int minimumDifference(int[] nums) {
        var currentState = new HashMap<Integer, Integer>();
        currentState.put(nums[0], 1);
        var sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        // key = number of numbers 0-15, value = possible sums
        TreeSet<Integer>[] sumArr1 = new TreeSet[nums.length / 2 + 1];
        TreeSet<Integer>[] sumArr2 = new TreeSet[nums.length / 2 + 1];
        for (int i = 0; i < sumArr1.length; i++) {
            sumArr1[i] = new TreeSet<>();
            sumArr2[i] = new TreeSet<>();
        }

        // key = sum, value = number of numbers
        var stateArr = new ArrayList<Statistic>();

        for (int i = 0; i < nums.length / 2; i++) {
            var newState = new ArrayList<Statistic>(stateArr);
            for (var state : stateArr) {
                var statistic = new Statistic(state.sum + nums[i], state.cnt + 1);
                newState.add(statistic);
                sumArr1[statistic.cnt].add(statistic.sum);
            }
            newState.add(new Statistic(nums[i], 1));
            sumArr1[1].add(nums[i]);
            stateArr = newState;
        }

        stateArr = new ArrayList<>();
        for (int i = nums.length / 2; i < nums.length; i++) {
            var newState = new ArrayList<Statistic>(stateArr);
            for (var state : stateArr) {
                var statistic = new Statistic(state.sum + nums[i], state.cnt + 1);
                newState.add(statistic);
                sumArr2[statistic.cnt].add(statistic.sum);
            }
            newState.add(new Statistic(nums[i], 1));
            sumArr2[1].add(nums[i]);
            stateArr = newState;
        }

        var answer = Integer.MAX_VALUE;

        for (int size1 = 1; size1 < sumArr1.length; size1++) {
            for (var part1 : sumArr1[size1]) {
                if (size1 == nums.length / 2) {
                    answer = Math.min(answer, Math.abs(sumArr1[size1].first() - sumArr2[size1].first()));
                    continue;
                }
                for (var k = -1; k <= 1; k += 2) {
                    var expectedPart2 = (sum + k) / 2 - part1;

                    var close1 = sumArr2[nums.length / 2 - size1].floor(expectedPart2);
                    var close2 = sumArr2[nums.length / 2 - size1].ceiling(expectedPart2);
                    if (close1 != null) {
                        answer = Math.min(answer, Math.abs(sum - (part1 + close1) * 2));
                    }
                    if (close2 != null) {
                        answer = Math.min(answer, Math.abs(sum - (part1 + close2) * 2));
                    }
                }
            }
        }
        return answer;
    }

    public static class Statistic {
        public int sum;
        public int cnt;

        public Statistic(int sum, int cnt) {
            this.sum = sum;
            this.cnt = cnt;
        }
    }
}
