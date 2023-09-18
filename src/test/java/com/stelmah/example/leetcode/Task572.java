package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;

class Task572 {

	@Test
	void example1() {

	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (root.val == subRoot.val && isEqual(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
	}

	public boolean isEqual(TreeNode root, TreeNode subRoot) {
		if (root == null && subRoot == null) {
			return true;
		}
		if ((root == null && subRoot != null) || (root != null && subRoot == null)) {
			return false;
		}
		if (root.val != subRoot.val) {
			return false;
		}
		if ((root.left == null && subRoot.left != null) || (root.left != null && subRoot.left == null)) {
			return false;
		}
		if ((root.right == null && subRoot.right != null) || (root.right != null && subRoot.right == null)) {
			return false;
		}
		return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
	}

	public class TreeNode {
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
