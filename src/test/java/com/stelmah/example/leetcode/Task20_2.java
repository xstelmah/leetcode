package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class Task20_2 {

    @Test
    void example1() {
        var s = "()[]{}";
        Assertions.assertTrue(isValid(s));
    }

    @Test
    void example2() {
        var s = "()[}{}";
        Assertions.assertFalse(isValid(s));
    }

    public boolean isValid(String s) {
        var stack = new char[s.length()];

        var stackPos = -1;
        for (var chr : s.toCharArray()) {
            if (chr == '(' || chr == '{' || chr == '[') {
                stack[++stackPos] = chr;
            } else {
                if (stackPos == -1) {
                    return false;
                }
                if (chr == ')' && stack[stackPos--] != '(') {
                    return false;
                }
                if (chr == '}' && stack[stackPos--] != '{') {
                    return false;
                }
                if (chr == ']' && stack[stackPos--] != '[') {
                    return false;
                }
            }
        }

        return stackPos == -1;
    }

}
