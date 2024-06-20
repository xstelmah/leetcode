package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class Task128 {

    @Test
    void example1() {
        int[] nums = {100, 4, 200, 1, 3, 2};

        Assertions.assertEquals(4, longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        var parents = new HashMap<Integer, Integer>();
        for (var num : nums) {
            var parent = num;
            if (parents.containsKey(num + 1)) {
                parent = findParent(num + 1, parents);
            }
            parents.put(num, parent);
            if (parents.containsKey(num - 1)) {
                parents.put(num - 1, parent);
            }
        }
        var answer = 0;
        for (var entry : parents.entrySet()) {
            answer = Math.max(answer, findParent(entry.getValue(), parents) - entry.getKey() + 1);
        }
        return answer;
    }

    public int findParent(int index, Map<Integer, Integer> parents) {
        var parent = parents.get(index);
        if (parent != index) {
            parent = findParent(parent, parents);
            parents.put(index, parent);
        }
        return parent;
    }

}
