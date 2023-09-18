package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Task117 {

	@Test
	void example1() {
		// root = [1,2,3,4,5,null,7]
		var isConnected = new Node(1, new Node(2, new Node(4), new Node(5)), new Node(3, null, new Node(7)));
		var resp = connect(isConnected);
		Assertions.assertEquals(7, resp.left.right.next.val);
	}

	public Node connect(Node root) {
		if (root == null) {
			return null;
		}
		var queue = new ArrayDeque<Pair>();
		var currentLevel = -1;
		var prevNode = (Node) null;
		queue.add(new Pair(root, 0));
		while (!queue.isEmpty()) {
			var pair = queue.poll();
			if (currentLevel != pair.level) {
				prevNode = pair.node;
				currentLevel = pair.level;
			} else {
				prevNode.next = pair.node;
				prevNode = pair.node;
			}
			if (pair.node.left != null) {
				queue.add(new Pair(pair.node.left, pair.level +1));
			}
			if (pair.node.right != null) {
				queue.add(new Pair(pair.node.right, pair.level +1));
			}
		}

		return root;
	}

	public static class Pair {
		Node node;
		int level = 0;

		public Pair(Node node, int level) {
			this.node = node;
			this.level = level;
		}

	}

	static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node next;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right, Node _next) {
			val = _val;
			left = _left;
			right = _right;
			next = _next;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}

	}

}
