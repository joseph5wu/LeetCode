package easy.stringToInteger;

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }

        str = str.trim();
        boolean positive = true;
        int i = 0;
        if(str.charAt(i) == '-') {
            positive = false;
            i++;
        }
        else if(str.charAt(i) == '+') {
            i++;
        }

        double result = 0;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i++) - '0');
        }

        if(!positive) {
            result = -result;
        }
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        else if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        else {
            return (int)result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.myAtoi("9223372036854775809"));
    }
}
