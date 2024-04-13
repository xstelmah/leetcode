
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class Task1249 {


    @Test
    void example1() {
        var s = "lee(t(c)o)de)";

        Assertions.assertEquals("lee(t(c)o)de", minRemoveToMakeValid(s));
    }
    @Test
    void example2() {
        var s = "())()(((";

        Assertions.assertEquals("()()", minRemoveToMakeValid(s));
    }

    public String minRemoveToMakeValid(String s) {
        var l = 0;
        var sb = new StringBuilder();
        var close = 0;
        var open = 0;
        var chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (chars[i] == ')') {
                close++;
            }
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (open > 0 && close > 0) {
                    open--;
                    close--;
                } else {
                    close--;
                    continue;
                }
            }
            if (chars[i] == '(') {
                if (close - open > 0) {
                    open++;
                } else {
                    continue;
                }
            }

            sb.append(chars[i]);
        }


        return sb.toString();
    }

}
