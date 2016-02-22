package facebook.commonSubstring;

import java.util.*;
public class Solution {
    public List<String> commonSubstring2(String s1, String s2, int n) {
        List<String> results = new ArrayList<>();
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return results;
        }

        int[] dp = new int[s2.length()];
        for(int i = 0; i < s2.length(); i++) {
            if(s1.charAt(0) == s2.charAt(i)) {
                dp[i] = 1;
                if(dp[i] >= n) {
                    results.add(s1.substring(0, 1));
                }
            }
        }

        // using this to mark before updated dp[i-1]
        for(int i = 1; i < s1.length(); i++) {
            int prev = 0;
            for(int j = 0; j < s2.length(); j++) {
                int temp = dp[j];
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[j] = prev + 1;
                    if(dp[j] >= n) {
                        int commonSize = dp[j];
                        while(commonSize >= n) {
                            results.add(s2.substring(j - commonSize + 1, j + 1));
                            commonSize--;
                        }
                    }
                }
                else {
                    dp[j] = 0;
                }
                prev = temp;
            }
        }

        return results;

    }


    public List<String> commonSubstring(String s1, String s2, int n) {
        List<String> results = new ArrayList<>();
        if(s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0) {
            return results;
        }

        int[][] dp = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) == s2.charAt(0)) {
                dp[i][0] = 1;
                if(dp[i][0] >= n) {
                    results.add(s2.substring(0, 1));
                }
            }
        }
        for(int i = 0; i < s2.length(); i++) {
            if(s2.charAt(i) == s1.charAt(0)) {
                dp[0][i] = 1;
                if(dp[0][i] >= n) {
                    results.add(s1.substring(0, 1));
                }
            }
        }


        for(int i = 1; i < s1.length(); i++) {
            for(int j = 1; j < s2.length(); j++) {
                if(s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if(dp[i][j] >= n) {
                        int commonSize = dp[i][j];
                        while(commonSize >= n) {
                            results.add(s1.substring(i - commonSize + 1, i + 1));
                            commonSize--;
                        }
                    }
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }

        return results;

    }

    public static void main(String[] args) {
        String s1 = "hellofromtheotherside";
        String s2 = "fromside";
        Solution sol = new Solution();
        List<String> results = sol.commonSubstring(s1, s2, 3);
        for(String result : results) {
            System.out.println(result);
        }
        results = sol.commonSubstring2(s1, s2, 3);
        for(String result : results) {
            System.out.println(result);
        }
    }

}
