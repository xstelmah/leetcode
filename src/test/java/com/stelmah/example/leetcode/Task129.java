package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task129 {

    @Test
    void example1() {
        // tree in array [4,9,0,5,1]
        var treeNode = new TreeNode(4,
                new TreeNode(9, new TreeNode(5), new TreeNode(1)),
                new TreeNode(0));
        var response = sumNumbers(treeNode);
        Assertions.assertEquals(1026, response);

    }

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int current) {
        if (root.left == null && root.right == null) {
            return current * 10 + root.val;
        }
        var result = 0;
        if (root.left != null) {
            result += sumNumbers(root.left, current * 10 + root.val);
        }
        if (root.right != null) {
            result += sumNumbers(root.right, current * 10 + root.val);
        }
        return result;

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
