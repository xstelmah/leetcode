
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Task1235 {

    @Test
    public void example1() {
        int[] startTime = {1, 2, 3, 3};
        int[] endTime = {3, 4, 5, 6};
        int[] profit = {50, 10, 40, 70};

        Assertions.assertEquals(120, jobScheduling(startTime, endTime, profit));
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        var n = startTime.length;
        var jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }
        Arrays.sort(jobs, (j1, j2) -> j1.end - j2.end);
        var dp = new int[n];
        dp[0] = jobs[0].profit;

        for (int i = 1; i < n; i++) {

            var prevIndex = findPrev(jobs, i);

            if (prevIndex != -1) {
                dp[i] = Math.max(jobs[i].profit + dp[prevIndex], dp[i - 1]);
            } else {
                dp[i] = Math.max(jobs[i].profit, dp[i - 1]);
            }

        }

        return dp[n - 1];
    }

    private int findPrev(Job[] jobs, int index) {
        var start = jobs[index].start;
        var l = 0;
        var r = index - 1;
        while (l < r) {
            var m = (l + r + 1) / 2;
            if (jobs[m].end > start) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        if (jobs[l].end > start) {
            return -1;
        }
        return l;
    }

    public static class Job {

        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

    }
}
