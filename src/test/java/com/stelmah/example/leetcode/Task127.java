package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

class Task127 {

    @Test
    void example1() {
        var answer = ladderLength("aaa", "aab", List.of("aab"));
        Assertions.assertEquals(2, answer);
    }

    @Test
    void example2() {
        var answer = ladderLength("qa", "sq", List.of("sn", "ha", "an", "sq"));
        Assertions.assertEquals(0, answer);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }
        if (beginWord.length() == 1) {
            return wordList.contains(endWord) ? 2 : 0;
        }

        var hashesMap = new HashMap<String, List<Long>>();
        var wordMap = new HashMap<Long, List<String>>();

        fillMaps(wordList, hashesMap, wordMap);
        fillMaps(beginWord, hashesMap, wordMap);
        var visitedSet = new HashSet<String>();

        List<String> queue1 = new ArrayList<String>();
        List<String> queue2;
        queue1.add(beginWord);

        var depth = 0;

        while (!queue1.isEmpty()) {
            queue2 = new ArrayList<String>();
            for (var word : queue1) {
                if (visitedSet.contains(word)) {
                    continue;
                }
                visitedSet.add(word);
                if (visitedSet.contains(endWord)) {
                    return depth + 1;
                }

                var hashes = hashesMap.get(word);
                for (var hash : hashes) {
                    for (var destWord : wordMap.get(hash)) {
                        if (!visitedSet.contains(destWord)) {
                            queue2.add(destWord);
                        }
                    }
                }
            }
            queue1 = queue2;
            depth++;
        }
        return 0;
    }

    public void fillMaps(List<String> wordList,
                         Map<String, List<Long>> hashesMap,
                         Map<Long, List<String>> wordMap) {
        for (var word : wordList) {
            fillMaps(word, hashesMap, wordMap);
        }
    }


    public void fillMaps(String word,
                         Map<String, List<Long>> hashesMap,
                         Map<Long, List<String>> wordMap) {
        for (int i = 0; i < word.length(); i++) {
            var hash = calcWordHash(word, i);
            if (!hashesMap.containsKey(word)) {
                hashesMap.put(word, new ArrayList<Long>());
            }
            if (!wordMap.containsKey(hash)) {
                wordMap.put(hash, new ArrayList<String>());
            }
            hashesMap.get(word).add(hash);
            wordMap.get(hash).add(word);
        }
    }

    public long calcWordHash(String word, int pos) {
        var chars = word.toCharArray();
        long hash = 0L;
        for (var i = 0; i < chars.length; i++) {
            if (i != pos) {
                hash = hash * 28 + (chars[i] - 'a') + 1;
            } else {
                hash = hash * 28;
            }
        }
        return hash;
    }

}
