package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

class Task1036 {

	@Test
	void example1() {
		var blocked = new int[][] { { 0, 1 }, { 1, 0 } };
		var source = new int[] { 0, 0 };
		var target = new int[] { 0, 2 };
		Assertions.assertEquals(false, isEscapePossible(blocked, source, target));
	}

	@Test
	void example2() {
		var blocked = new int[][] {};
		var source = new int[] { 0, 0 };
		var target = new int[] { 999999, 999999 };
		Assertions.assertEquals(true, isEscapePossible(blocked, source, target));
	}

	@Test
	void example3() {
		var blocked = new int[][] { { 100059, 100063 }, { 100060, 100064 }, { 100061, 100065 }, { 100062, 100066 },
				{ 100063, 100067 }, { 100064, 100068 }, { 100065, 100069 }, { 100066, 100070 }, { 100067, 100071 },
				{ 100068, 100072 }, { 100069, 100073 }, { 100070, 100074 }, { 100071, 100075 }, { 100072, 100076 },
				{ 100073, 100077 }, { 100074, 100078 }, { 100075, 100079 }, { 100076, 100080 }, { 100077, 100081 },
				{ 100078, 100082 }, { 100079, 100083 }, { 100080, 100082 }, { 100081, 100081 }, { 100082, 100080 },
				{ 100083, 100079 }, { 100084, 100078 }, { 100085, 100077 }, { 100086, 100076 }, { 100087, 100075 },
				{ 100088, 100074 }, { 100089, 100073 }, { 100090, 100072 }, { 100091, 100071 }, { 100092, 100070 },
				{ 100093, 100069 }, { 100094, 100068 }, { 100095, 100067 }, { 100096, 100066 }, { 100097, 100065 },
				{ 100098, 100064 }, { 100099, 100063 }, { 100098, 100062 }, { 100097, 100061 }, { 100096, 100060 },
				{ 100095, 100059 }, { 100094, 100058 }, { 100093, 100057 }, { 100092, 100056 }, { 100091, 100055 },
				{ 100090, 100054 }, { 100089, 100053 }, { 100088, 100052 }, { 100087, 100051 }, { 100086, 100050 },
				{ 100085, 100049 }, { 100084, 100048 }, { 100083, 100047 }, { 100082, 100046 }, { 100081, 100045 },
				{ 100080, 100044 }, { 100079, 100043 }, { 100078, 100044 }, { 100077, 100045 }, { 100076, 100046 },
				{ 100075, 100047 }, { 100074, 100048 }, { 100073, 100049 }, { 100072, 100050 }, { 100071, 100051 },
				{ 100070, 100052 }, { 100069, 100053 }, { 100068, 100054 }, { 100067, 100055 }, { 100066, 100056 },
				{ 100065, 100057 }, { 100064, 100058 }, { 100063, 100059 }, { 100062, 100060 }, { 100061, 100061 },
				{ 100060, 100062 } };
		var source = new int[] { 100079, 100063 };
		var target = new int[] { 999948, 999967 };
		Assertions.assertEquals(false, isEscapePossible(blocked, source, target));
	}

