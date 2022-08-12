package Challenges;

public class RomanToInt {
    String sTail;
    int firstNumber;
    String s;

    public int romanToInt(String s) {
        this.s = s;

        if (s.length() == 0)
            return 0;

        return romanToIntNonzeroString();
    }

    private int romanToIntNonzeroString() {
        setFirstNumberAndTail();

        return firstNumber + romanToInt(sTail);
    }

    private void setFirstNumberAndTail() {
        if (isASmallerCharBeforeABigger())
            subtractSmallerFromBigger();
        else
            justTakeBigger();
    }

    private boolean isASmallerCharBeforeABigger() {
        return s.length() > 1 && singleCharToInt(s.charAt(0)) < singleCharToInt(s.charAt(1));
    }

    private void subtractSmallerFromBigger() {
        firstNumber = singleCharToInt(s.charAt(1)) - singleCharToInt(s.charAt(0));
        sTail = s.substring(2);
    }

    private void justTakeBigger() {
        firstNumber = singleCharToInt(s.charAt(0));
        sTail = s.substring(1);
    }

    private int singleCharToInt(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
