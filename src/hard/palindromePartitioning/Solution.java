package hard.palindromePartitioning;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return results;
        }

        partition(results, new ArrayList<String>(), s, 0);
        return results;
    }

    private void partition(List<List<String>> results, List<String> sol, String s, int start) {
        if(start == s.length()) {
            List<String> newSol = new ArrayList<String>(sol);
            results.add(newSol);
            return;
        }
        for(int i = start; i < s.length(); i++) {
            String temp = s.substring(start, i + 1);
            if(isPalindrome(temp)) {
                sol.add(temp);
                partition(results, sol, s, i + 1);
                sol.remove(sol.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    public List<List<String>> partition2(String s) {
        if(s == null || s.length() == 0) {
            return new ArrayList<List<String>>();
        }

        int n = s.length();
        List<List<String>>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        dp[0].add(new ArrayList<>());
        boolean[][] isPalindrome = new boolean[n][n];

        for(int right = 0; right < n; right++) {
            List<List<String>> res = new ArrayList<>();
            for(int left = 0; left <= right; left ++) {
                if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    isPalindrome[left][right] = true;
                    for(List l : dp[left]) {
                        List<String> list = new ArrayList(l);
                        list.add(s.substring(left, right + 1));
                        res.add(list);
                    }
                }
            }
            dp[right + 1] = res;
        }

        return dp[n];
    }

    public int minCut(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        int[] dp = new int[n];
        for(int right = 0; right < n; right++) {
            dp[right] = right;
            isPalindrome[right][right] = true;
            for(int left = 0; left <= right; left++) {
                if(s.charAt(left) == s.charAt(right) && (right - left <= 2 || isPalindrome[left + 1][right - 1])) {
                    if(left == 0) {
                        dp[right] = 0;
                        break;
                    }
                    else {
                        isPalindrome[left][right] = true;
                        dp[right] = Math.min(dp[left - 1] + 1, dp[right]);
                    }
                }
            }
        }
        return dp[n - 1];
    }
}