	@Test
	void example4() {
		var blocked = new int[][] { { 100025, 100016 }, { 100026, 100017 }, { 100027, 100018 }, { 100028, 100019 },
				{ 100029, 100020 }, { 100030, 100021 }, { 100031, 100022 }, { 100032, 100023 }, { 100033, 100024 },
				{ 100034, 100025 }, { 100035, 100026 }, { 100036, 100027 }, { 100037, 100028 }, { 100038, 100029 },
				{ 100039, 100030 }, { 100040, 100031 }, { 100041, 100032 }, { 100042, 100033 }, { 100043, 100034 },
				{ 100044, 100035 }, { 100045, 100036 }, { 100046, 100037 }, { 100047, 100038 }, { 100048, 100039 },
				{ 100049, 100040 }, { 100050, 100041 }, { 100051, 100042 }, { 100052, 100043 }, { 100053, 100044 },
				{ 100054, 100045 }, { 100055, 100046 }, { 100056, 100045 }, { 100057, 100044 }, { 100058, 100043 },
				{ 100059, 100042 }, { 100060, 100041 }, { 100061, 100040 }, { 100062, 100039 }, { 100063, 100038 },
				{ 100064, 100037 }, { 100065, 100036 }, { 100066, 100035 }, { 100067, 100034 }, { 100068, 100033 },
				{ 100069, 100032 }, { 100070, 100031 }, { 100071, 100030 }, { 100072, 100029 }, { 100073, 100028 },
				{ 100074, 100027 }, { 100075, 100026 }, { 100076, 100025 }, { 100077, 100024 }, { 100078, 100023 },
				{ 100079, 100022 }, { 100080, 100021 }, { 100081, 100020 }, { 100082, 100019 }, { 100083, 100018 },
				{ 100084, 100017 }, { 100085, 100016 }, { 100084, 100015 }, { 100083, 100014 }, { 100082, 100013 },
				{ 100081, 100012 }, { 100080, 100011 }, { 100079, 100010 }, { 100078, 100009 }, { 100077, 100008 },
				{ 100076, 100007 }, { 100075, 100006 }, { 100074, 100005 }, { 100073, 100004 }, { 100072, 100003 },
				{ 100071, 100002 }, { 100070, 100001 }, { 100069, 100000 }, { 100068, 99999 }, { 100067, 99998 },
				{ 100066, 99997 }, { 100065, 99996 }, { 100064, 99995 }, { 100063, 99994 }, { 100062, 99993 },
				{ 100061, 99992 }, { 100060, 99991 }, { 100059, 99990 }, { 100058, 99989 }, { 100057, 99988 },
				{ 100056, 99987 }, { 100055, 99986 }, { 100054, 99987 }, { 100053, 99988 }, { 100052, 99989 },
				{ 100051, 99990 }, { 100050, 99991 }, { 100049, 99992 }, { 100048, 99993 }, { 100047, 99994 },
				{ 100046, 99995 }, { 100045, 99996 }, { 100044, 99997 }, { 100043, 99998 }, { 100042, 99999 },
				{ 100041, 100000 }, { 100040, 100001 }, { 100039, 100002 }, { 100038, 100003 }, { 100037, 100004 },
				{ 100036, 100005 }, { 100035, 100006 }, { 100034, 100007 }, { 100033, 100008 }, { 100032, 100009 },
				{ 100031, 100010 }, { 100030, 100011 }, { 100029, 100012 }, { 100028, 100013 }, { 100027, 100014 },
				{ 100026, 100015 } };
		var source = new int[] { 100055, 100016 };
		var target = new int[] { 999974, 999914 };
		Assertions.assertEquals(false, isEscapePossible(blocked, source, target));
	}

	@Test
	void example5() {
		var blocked = new int[][] { {10,9},{9,10},{10,11},{11,10} };
		var source = new int[] { 0, 0 };
		var target = new int[] { 10, 10 };
		Assertions.assertEquals(false, isEscapePossible(blocked, source, target));
	}

	public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
		return isEscapePossible2(blocked, source, target) && isEscapePossible2(blocked, target, source);
	}

	public boolean isEscapePossible2(int[][] blocked, int[] source, int[] target) {
		var leftBorder = 0;
		var topBorder = 0;
		var rightBorder = 999_999;
		var bottomBorder = 999_999;

		var sourceX = source[0];
		var sourceY = source[1];

		var targetX = target[0];
		var targetY = target[1];

		var queue = new LinkedList<Node>();
		var blockSet = new HashSet<Long>();
		for (int[] block : blocked) {
			blockSet.add(calcCoordinatesHash(block[0], block[1]));
		}

		queue.add(new Node(sourceX, sourceY, 0));

		while (!queue.isEmpty()) {
			var node = queue.poll();
			if (node.step > 201) {
				return true;
			}

			if (node.x == targetX && node.y == targetY) {
				return true;
			}
			if (blockSet.contains(calcCoordinatesHash(node.x, node.y))) {
				continue;
			}
			blockSet.add(calcCoordinatesHash(node.x, node.y));
			if (node.x + 1 <= rightBorder && node.y <= bottomBorder && !blockSet.contains(
					calcCoordinatesHash(node.x + 1, node.y))) {
				queue.addLast(new Node(node.x + 1, node.y, node.step + 1));
			}
			if (node.x <= rightBorder && node.y + 1 <= bottomBorder && !blockSet.contains(
					calcCoordinatesHash(node.x, node.y + 1))) {
				queue.addLast(new Node(node.x, node.y + 1, node.step + 1));
			}
			if (node.x >= leftBorder && node.y - 1 >= topBorder && !blockSet.contains(
					calcCoordinatesHash(node.x, node.y - 1))) {
				queue.addLast(new Node(node.x, node.y - 1, node.step + 1));
			}
			if (node.x - 1 >= leftBorder && node.y >= topBorder && !blockSet.contains(
					calcCoordinatesHash(node.x - 1, node.y))) {
				queue.addLast(new Node(node.x - 1, node.y, node.step + 1));
			}
		}
		return false;
	}

	private long calcCoordinatesHash(int x, int y) {
		return (long) x * 1_000_000 + y; // shift for hash calculation, remove collisions
	}

	public static class Node {
		public int x;
		public int y;
		public int step = 0;

		public Node(int x, int y, int step) {
			this.x = x;
			this.y = y;
			this.step = step;
		}

	}

}
