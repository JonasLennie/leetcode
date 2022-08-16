package uk.jlennie.leetcode.Challenges;

import java.util.*;

public class ValidParenthesis {
    private Queue<Character> s;

    public boolean isValid(String s) {
        this.s = new ArrayDeque<>(s.chars().mapToObj(e -> (char) e).toList());

        boolean isGood = true;

        while (canRemove()) {
            isGood &= newBracketSet(this.s.remove());
        }

        return isGood;
    }

    private boolean newBracketSet(char opening) {
        if(!canRemove())
            return false;

        return newBracketSetCanRemove(opening);
    }

    private boolean newBracketSetCanRemove(char opening) {
        char nextChar = s.remove();

        boolean isGood = true;

        while (isOpening(nextChar) && canRemove()) {
            isGood &= newBracketSet(nextChar);
            if (canRemove())
                nextChar = s.remove();
        }
        return isGood & matchesClosingFor(nextChar, opening);
    }

    private boolean canRemove() {
        return !s.isEmpty();
    }

    private boolean matchesClosingFor(Character c, char opening) {
        return isOpening(opening) && c == getMatchingClosing(opening);
    }


    private char getMatchingClosing(char opening) {
        return switch (opening) {
            case '[' -> ']';
            case '(' -> ')';
            case '{' -> '}';
            default -> throw new RuntimeException();
        };
    }

    private boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }
}
