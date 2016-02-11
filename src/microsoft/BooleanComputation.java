package microsoft;

import java.util.Stack;

public class BooleanComputation {
    public boolean calculate(String word) {
        boolean result = true;
        if(word == null || word.length() == 0) {
            return result;
        }

        Stack<Boolean> stack = new Stack<>();
        boolean temp = true;
        boolean sign = true;
        int i = 0;
        while(i < word.length()) {
            char c = word.charAt(i);
            if(c == 't') {
                // get the next 3 chars to form true
                if(word.substring(i, i + 4).equals("true")) {
                    temp = true;
                }
                else {
                    throw new IllegalArgumentException("invalid format");
                }
                i = i + 4;
            }
            else if(c == 'f') {
                // get the next 4 chars to form false
                if(word.substring(i, i + 5).equals("false")) {
                    temp = false;
                }
                else {
                    throw new IllegalArgumentException("invalid format");
                }
                i = i + 5;
            }
            else if(c == '&' || c == '|') {
                // get the next char to form &&
                if(word.substring(i, i + 2).equals("&&") || word.substring(i, i + 2).equals("||")) {
                    result = sign ? result && temp : result || temp;
                    sign = c == '&';
                }
                else {
                    throw new IllegalArgumentException("invalid format");
                }
                i = i + 2;
            }
            else if(c == '(') {
                stack.push(result);
                stack.push(sign);
                result = true;
                sign = true;
                temp = true;
                i++;
            }
            else if(c == ')') {
                result = sign ? result && temp : result || temp;
                sign = stack.pop();
                temp = stack.pop();
                result = sign ? result && temp : result || temp;
                sign = true;
                temp = true;
                i++;
            }
            else if(c == ' '){
                i++;
            }
            else {
                throw new IllegalArgumentException("invalid format");
            }
        }

        result = sign ? result && temp : result || temp;
        return result;
    }

    public static void main(String[] args) {
        String word = "true&&(true||false)||false&&false";
        BooleanComputation sol = new BooleanComputation();
        System.out.println(sol.calculate(word));
    }
}
