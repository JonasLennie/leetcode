package Challenges;

import java.util.*;

public class LetterCombinationsPhoneNumber {
    private final Map<Character, List<Character>> digitToPossibleLetters;
    List<String> allowedStrings;

    public LetterCombinationsPhoneNumber() {
        allowedStrings = new ArrayList<>();
        digitToPossibleLetters = new HashMap<>();

        populateDigitToPossibleLetters();
    }

    private void populateDigitToPossibleLetters() {
        addList('2', 'a', 'b', 'c');
        addList('3', 'd', 'e', 'f');
        addList('4', 'g', 'h', 'i');
        addList('5', 'j', 'k', 'l');
        addList('6', 'm', 'n', 'o');
        addList('7', 'p', 'q', 'r', 's');
        addList('8', 't', 'u', 'v');
        addList('9', 'w', 'x', 'y', 'z');
    }

    private void addList(char number, Character... letters) {
        digitToPossibleLetters.put(number, Arrays.asList(letters));
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isBlank())
            return new ArrayList<>();

        List<List<Character>> allowedStringBuilder = getAllowedStringBuilder(digits);

        traverseAllowedStrings(new StringBuilder(), allowedStringBuilder);

        return allowedStrings;
    }

    private List<List<Character>> getAllowedStringBuilder(String digits) {
        List<List<Character>> allowedStringBuilder = new ArrayList<>();

        for (Character digit : digits.toCharArray())
            allowedStringBuilder.add(digitToPossibleLetters.get(digit));

        return allowedStringBuilder;
    }

    private void traverseAllowedStrings(StringBuilder s, List<List<Character>> localAllowedStringBuilder) {
        if (localAllowedStringBuilder.isEmpty())
            allowedStrings.add(s.toString());
        else
            runThroughNextCharacter(s, localAllowedStringBuilder);
    }

    private void runThroughNextCharacter(StringBuilder s, List<List<Character>> localAllowedStringBuilder) {
        List<Character> nextVariableCharacter = localAllowedStringBuilder.get(0);

        for (char nextChar : nextVariableCharacter)
            traverseAllowedStrings(new StringBuilder(s).append(nextChar)
                    , localAllowedStringBuilder.subList(1, localAllowedStringBuilder.size()));
    }
}
