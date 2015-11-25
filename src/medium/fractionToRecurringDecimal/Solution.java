package medium.fractionToRecurringDecimal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator == 0) {
            return "0";
        }
        if(denominator == 0) {
            return "";
        }

        long num = numerator, den = denominator;
        boolean isNeg = false;
        if(num < 0) {
            num = -num;
            isNeg = !isNeg;
        }
        if(den < 0) {
            den = -den;
            isNeg = !isNeg;
        }

        StringBuilder result = new StringBuilder();
        long quotient = num / den;
        long remain = num - den * quotient;
        if(isNeg) {
            result.append("-");
        }
        result.append(quotient);
        if(remain != 0) {
            result.append(".");
            Map<Long, Integer> remainMap = new HashMap<>();
            while(remain != 0) {
                if(!remainMap.containsKey(remain)) {
                    remainMap.put(remain, result.length());
                    num = remain * 10;
                    quotient = num / den;
                    remain = num % den;
                    result.append(quotient);
                }
                else {
                    result.insert(remainMap.get(remain), "(");
                    result.append(")");
                    break;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        int num = -1;
        int den = -2147483648;
        Solution sol = new Solution();
        System.out.println(sol.fractionToDecimal(num, den));
    }
}
