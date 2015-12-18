package medium.differentWaysToAddParentheses;

import java.util.*;

public class Solution {
    Set<Character> operators = new HashSet<>(Arrays.asList('+', '-', '*'));

    public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> cache = new HashMap<>();
        return helper(input, cache);
    }

    private List<Integer> helper(String input, Map<String, List<Integer>> cache) {
        if(cache.containsKey(input)) {
            return cache.get(input);
        }

        List<Integer> results = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            if(!operators.contains(input.charAt(i))) {
                continue;
            }

            char operator = input.charAt(i);
            List<Integer> left = helper(input.substring(0, i), cache);
            List<Integer> right = helper(input.substring(i + 1), cache);

            for(Integer leftValue : left) {
                for(Integer rightValue : right) {
                    if(operator == '+') {
                        results.add(leftValue + rightValue);
                    }
                    else if(operator == '-') {
                        results.add(leftValue - rightValue);
                    }
                    else if(operator == '*') {
                        results.add(leftValue * rightValue);
                    }
                }
            }
        }
        // number only
        if(results.size() == 0) {
            results.add(Integer.valueOf(input));
        }

        cache.put(input, results);
        return results;
    }
}
