package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1026 {

    @Test
    void example1() {
        Integer[] arr = {8, 3, 10, 1, 6, null, 14, null, null, 4, 7, 13};
        var root = TreeNode.fromSimplifiedArray(arr);
        Assertions.assertEquals(7, maxAncestorDiff(root));
    }

    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    public int dfs(TreeNode node, int min, int max) {
        if (node == null) {
            return 0;
        }
        var temp = Math.max(Math.abs(node.val - min), Math.abs(node.val - max));

        return Math.max(temp, Math.max(
                dfs(node.left, Math.min(min, node.val), Math.max(max, node.val)),
                dfs(node.right, Math.min(min, node.val), Math.max(max, node.val))
        ));
    }

}
