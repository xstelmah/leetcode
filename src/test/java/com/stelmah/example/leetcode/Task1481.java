package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Task1481 {

    @Test
    void example1() {
        var arr = new int[]{4, 3, 1, 1, 3, 3, 2};
        var k = 3;
        Assertions.assertEquals(2, findLeastNumOfUniqueInts(arr, k));
    }

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        var list = new ArrayList<>(map.values());
        list.sort(Comparator.comparingInt(p -> p));

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) <= k) {
                k -= list.get(i);
                continue;
            }
            return list.size() - i;
        }

        return 0;
    }
}