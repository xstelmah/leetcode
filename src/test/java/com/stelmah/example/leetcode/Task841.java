package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class Task841 {

    @Test
    void example1() {
        // [[1],[2],[3],[]]
        List<List<Integer>> rooms = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of()
        );
        Assertions.assertEquals(true, canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        var visited = new boolean[rooms.size() + 1];
        visited[0] = true;

        var queue = new LinkedList<Integer>(rooms.get(0));
        while (!queue.isEmpty()) {
            var pos = queue.poll();
            if (visited[pos]) {
                continue;
            }
            queue.addAll(rooms.get(pos));
            visited[pos] = true;
        }
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                return false;
            }
        }
        return true;
    }
}