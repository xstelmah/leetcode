package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Task797 {

	@Test
	void example1() {

	}

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		var response = new ArrayList<List<Integer>>();
		allPathsSourceTargetRec(graph, 0, new LinkedList<>(), response);
		return response;
	}

	public void allPathsSourceTargetRec(int[][] graph,
			int pos,
			LinkedList<Integer> numbers,
			List<List<Integer>> response) {
		numbers.add(pos);
		if (pos == graph.length - 1) {
			response.add(new ArrayList<>(numbers));
		}
		for (int i = 0; i < graph[pos].length; i++) {
			var next = graph[pos][i];
			allPathsSourceTargetRec(graph, next, numbers, response);
		}
		numbers.removeLast();
	}

}