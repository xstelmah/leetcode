
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1161 {

    @Test
    void example1() {
        Integer[] arr = {1, 7, 0, 7, -8, null, null};
        var node = TreeNode.fromSimplifiedArray(arr);
        Assertions.assertEquals(2, maxLevelSum(node));
    }
    @Test
    void example2() {
        Integer[] arr = {989,null,10250,98693,-89388,null,null,null,-32127};
        var node = TreeNode.fromSimplifiedArray(arr);
        Assertions.assertEquals(2, maxLevelSum(node));
    }

    public int maxLevelSum(TreeNode root) {
        int[] sums = new int[10_001];
        var maxLevel = dfs(root, 1, sums);

        sums[0] = Integer.MIN_VALUE;
        var answer = 0;

        for (int i = 1; i < maxLevel; i++) {
            if (sums[answer] < sums[i]) {
                answer = i;
            }
        }
        return answer;
    }

    public int dfs(TreeNode node, int level, int[] sums) {
        if (node == null) {
            return level;
        }
        var left = dfs(node.left, level + 1, sums);
        var right = dfs(node.right, level + 1, sums);
        sums[level] += node.val;

        return Math.max(left, right);
    }
}
