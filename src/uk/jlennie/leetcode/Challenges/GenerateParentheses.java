package uk.jlennie.leetcode.Challenges;

import java.util.*;

// Not my best work, but a fine solution

// Problem: want to generate all valid parentheses sets for n pairs
// Solution: If we have n pairs, consider some bracket: ()
//      The remaining n-1 pairs must be distributed ({k pairs of ()}){n - k pairs of ()}
//      i.e. some inside brackets, some outside brackets
public class GenerateParentheses {
    private final Map<Integer, List<String>> cacheGenerateParenthesis;

    public GenerateParentheses() {
        cacheGenerateParenthesis = new HashMap<>();
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return Arrays.asList("");

        return generateParentheseNonZero(n);
    }

    private List<String> generateParentheseNonZero(int n) {
        if (cacheGenerateParenthesis.containsKey(n))
            return cacheGenerateParenthesis.get(n);

        return generateParenthesesNotCachedOrZero(n);
    }

    private List<String> generateParenthesesNotCachedOrZero(int n) {
        List<String> permutations = new ArrayList<>();

        for (int i = 0; i < n; i ++) {
            iterateForSomePossibleMiddleSection(n, permutations, i);
        }

        cacheGenerateParenthesis.put(n, permutations);

        return permutations;
    }

    private void iterateForSomePossibleMiddleSection(int n, List<String> permutations, int i) {
        List<String> middleSections = generateParenthesis(i);
        List<String> endSections = generateParenthesis(n - i - 1);

        iterateOverMiddleAndEndSections(permutations, middleSections, endSections);
    }

    private static void iterateOverMiddleAndEndSections(List<String> permutations, List<String> middleSections, List<String> endSections) {
        for (String midSection : middleSections)
            for (String endSection : endSections)
                addPossibilityToPermutation(permutations, midSection, endSection);
    }

    private static void addPossibilityToPermutation(List<String> permutations, String midSection, String endSection) {
        permutations.add("(" + midSection + ")" + endSection);
    }
}
