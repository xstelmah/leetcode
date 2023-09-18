package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task687 {

    @Test
    void example1() {
        // tree in array [5,4,5,1,1,null,5]
        var treeNode = new TreeNode(5,
                new TreeNode(4, new TreeNode(1), new TreeNode(1)),
                new TreeNode(5, null, new TreeNode(5)));
        var response = longestUnivaluePath(treeNode);
        Assertions.assertEquals(2, response);
    }

    private static final int NOT_REACHABLE_NUMBER = -10_000;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return longestUnivaluePath(root, NOT_REACHABLE_NUMBER, false);
    }

    public int longestUnivaluePath(TreeNode root, int parentNumber, boolean ignore) {
        if (root == null) {
            return 0;
        }
        var result1 = 0;
        if (root.val == parentNumber) {
            result1 = 1 + Math.max(longestUnivaluePath(root.left, parentNumber, ignore), longestUnivaluePath(root.right, parentNumber, ignore));
        }
        var result3 = 0;
        if (!ignore) {
            result3 = longestUnivaluePath(root.left, root.val, true) + longestUnivaluePath(root.right, root.val, true);
        }
        var result2 = Math.max(longestUnivaluePath(root.left, NOT_REACHABLE_NUMBER, ignore), longestUnivaluePath(root.right, NOT_REACHABLE_NUMBER, ignore));

        return Math.max(Math.max(result1, result2), result3);
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
