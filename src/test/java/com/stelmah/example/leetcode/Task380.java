package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

class Task380 {

    @Test
    void example1() {
        RandomizedSet rs = new RandomizedSet();
        rs.insert(0);
        rs.insert(1);
        rs.remove(0);
        rs.insert(2);
        rs.remove(1);
        var r = rs.getRandom();
        Assertions.assertEquals(2, r);
    }

    static class RandomizedSet {

        int[] arr = new int[200_000];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Random rand = new Random();

        public RandomizedSet() {

        }

        public boolean insert(int val) {
            if (map.containsKey(val)) {
                return false;
            }
            arr[map.size()] = val;
            map.put(val, map.size());
            return true;
        }

        public boolean remove(int val) {
            if (!map.containsKey(val)) {
                return false;
            }
            var newVal = arr[map.size() - 1];
            var pos = map.get(val);
            arr[pos] = newVal;
            map.remove(val);
            if (newVal != val) {
                map.put(newVal, pos);
            }
            return true;
        }

        public int getRandom() {
            var index = rand.nextInt(map.size());
            return arr[index];
        }
    }
}
