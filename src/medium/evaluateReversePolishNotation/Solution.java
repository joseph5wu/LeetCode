package medium.evaluateReversePolishNotation;

import java.util.Stack;

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for(String token : tokens) {
            int a = 0, b = 0;
            switch (token) {
                case "+":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a + b);
                    break;
                case "-":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a - b);
                    break;
                case "*":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a * b);
                    break;
                case "/":
                    b = stack.pop();
                    a = stack.pop();
                    stack.push(a / b);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"0","3","/"};
        Solution sol = new Solution();
        System.out.println(sol.evalRPN(tokens));
    }
}
