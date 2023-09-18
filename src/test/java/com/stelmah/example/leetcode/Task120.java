package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task120 {

    @Test
    void example1() {
        // triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> treeNode = List.of(new ArrayList<>(List.of(2)), new ArrayList<>(List.of(3, 4)), new ArrayList<>(List.of(6, 5, 7)), new ArrayList<>(List.of(4, 1, 8, 3)));
        Assertions.assertEquals(11, minimumTotal(treeNode));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

}
