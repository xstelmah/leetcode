
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1986 {


    @Test
    void example1() {
        int[] tasks = {1, 2, 3};
        int sessionTime = 3;
        Assertions.assertEquals(2, minSessions(tasks, sessionTime));
    }

    @Test
    void example2() {
        int[] tasks = {2, 3, 3, 4, 4, 4, 5, 6, 7, 10};
        int sessionTime = 12;
        Assertions.assertEquals(4, minSessions(tasks, sessionTime));
    }

    @Test
    void example3() {
        int[] tasks = {4, 3, 4, 9, 3, 5, 4, 4, 2};
        int sessionTime = 10;
        Assertions.assertEquals(4, minSessions(tasks, sessionTime));
    }

    public int minSessions(int[] tasks, int sessionTime) {
        var n = tasks.length;
        var maxMask = 1 << n;
        // dp[mask] = (sessions, used_time)
        var dp = new int[maxMask][2];
        dp[0][0] = 1;

        for (int mask = 1; mask < maxMask; mask++) {
            dp[mask][0] = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }
                var prevMask = mask ^ (1 << i);
                if (dp[prevMask][1] + tasks[i] <= sessionTime) {
                    dp[mask] = max(dp[mask], new int[]{dp[prevMask][0], dp[prevMask][1] + tasks[i]});
                } else {
                    dp[mask] = max(dp[mask], new int[]{dp[prevMask][0] + 1, tasks[i]});
                }
            }
        }
        return dp[maxMask -1][0];
    }

    public int[] max(int[] first, int[] second) {
        if (first[0] < second[0]) return first;
        if (first[0] > second[0]) return second;
        if (first[1] < second[1]) return first;
        return second;
    }

}
