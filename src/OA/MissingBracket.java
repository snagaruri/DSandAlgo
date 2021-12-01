package OA;

public class MissingBracket {
    public static void main(String[] args) {
        System.out.println(fillMissingBrackets("(?]["));
    }
    
    public static int fillMissingBrackets(String brackets) {

        int count = 0;

        int squareBracketsOpen = 0;
        int squareBracketsClose = 0;
        int bracketsOpen = 0;
        int bracketsClose = 0;
        int wildCards = 0;

        for (char c : brackets.toCharArray()) {
            if (c == '[') squareBracketsOpen++;
            else if (c == ']') squareBracketsClose++;
            else if (c == '(') bracketsOpen++;
            else if (c == ')') bracketsClose++;
            else if (c == '?') wildCards++;
            else return -1;
        }


        int sboSoFar = 0;
        int sbcSoFar = 0;
        int boSoFar = 0;
        int bcSoFar = 0;
        int wcSoFar = 0;

        for (int i = 0; i < brackets.length()-1; i++) {
            char c = brackets.charAt(i);
            if (c == '[') sboSoFar++;
            else if (c == ']') sbcSoFar++;
            else if (c == '(') boSoFar++;
            else if (c == ')') bcSoFar++;
            else if (c == '?') wcSoFar++;

            if (isBalanced(sboSoFar, sbcSoFar, boSoFar, bcSoFar, wcSoFar) &&
                    isBalanced(squareBracketsOpen - sboSoFar, squareBracketsClose - sbcSoFar,
                            bracketsOpen - boSoFar, bracketsClose - bcSoFar, wildCards - wcSoFar)) {
                count++;
                System.out.println(i);
            }
        }

        return count;
    }

    public static boolean isBalanced(int squareOpen, int squareClose, int open, int close, int wildcards) {
        int extraWc = wildcards - Math.abs(open - close);
        int remaining = (extraWc - Math.abs(squareOpen - squareClose));

        if (remaining >=0 && remaining%2 == 0 ) return true;
        return false;
    }

}

