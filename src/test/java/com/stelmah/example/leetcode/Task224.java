package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Task224 {

    @Test
    void example1() {
        var s = "(1+(4+5+2)-3)+(6+8)";
        Assertions.assertEquals(23, calculate(s));
    }

    public int calculate(String s) {
        var chars = s.toCharArray();

        return calculateExpression(chars, 0, chars.length - 1)[0];
    }

    /**
     * @return an array of two elements.
     * [0] is the result of the operation.
     * [1] is the index where we stopped.
     */
    public int[] calculateExpression(char[] chars, int start, int end) {
        var answer = 0;

        var index = start;
        // 1 is '+', -1 is '-', in this case we don't need to check the signs, we can do sign * number
        var sign = 1;
        var number = 0;

        while (index <= end) {
            if (chars[index] == '(') {
                var resp = calculateExpression(chars, index + 1, end);
                index = resp[1] + 1; // resp[1] is closing bracket index, so we add +1
                answer += sign * resp[0];
                continue;
            }
            if (chars[index] == ')') {
                answer += sign * number;
                return new int[]{answer, index};
            }

            if (chars[index] == '-' || chars[index] == '+') {
                answer += sign * number;
                number = 0;
                sign = chars[index] == '-' ? -1 : 1;
            }

            if (chars[index] >= '0' && chars[index] <= '9') {
                number = number * 10 + chars[index] - '0';
            }
            index++;
        }
        answer += sign * number;
        return new int[]{answer, end};
    }
}
