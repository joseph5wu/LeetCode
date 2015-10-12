package easy.validParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> parentheses = new HashMap<>();
        parentheses.put('(', ')');
        parentheses.put('[', ']');
        parentheses.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(parentheses.keySet().contains(current)) {
                stack.push(current);
            }
            else if(parentheses.values().contains(current)) {
                if(!stack.isEmpty() && parentheses.get(stack.peek()) == current) {
                    stack.pop();
                }
                else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
