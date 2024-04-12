
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1737 {


    @Test
    void example1() {
        var a = "aba";
        var b = "caa";

        Assertions.assertEquals(2, minCharacters(a, b));
    }

    @Test
    void example2() {
        var a = "zzz";
        var b = "aaa";

        Assertions.assertEquals(0, minCharacters(a, b));
    }

    public int minCharacters(String a, String b) {
        var answer = Math.max(a.length(), b.length());
        var chr1 = new int[26];
        var chr2 = new int[26];

        for (int i = 0; i < a.length(); i++) {
            chr1[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            chr2[b.charAt(i) - 'a']++;
        }
        answer = Math.min(answer, checkCondition3(chr1, a, chr2, b));

        for (int i = 1; i < 26; i++) {
            answer = Math.min(answer, checkCondition12(chr1, chr2, i));
            answer = Math.min(answer, checkCondition12(chr2, chr1, i));
        }

        return answer;
    }

    private int checkCondition12(int[] chr1, int[] chr2, int limit) {
        var cnt1 = 0;
        var cnt2 = 0;

        for (int i = limit; i < chr1.length; i++) {
            cnt1 += chr1[i];
        }

        for (int i = 0; i < limit; i++) {
            cnt2 += chr2[i];
        }

        return cnt1 + cnt2;
    }

    private int checkCondition3(int[] chr1, String a, int[] chr2, String b) {
        var max1 = 0;
        for (int cnt : chr1) {
            if (cnt > max1) {
                max1 = cnt;
            }
        }

        var max2 = 0;
        for (int cnt : chr2) {
            if (cnt > max2) {
                max2 = cnt;
            }
        }

        return a.length() - max1 + b.length() - max2;
    }

}
