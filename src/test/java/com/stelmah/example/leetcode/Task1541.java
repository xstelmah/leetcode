
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1541 {


    @Test
    void example2() {
        var s = "(()))";

        Assertions.assertEquals(1, minInsertions(s));
    }

    @Test
    void example3() {
        var s = "))())(";

        Assertions.assertEquals(3, minInsertions(s));
    }

    @Test
    void example4() {
        var s = "(()))(()))()())))";

        Assertions.assertEquals(4, minInsertions(s));
    }

    public int minInsertions(String s) {
        var open = 0;
        var answer = 0;
        var chrs = s.toCharArray();
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == '(') {
                open += 1;
            } else if (i < chrs.length - 1 && chrs[i] == ')' && chrs[i + 1] == ')') {
                if (open > 0) {
                    open--;
                } else {
                    answer++;
                }
                i++;
            } else {
                if (open == 0) {
                    answer++;
                } else {
                    open--;
                }
                answer++;
            }
        }
        return answer + open * 2;
    }
}
