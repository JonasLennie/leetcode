package uk.jlennie.leetcode.Challenges;

import java.util.*;

public class LongestCommonPrefix {
    List<Character> prefix;
    String[] words;

    public LongestCommonPrefix() {
        prefix = new ArrayList<>();
    }

    public String longestCommonPrefix(String[] strs) {
        words = strs;

        return lcpAtIndex(0);
    }

    String lcpAtIndex(int index) {
        if (reachedEndOfWord(index))
            return getFormattedString();

        return safeLcpAtIndex(index);
    }

    private String safeLcpAtIndex(int index) {
        char current = getCurrent(index);

        for (String str : words)
            if (doesCommonPrefixEnd(index, current, str))
                return getFormattedString();

        return doNextIteration(current, index);
    }

    private boolean reachedEndOfWord(int index) {
        return index >= words[0].length();
    }

    private char getCurrent(int index) {
        return words[0].charAt(index);
    }

    private String doNextIteration(char current, int index) {
        prefix.add(current);

        index ++;
        return lcpAtIndex(index);
    }

    private String getFormattedString() {
        return prefix.stream().map(Object::toString).reduce((acc, e) -> acc + e).orElse("");
    }

    private boolean doesCommonPrefixEnd(int index, char current, String str) {
        return str.length() <= index || str.charAt(index) != current;
    }
}
