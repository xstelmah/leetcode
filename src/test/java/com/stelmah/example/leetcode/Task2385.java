package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task2385 {

    @Test
    void example1() {
        Integer[] rootNums = {1, 5, 3, null, 4, 10, 6, 9, 2};
        var root = TreeNode.fromSimplifiedArray(rootNums);
        var start = 3;

        Assertions.assertEquals(4, amountOfTime(root, start));
    }

    public int amountOfTime(TreeNode root, int start) {
        return dfs(root, start)[2];
    }

    public Integer[] dfs(TreeNode node, int start) {
        if (node == null) {
            return new Integer[]{0, null, 0};
        }
        var left = dfs(node.left, start);
        var right = dfs(node.right, start);


        var max = Math.max(left[0], right[0]) + 1;
        if (node.val == start) {
            return new Integer[]{max, max, max - 1};
        }

        if (left[1] != null || right[1] != null) {
            var clear = left;
            var infected = right;
            if (infected[1] == null) {
                infected = left;
                clear = right;
            }
            var tempAnswer = 1 + infected[0] - infected[1] + clear[0];

            return new Integer[]{infected[0] + 1, infected[1], Math.max(infected[2], tempAnswer)};

        } else {
            return new Integer[]{max, null, 0};
        }

    }
}
