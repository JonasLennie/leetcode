public class Atoi {
    private int start;
    private int end;
    private boolean isPositive;
    private char[] ch;

    private void readIn(String s) {
        ch = s.toCharArray();
    }

    private void getStart() {
        start = 0;

        for (char c : ch) {
            if (c == ' ') {
                start ++;
            } else {
                return;
            }
        }
    }

    private void getPositive() {
        isPositive = true;
        if (start < ch.length && ch[start] == '+') {
            start ++;
        } else if (start < ch.length && ch[start] == '-') {
            start ++;
            isPositive = false;
        }
    }

    private void getEnd(){
        end = start;

        for (int i = start; i < ch.length; i ++) {
            if(Character.isDigit(ch[i])) {
                end ++;
            } else {
                return;
            }
        }
    }

    private int parseInt() {
        int result = 0;

        for (int i = end - 1; i >= start; i --) {
            result += (isPositive) ?
                    Character.getNumericValue(ch[i]) * Math.pow(10, (end - i - 1))
                    : Character.getNumericValue(ch[i]) * Math.pow(10, (end - i - 1)) * -1;
        }

        return result;
    }

    public int myAtoi(String s) {
        readIn(s);
        getStart();
        System.out.printf("Start: %d\n", start);
        getPositive();
        getEnd();

        System.out.printf("Start: %d, end: %d\n", start, end);

        return parseInt();
    }
}
