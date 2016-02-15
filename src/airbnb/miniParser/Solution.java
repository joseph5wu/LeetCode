package airbnb.miniParser;

import java.util.*;
public class Solution {
    public static void miniParser(String str) {
        Stack<List<Object>> listStack = new Stack<>();
        int prev = 0;
        List<Object> results = null;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                listStack.push(new ArrayList<Object>());
                prev = i + 1;
            } else if (str.charAt(i) == ',' || str.charAt(i) == ']') {
                if (prev != i) {
                    if (!listStack.isEmpty()) {
                        listStack.peek().add(Integer.valueOf(str.substring(prev, i)));
                    }
                }

                if (str.charAt(i) == ']') {
                    results = listStack.pop();
                    if (!listStack.isEmpty()) {
                        listStack.peek().add(results);
                    }
                }

                prev = i + 1;
            }
        }

        if (prev != str.length()) {
            System.out.println(Integer.valueOf(str.substring(prev)));
        } else {
            System.out.println(results);
        }
    }

    public static void main(String[] args) {
        miniParser("[123,456,[788,799,833],[[]],10,[]]");
        miniParser("324");
    }
}
