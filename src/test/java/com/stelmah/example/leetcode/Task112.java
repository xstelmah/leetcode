package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task112 {

    @Test
    void example1() {
        var tree = new TreeNode(1, new TreeNode(2),  new TreeNode(3));
        var resp = hasPathSum(tree, 5);
        Assertions.assertEquals(false, resp);
    }


    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        var left = root.left != null ? hasPathSum(root.left, targetSum - root.val) : false;
        var right = root.right != null ? hasPathSum(root.right, targetSum - root.val) : false;
        return left || right;
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
