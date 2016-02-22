package facebook.calculator;

import java.util.*;
public class Solution {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                num = num * 10 + (c - '0');
            }
            if (c == '+' || c == '-' || c == '*' || c == '/' || c == '^' || i == s.length() - 1) {
                switch (op) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    case '^':
                        int base = stack.pop();
                        int temp = base;
                        for (int j = 1; j < num; j++) {
                            temp *= base;
                        }
                        stack.push(temp);
                        break;
                    default:
                        break;
                }
                num = 0;
                op = c;
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }

    public static void main(String[] args) {
        System.out.println(calculate(" 3+5^2^2 / 2 "));
    }
}
