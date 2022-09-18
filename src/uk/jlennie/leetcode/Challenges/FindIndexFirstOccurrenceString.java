package uk.jlennie.leetcode.Challenges;

import java.util.*;

// Find the first occurance of a substring in a string
// Needle is the substring, haystack is the string

// Only consumes each character in haystack exactly once, for fun
// O(N)

public class FindIndexFirstOccurrenceString {
    public int strStr(String haystack, String needle) {
        Set<Integer> startIndices = new HashSet<>();

        for (int i = 0; i < haystack.length(); i ++) {
            startIndices.add(i);

            for (Iterator<Integer> iterator = startIndices.iterator(); iterator.hasNext();) {
                Integer startIndex =  iterator.next();
                if (haystack.charAt(i) != needle.charAt(i - startIndex)) {
                    iterator.remove();
                } else if (i - startIndex == needle.length() - 1) {
                    return startIndex;
                }
            }
        }

        return -1;
    }
}
