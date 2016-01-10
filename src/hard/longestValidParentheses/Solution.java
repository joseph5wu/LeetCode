package hard.longestValidParentheses;

import java.util.Stack;

public class Solution {
    public int longestValidParentheses(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            }
            else {
                if(!stack.isEmpty()) {
                    if(s.charAt(stack.peek()) == '(') {
                        stack.pop();
                    }
                    else {
                        stack.push(i);
                    }
                }
                else {
                    stack.push(i);
                }
            }
        }

        if(stack.isEmpty()) {
            return s.length();
        }
        else {
            int a = s.length(), b = 0;
            int result = 0;
            while(!stack.isEmpty()) {
                b = stack.pop();
                result = Math.max(result, a - b - 1);
                a = b;
            }
            return Math.max(result, a);
        }
    }
}
