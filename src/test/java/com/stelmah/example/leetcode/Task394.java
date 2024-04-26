package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task394 {

    @Test
    void example1() {
        var s = "3[a]2[bc]";
        var expected = "aaabcbc";
        Assertions.assertEquals(expected, decodeString(s));
    }
    @Test
    void example2() {
        var s = "3[a2[c]]";
        var expected = "accaccacc";
        Assertions.assertEquals(expected, decodeString(s));
    }

    public String decodeString(String s) {
        return new String(extract(s.toCharArray(), 0, s.length() - 1));
    }

    public char[] extract(char[] chars, int start, int end) {
        var sb = new StringBuilder();
        var num = 0;
        for (int i = start; i <= end; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                num = (num * 10) + chars[i] - '0';
            } else if (chars[i] >= 'a' && chars[i] <= 'z') {
                sb.append(chars[i]);
            } else if (chars[i] == '[') {
                var endPos = findEndBracket(chars, i, end);
                var subChars = extract(chars, i + 1, endPos - 1);
                var repeatedChars = repeat(subChars, num);
                sb.append(repeatedChars);
                i = endPos;
                num = 0;
            }
        }
        return sb.toString().toCharArray();
    }

    public int findEndBracket(char[] chars, int start, int end) {
        var stack = 0;
        for (int i = start; i <= end; i++) {
            if (chars[i] == '[') {
                stack++;
            }
            if (chars[i] == ']' && --stack == 0) {
                return i;
            }
        }
        return -1;
    }

    public char[] repeat(char[] chars, int count) {
        if (count == 0) {
            return new char[0];
        }
        var newChars = new char[chars.length * count];
        var baseLen = chars.length;
        var len = newChars.length;

        for (int i = 0; i < len; i++) {
            newChars[i] = chars[i % baseLen];
        }
        return newChars;
    }

}
