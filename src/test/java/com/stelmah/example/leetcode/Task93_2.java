package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class Task93_2 {

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
     * Beats 84.02%. 2ms.
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return List.of();
        }
        var answers = new ArrayList<String>();
        for (int i1 = 1; i1 < 4; i1++) {
            for (int i2 = 1; i2 < 4; i2++) {
                for (int i3 = 1; i3 < 4; i3++) {
                    for (int i4 = 1; i4 < 4; i4++) {
                        if (i1 + i2 + i3 + i4 == s.length()) {
                            var num1 = Integer.parseInt(s.substring(0, i1));
                            var num2 = Integer.parseInt(s.substring(i1, i1 + i2));
                            var num3 = Integer.parseInt(s.substring(i1 + i2, i1 + i2 + i3));
                            var num4 = Integer.parseInt(s.substring(i1 + i2 + i3, i1 + i2 + i3 + i4));
                            if (num1 < 256 && num2 < 256 && num3 < 256 && num4 < 256) {
                                var str = new StringBuilder()
                                        .append(num1)
                                        .append('.')
                                        .append(num2)
                                        .append('.')
                                        .append(num3)
                                        .append('.')
                                        .append(num4)
                                        .toString();
                                if (str.length() == s.length() + 3) {
                                    answers.add(str);
                                }
                            }
                        }
                    }
                }
            }
        }

        return answers;
    }
}
