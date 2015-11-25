package hard.expressionAddOperators;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string that contains only digits 0-9 and a target value,
 * return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
 */
public class Solution {
    private List<String> result = null;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null || num.length() == 0) {
            return result;
        }

        for(int i = 1; i <= num.length(); i++) {
            if(i >= 2 && num.charAt(0) == '0') {
                continue;
            }
            long current = Long.parseLong(num.substring(0, i));
            recursive(num.substring(i), num.substring(0, i), (long) target, 0, current, true);
        }

        return result;
    }

    private void recursive(String s, String trace, long target, long pre, long current, boolean positive) {
        long total = positive ? pre + current : pre - current;
        if(s.length() == 0) {
            if(total == target) {
                result.add(trace);
            }
            return;
        }

        for(int i = 1; i <= s.length(); i++) {
            if(i >= 2 && s.charAt(0) == '0') {
                continue;
            }

            long number = Long.parseLong(s.substring(0, i));
            recursive(s.substring(i), trace + "+" + number, target, total, number, true);
            recursive(s.substring(i), trace + "-" + number, target, total, number, false);
            recursive(s.substring(i), trace + "*" + number, target, pre, current * number, positive);
        }
    }
}
