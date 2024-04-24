package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Task93 {

    @Test
    void example1() {
        var s = "25525511135";

        String[] expected = {"255.255.11.135", "255.255.111.35"};

        var result = restoreIpAddresses(s);

        Assertions.assertArrayEquals(expected, result.toArray());
    }


    @Test
    void example2() {
        var s = "101023";

        String[] expected = {"1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3"};

        var result = restoreIpAddresses(s);

        Assertions.assertArrayEquals(expected, result.toArray());
    }


    /**
     * Beats 99.11%. 1ms.
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return List.of();
        }
        char[][] temp = new char[4][];
        var answers = new ArrayList<String>();

        split(0, 4, s.toCharArray(), temp, answers);

        return answers;
    }

    public void split(int pos, int parts, char[] chars, char[][] temp, List<String> answers) {
        if (parts == 0) {
            if (pos == chars.length) {
                answers.add(toString(temp, chars.length + 3));
            }
            return;
        }
        for (int len = 0; len < 3; len++) {
            if (isValid(chars, pos, pos + len)) {
                temp[temp.length - parts] = Arrays.copyOfRange(chars, pos, pos + len + 1);
                split(pos + len + 1, parts - 1, chars, temp, answers);
            } else {
                return;
            }
        }
    }


    public boolean isValid(char[] chars, int l, int r) {
        if (r >= chars.length) {
            return false;
        }
        if (l == r) {
            return true;
        }
        if (chars[l] == '0') {
            return false;
        }
        if (r - l == 1) {
            return true;
        }
        if (chars[l] == '0' && chars[l + 1] == '0') {
            return false;
        }

        return (chars[l] - '0') * 100 + (chars[l + 1] - '0') * 10 + chars[l + 2] - '0' <= 255;
    }

    public String toString(char[][] chars, int len) {
        int i = 0;
        int z = 0;
        var str = new char[len];

        while (i < chars.length) {
            for (int j = 0; j < chars[i].length; j++) {
                str[z++] = chars[i][j];
            }
            if (i != 3) {
                str[z++] = '.';
            }

            i++;
        }
        return new String(str);
    }

}
