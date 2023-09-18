package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task1448 {

    @Test
    void example1() {
        //  [3,1,4,3,null,1,5]
        TreeNode root = TreeNode.fromSimplifiedArray(new Integer[]{3, 1, 4, 3, null, 1, 5});

        Assertions.assertEquals(4, goodNodes(root));
    }

    @Test
    void example2() {
        // [2,null,4,10,8,null,null,4]
        TreeNode root = TreeNode.fromSimplifiedArray(new Integer[]{2, null, 4, 10, 8, null, null, 4});

        Assertions.assertEquals(4, goodNodes(root));
    }


    @Test
    void example3() {
        // [9,null,3,6]
        TreeNode root = TreeNode.fromSimplifiedArray(new Integer[]{9, null, 3, 6});

        Assertions.assertEquals(1, goodNodes(root));
    }

    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }

    public int goodNodes(TreeNode root, int maxVal) {
        if (root == null) {
            return 0;
        }
        return (root.val >= maxVal ? 1 : 0) + goodNodes(root.left, Math.max(maxVal, root.val)) + goodNodes(root.right, Math.max(maxVal, root.val));
    }

}
