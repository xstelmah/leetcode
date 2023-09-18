package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Task218 {

	@Test
	void example1() {
		var buildings = new int[][] { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		var answer = List.of(List.of(2, 10), List.of(3, 15), List.of(7, 12), List.of(12, 0), List.of(15, 10),
				List.of(20, 8), List.of(24, 0));
		var methodResponse = getSkyline(buildings);
		Assertions.assertEquals(answer.size(), methodResponse.size());
		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < answer.get(i).size(); j++) {
				Assertions.assertEquals(answer.get(i).get(j), methodResponse.get(i).get(j));
			}
		}
	}

	@Test
	void example2() {
		var buildings = new int[][] { { 0, 2, 3 }, { 2, 5, 3 } };
		var answer = List.of(List.of(0, 3), List.of(5, 0));
		var methodResponse = getSkyline(buildings);
		Assertions.assertEquals(answer.size(), methodResponse.size());
		for (int i = 0; i < answer.size(); i++) {
			for (int j = 0; j < answer.get(i).size(); j++) {
				Assertions.assertEquals(answer.get(i).get(j), methodResponse.get(i).get(j));
			}
		}
	}

	public List<List<Integer>> getSkyline(int[][] buildings) {
		var result = new ArrayList<List<Integer>>();
		var edges = new ArrayList<Edge>();
		for (int i = 0; i < buildings.length; i++) {
			// buildings[i][0] - left position, i - position from buildings
			// buildings[i][1] - right position, i - position from buildings
			edges.add(new Edge(buildings[i][0], i));
			edges.add(new Edge(buildings[i][1], i));
		}
		// sort by position
		edges.sort(Comparator.comparingInt(edge -> edge.pos));

		// Pair.height = height, Pair.second = right, sort by pair.first (by height)
		var pq = new PriorityQueue<Pair>(Comparator.comparingInt(pair -> -pair.height));

		var i = 0; // start index = first left position
		var currentHeight = 0;
		while (i < edges.size()) {
			var buildingPos = edges.get(i).pos;
			while (true) {  // If we have several edges with the same pos
				var buildingIndex = edges.get(i).index;
				pq.add(new Pair(buildings[buildingIndex][2], buildings[buildingIndex][1]));
				if (i + 1 < edges.size() && edges.get(i).pos == edges.get(i + 1).pos) {
					i++;
				} else {
					i++;
					break;
				}
			}

			while (pq.size() != 0 && pq.peek().right <= buildingPos)
				pq.remove(); // remove top element if right <= buildingPos

			var newHeight = 0;
			if (pq.size() != 0) {
				newHeight = pq.peek().height;
			}
			if (newHeight != currentHeight) {
				result.add(List.of(buildingPos, newHeight));
				currentHeight = newHeight;
			}
		}
		return result;
	}

	public static class Edge {
		public int pos;
		public int index;

		public Edge(int pos, int index) {
			this.pos = pos;
			this.index = index;
		}

	}

	public static class Pair {
		public int height;
		public int right;

		public Pair(int height, int right) {
			this.height = height;
			this.right = right;
		}

	}

}
