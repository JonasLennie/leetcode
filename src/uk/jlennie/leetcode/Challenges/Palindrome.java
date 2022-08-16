package uk.jlennie.leetcode.Challenges;

public class Palindrome {
    int mid;
    int maxIndex;
    boolean isPalindrome;
    String xAsString;

    private void setup(int x) {
        xAsString = Integer.toString(x);

        maxIndex = xAsString.length() - 1;
        mid = maxIndex / 2;

        isPalindrome = true;
    }

    private boolean updateIsPalindrome(char atI, char iFromReverse) {
        return isPalindrome & atI == iFromReverse;
    }

    private void readInNextCharPair(int i) {
        char charAtI = xAsString.charAt(i);
        char charAtIFromReverse = xAsString.charAt(maxIndex - i);

        isPalindrome = updateIsPalindrome(charAtI, charAtIFromReverse);
    }

    private void walkThroughString() {
        for (int i = 0; i <= mid; i ++ )
            readInNextCharPair(i);
    }

    public boolean isPalindrome(int x) {
        setup(x);

        walkThroughString();

        return isPalindrome;
    }
}
