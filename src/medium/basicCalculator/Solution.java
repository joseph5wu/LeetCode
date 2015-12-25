package medium.basicCalculator;

import java.util.Stack;
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

    public int calculate2(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        char sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                temp = temp * 10 + (c - '0');
            }
            if(c == '+' || c == '-' || c == '*' || c == '/' || i == s.length() - 1) {
                switch(sign){
                    case '+':
                        stack.push(temp);
                        break;
                    case '-':
                        stack.push(-temp);
                        break;
                    case '*':
                        stack.push(stack.pop() * temp);
                        break;
                    case '/':
                        stack.push(stack.pop() / temp);
                        break;
                    default:
                        break;
                }
                sign = c;
                temp = 0;
            }
        }

        int total = 0;
        for(int num : stack) {
            total += num;
        }
        return total;

    }
}
