
package com.stelmah.example.leetcode;

import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;


class Task524 {

    @Test
    void example1() {
        var s = "abpcplea";
        var dictionary = List.of("ale", "apple", "monkey", "plea");
        Assertions.assertEquals("apple", findLongestWord(s, dictionary));
    }


    public String findLongestWord(String s, List<String> dictionary) {
        var answer = "";
        for (var word: dictionary) {
            var pos = 0;
            for (int i = 0; i< s.length(); i++) {
                if (word.charAt(pos) == s.charAt(i)) {
                    pos ++;
                    if (pos == word.length()) {
                        if (word.length() == answer.length() && answer.compareTo(word) > 0) {
                            answer = word;
                        }
                        if (word.length() > answer.length()) {
                            answer = word;
                        }
                        break;
                    }
                }
            }
        }
        return answer;
    }

}
