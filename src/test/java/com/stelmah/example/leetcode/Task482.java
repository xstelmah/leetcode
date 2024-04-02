
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;


class Task482 {

    @Test
    void example1() {
        var s = "5F3Z-2e-9-w";
        var k = 4;
        Assertions.assertEquals("5F3Z-2E9W", licenseKeyFormatting(s, k));
    }

    @Test
    void example2() {
        var s = "2-5g-3-J";
        var k = 2;
        Assertions.assertEquals("2-5G-3J", licenseKeyFormatting(s, k));
    }

    public String licenseKeyFormattingV1(String s, int k) {
        var sb = new StringBuilder();
        s = s.replaceAll("-", "");
        s = s.toUpperCase(Locale.ROOT);
        for (int i = s.length() - 1, j = 0; i >= 0; i--, j++) {
            if (j != 0 && j % k == 0) {
                sb.append("-");
            }
            sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }

    /** Beats 100% */
    public String licenseKeyFormatting(String s, int k) {
        var dashCnt = 0;
        var baseChrs = s.toCharArray();
        for (int i = 0; i < baseChrs.length; i++) {
            if (baseChrs[i] == '-') {
                dashCnt++;
            }
        }
        var charLen = baseChrs.length - dashCnt;
        var dif = 'A' - 'a';
        var chars = new char[charLen + ((charLen - 1) / k)];
        int i = baseChrs.length - 1;
        int j = 0;
        int resultPos = chars.length - 1;
        while (i >= 0) {
            if (baseChrs[i] == '-') {
                i--;
                continue;
            }
            if (j != 0 && j % k == 0) {
                chars[resultPos--] = '-';
            }
            chars[resultPos--] = (baseChrs[i] > 90 ? (char) (baseChrs[i] + dif) : baseChrs[i]);
            i--;
            j++;
        }
        return new String(chars);
    }
}
