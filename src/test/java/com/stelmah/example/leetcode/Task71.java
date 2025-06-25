package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

class Task71 {

    @Test
    void example1() {
        var s = "/.../a/../b/c/../d/./";
        Assertions.assertEquals("/.../b/d", simplifyPath(s));
    }

    char[] CURRENT_DIR_1 = {'.', '/'};
    char[] CURRENT_DIR_2 = {'.', '@'};
    char[] PREVIOUS_DIR_1 = {'.', '.', '/'};
    char[] PREVIOUS_DIR_2 = {'.', '.', '@'};

    public String simplifyPath(String path) {
        var result = new LinkedList<StringBuilder>();
        var chars = new StringBuilder()
                .append(path)
                .append("@")
                .toString().toCharArray();

        simplifyPath2(chars, 0, result);

        if (result.isEmpty()) {
            return "/";
        }
        return result.stream().map(StringBuilder::toString).reduce((a, b) -> a + b).get();
    }

    public void simplifyPath2(char[] chars, int start, LinkedList<StringBuilder> result) {
        if (start >= chars.length - 1) {
            return;
        }
        if (chars[start] == '/') {
            simplifyPath2(chars, start + 1, result);
            return;
        }
        if (match(chars, CURRENT_DIR_1, start) || match(chars, CURRENT_DIR_2, start)) {
            simplifyPath2(chars, start + 2, result);
            return;
        }
        if (match(chars, PREVIOUS_DIR_1, start) || match(chars, PREVIOUS_DIR_2, start)) {
            if (!result.isEmpty()) result.removeLast();
            simplifyPath2(chars, start + 3, result);
            return;
        }
        var sb = new StringBuilder();
        sb.append("/");
        var current = start;
        while (current < chars.length - 1) {
            if (chars[current] == '/') {
                break;
            }
            sb.append(chars[current]);
            current++;
        }
        result.add(sb);
        simplifyPath2(chars, current, result);
    }

    private boolean match(char[] chars, char[] pattern, int start) {
        for (int i = 0; i < pattern.length && (start + i < chars.length); i++) {
            if (chars[start + i] != pattern[i]) {
                return false;
            }
        }
        return true;
    }

}
