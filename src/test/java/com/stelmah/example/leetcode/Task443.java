package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task443 {

    @Test
    void example1() {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        char[] expected = {'a', '1', '3', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        var answer = compress(chars);
        Assertions.assertEquals(3, answer);
        Assertions.assertArrayEquals(expected, chars);
    }

    @Test
    void example2() {
        char[] chars = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        char[] expected = {'a', '1', '0', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        var answer = compress(chars);
        Assertions.assertEquals(3, answer);
        Assertions.assertArrayEquals(expected, chars);
    }
    @Test
    void example3() {
        char[] chars = {'a','a','b','b','c','c','c'};
        char[] expected = {'a', '2', 'b', '2', 'c', '3', 'c'};
        var answer = compress(chars);
        Assertions.assertEquals(6, answer);
        Assertions.assertArrayEquals(expected, chars);
    }

    public int compress(char[] chars) {
        if (chars.length == 1) {
            return 1;
        }
        var chr = chars[0];
        var cnt = 1;
        var chrIndex = 0;
        var len = chars.length;
        for (int i = 1; i <= len; i++) {
            if (i != len && chr == chars[i]) {
                cnt++;
                continue;
            }

            chrIndex = writeAndGetNextPos(chars, chrIndex, chr, cnt);
            if (i == len) {
                break;
            }
            chr = chars[i];
            cnt = 1;
        }

        return chrIndex;
    }

    public int writeAndGetNextPos(char[] chars, int startPos, char chr, int count) {
        chars[startPos++] = chr;
        if (count == 1) {
            return startPos;
        }

        var numLen = lenOfNum(count);
        var pos = 1;
        while (count > 0) {
            var digit = count % 10;
            count /= 10;
            chars[startPos + numLen - pos] = (char) (digit + '0');
            pos++;
        }

        return startPos + numLen;
    }

    public int lenOfNum(int num) {
        return (int) Math.ceil(Math.log10(num + 1));
    }

}
