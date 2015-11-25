package easy.flipGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() < 2) {
            return results;
        }

        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                results.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }

        return results;
    }

    public boolean canWin(String s) {
        if(s == null || s.length() < 2) {
            return false;
        }

        List<String> ways = new ArrayList<>();
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == '+' && s.charAt(i - 1) == '+') {
                ways.add(s.substring(0, i - 1) + "--" + s.substring(i + 1));
            }
        }

        for(String way : ways) {
            if(!canWin(way)) {
                return true;
            }
        }
        return false;
    }

    public boolean canWin2(String s) {
        if(s == null || s.length() < 2) {
            return false;
        }
        Map<String, Boolean> results = new HashMap<>();
        return helper(s, results);
    }

    private boolean helper(String s, Map<String, Boolean> results) {
        if(results.containsKey(s)) {
            return results.get(s);
        }

        for(int i = 0; i < s.length() - 1; i++) {
            if(s.charAt(i) == '+' && s.charAt(i + 1) == '+') {
                String tmp = s.substring(0, i) + "--" + s.substring(i + 2);
                if(!helper(tmp, results)) {
                    results.put(s, true);
                    return true;
                }
            }
        }
        results.put(s, false);
        return false;
    }

    public static void main(String[] args) {
        String s = "joseph";
        System.out.println(s.substring(s.length()));
    }
}
