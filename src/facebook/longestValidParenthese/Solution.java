package facebook.longestValidParenthese;

import java.util.*;
public class Solution {
    public String removeInvalid(String s) {
        if(s == null || s.length() == 0) {
            return s;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                stack.push(i);
            }
            else {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                }
                else {
                    stack.push(i);
                }
            }
        }

        if(stack.isEmpty()) {
            return s;
        }
        else {
            StringBuilder sb = new StringBuilder();
            int start;
            int end = s.length();
            while(!stack.isEmpty()) {
                start = stack.pop();
                sb.append(s.substring(start + 1, end));
                end = start;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String s = ")(())(";
        System.out.println(sol.removeInvalid(s));
    }
}
