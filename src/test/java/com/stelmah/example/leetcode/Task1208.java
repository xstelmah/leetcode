package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1208 {

    @Test
    void example1() {
        var s = "abcd";
        var t = "bcdf";
        var maxCost = 3;

        Assertions.assertEquals(3, equalSubstring(s, t, maxCost));
    }

    @Test
    void example2() {
        var s = "abcd";
        var t = "cdef";
        var maxCost = 3;

        Assertions.assertEquals(1, equalSubstring(s, t, maxCost));
    }

    public int equalSubstring(String s, String t, int maxCost) {
        var n = s.length();
        var costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        var l = 0;
        var r = 0;
        var cost = costs[0];
        var answer = 0;
        while (l < n && r < n) {
            if (r < l) {
                r = l;
                cost = costs[l];
            }
            while (r < n - 1 && cost + costs[r + 1] <= maxCost) {
                cost += costs[++r];
            }
            if (cost <= maxCost) {
                answer = Math.max(answer, r - l + 1);
            }
            cost -= costs[l++];
        }
        return answer;
    }

}
