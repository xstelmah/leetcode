package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task394_2 {

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

    /**
     * Beats 100%.
     */
    public String decodeString(String s) {
        return extract(s.toCharArray(), 0, s.length() - 1).toString();
    }

    public StringBuilder extract(char[] chars, int start, int end) {
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
                var repeatedChars = subChars.toString().repeat(num);
                sb.append(repeatedChars);
                i = endPos;
                num = 0;
            }
        }
        return sb;
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

}
