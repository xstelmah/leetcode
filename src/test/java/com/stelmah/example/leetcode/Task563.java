package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

class Task563 {

	@Test
	void example1() {
		var treeNode = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null));
		Assertions.assertEquals(1, findTilt(treeNode));
	}

	@Test
	void example2() {
		// [4,2,9,3,5,null,7]
		var treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(5)),
				new TreeNode(9, null, new TreeNode(7)));
		Assertions.assertEquals(15, findTilt(treeNode));
	}

	public int findTilt3(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return root.val + findTilt3(root.left) + findTilt3(root.right);
	}

	public int findTilt(TreeNode root) {
	 	findTilt2(root);
		return findTilt3(root);
	}

	public int findTilt2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		var left = findTilt2(root.left);
		var right = findTilt2(root.right);
		var val = root.val;
		root.val = Math.abs(left - right);
		return val + left + right;
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