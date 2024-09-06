
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class Task105 {

    @Test
    void example1() {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        var tree = buildTree(preorder, inorder);
        Assertions.assertNotNull(tree);

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        var inorderMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(new int[]{0}, 0, preorder.length - 1, preorder, inorder, inorderMap);
    }

    public TreeNode buildTree(int[] rootPos, int left, int right, int[] preorder, int[] inorder, Map<Integer, Integer> inorderMap) {
        if (left < 0 || left >= preorder.length || right < 0 || right >= preorder.length || rootPos[0] >= preorder.length || left > right) {
            return null;
        }
        var root = preorder[rootPos[0]++];
        var inorderPos = inorderMap.get(root);

        var leftNode = buildTree(rootPos, left, inorderPos - 1, preorder, inorder, inorderMap);
        var rightNode = buildTree(rootPos, inorderPos + 1, right,preorder, inorder,inorderMap);
        return new TreeNode(root, leftNode, rightNode);
    }
}
