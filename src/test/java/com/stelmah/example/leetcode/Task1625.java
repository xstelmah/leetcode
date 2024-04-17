
package com.stelmah.example.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


class Task1625 {


    @Test
    void example1() {
        var s = "5525";
        var a = 9;
        var b = 2;

        Assertions.assertEquals("2050", findLexSmallestString(s, a, b));
    }

    public String findLexSmallestString(String s, int a, int b) {
        // Initialize the initial state and a set to keep track of visited states
        var baseState = new State(s);
        var set = new HashSet<State>();

        // Generate states recursively and find the minimum
        var answer = findLexSmallestState(a, b, baseState, set);

        // Return the lexicographically smallest string
        return new String(answer.chars);
    }

    // Recursive method to generate states
    public State findLexSmallestState(int a, int b, State currentState, Set<State> states) {
        // If the state is already visited, return it
        if (states.contains(currentState)) {
            return currentState;
        }
        states.add(currentState);

        // Generate two new states: one by adding 'a' to odd indices, and another by rotating right by 'b'
        var state1 = findLexSmallestState(a, b, currentState.addToOddIndexes(a), states);
        var state2 = findLexSmallestState(a, b, currentState.rotateToRight(b), states);

        // Return the minimum state among the current state and the generated states
        return currentState.min(state1).min(state2);
    }

    // Custom class to represent states of the string
    public static class State {
        final char[] chars;
        final int cachedHashCode;

        public State(char[] chars) {
            this.chars = chars;
            this.cachedHashCode = Arrays.hashCode(chars);
        }

        public State(String s) {
            this.chars = s.toCharArray();
            this.cachedHashCode = Arrays.hashCode(chars);
        }

        // Method to find the minimum state
        public State min(State state) {
            if (Arrays.compare(chars, state.chars) > 0) {
                return state;
            }
            return this;
        }

        // Method to add 'a' to odd indices
        public State addToOddIndexes(int a) {
            var newChars = Arrays.copyOf(chars, chars.length);
            for (int i = 1; i < chars.length; i += 2) {
                newChars[i] = (char) ((newChars[i] - '0' + a) % 10 + '0');
            }
            return new State(newChars);
        }

        // Method to rotate the string to the right by 'b' positions
        public State rotateToRight(int b) {
            var newChars = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                newChars[(i + b) % chars.length] = chars[i];
            }
            return new State(newChars);
        }

        @Override
        public int hashCode() {
            return cachedHashCode;
        }

        @Override
        public boolean equals(Object obj) {
            return Arrays.equals(chars, ((State) obj).chars);
            // The probability of a collision is low and we can do such optimization, but this is exclusively for tests
            // DON'T USE IT IN PRODUCTION
            // return cachedHashCode == obj.hashCode();
        }

    }

}
