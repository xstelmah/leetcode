package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task124 {

    @Test
    void example1() {
        var tree = new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        var resp = maxPathSum(tree);
        Assertions.assertEquals(42, resp);
    }

    @Test
    void example2() {
        var tree = new TreeNode(2, null,  new TreeNode(-10, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7))));
        var resp = maxPathSum(tree);
        Assertions.assertEquals(43, resp);
    }

    public int maxPathSum(TreeNode root) {
        var resp = maxPathSum2(root);
        return Math.max(resp[0], resp[1]);
    }

    public int[] maxPathSum2(TreeNode root) {
        var left = root.left != null ? maxPathSum2(root.left) : new int[]{-100_000_000, -100_000_000};
        var right = root.right != null ? maxPathSum2(root.right) : new int[]{-100_000_000, -100_000_000};
        var current = root.val;

        var ans1 = current;
        var ans2 = current + left[0];
        var ans3 = current + right[0];
        var ans4 = current + left[0] + right[0];

        var backMax = Math.max(Math.max(ans1, ans2), ans3);

        var localMax = Math.max(backMax, ans4);
        var globalMax = Math.max(Math.max(left[1], right[1]), localMax);

        return new int[]{backMax, globalMax};
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
