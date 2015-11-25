package medium.basicCalculator;

import java.util.StringTokenizer;

public class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        return calculate(new StringTokenizer(s, " +-()", true));
    }

    private int calculate(StringTokenizer st) {
        int total = 0;
        boolean plus = true;
        int temp = 0;
        while(st.hasMoreTokens()) {
            String next = st.nextToken();
            switch(next) {
                case "(":
                    temp = calculate(st);
                    total += (plus ? temp : -temp);
                    break;
                case ")":
                    return total;
                case "+":
                    plus = true;
                    break;
                case "-":
                    plus = false;
                    break;
                case " ":
                    break;
                default:
                    temp = Integer.parseInt(next);
                    total += (plus ? temp : -temp);
                    break;
            }
        }

        return total;
    }
}
