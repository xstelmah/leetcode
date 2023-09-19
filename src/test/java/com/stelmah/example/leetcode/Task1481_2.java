package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Task1481_2 {

    @Test
    void example1() {
        var arr = new int[]{4, 3, 1, 1, 3, 3, 2};
        var k = 3;
        Assertions.assertEquals(2, findLeastNumOfUniqueInts(arr, k));
    }

    @Test
    void example2() {
        var arr = new int[]{5, 5, 4};
        var k = 1;
        Assertions.assertEquals(1, findLeastNumOfUniqueInts(arr, k));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Arrays.sort(arr);
        var element = arr[0];
        var duplicatesCount = new int[arr.length + 1];
        var count = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                duplicatesCount[count]++;
                break;
            }
            if (element == arr[i + 1]) {
                count++;
            } else {
                duplicatesCount[count]++;
                count = 1;
                element = arr[i + 1];
            }
        }
        var answer = 0;
        for (int i = 1; i < duplicatesCount.length; i++) {
            if (duplicatesCount[i] == 0) {
                continue;
            }
            var maxToDeduct = Math.min(i * duplicatesCount[i], k);
            k -= maxToDeduct;
            duplicatesCount[i] -= maxToDeduct / i;
            if (k == 0) {
                answer += duplicatesCount[i];
            }
        }

        return answer;
    }
}