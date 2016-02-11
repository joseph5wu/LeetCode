package amazon.anagrams;

import java.util.*;
public class Solution {
    public List<String> permute2(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return results;
        }

        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        s = new String(chars);

        boolean[] visited = new boolean[s.length()];
        helper(s, visited, new StringBuilder(), results);
        return results;
    }

    private void helper(String s, boolean[] visited, StringBuilder path, List<String> results) {
        if(path.length() == s.length()) {
            results.add(path.toString());
            return;
        }

        for(int i = 0; i < s.length(); i++) {
            if(!visited[i]) {
                if(i > 0 && visited[i - 1] && s.charAt(i - 1) == s.charAt(i)) {
                    break;
                }

                visited[i] = true;
                path.append(s.charAt(i));
                helper(s, visited, path, results);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }

    public List<String> permute(String s) {
        List<String> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }

        StringBuilder newS = new StringBuilder();
        newS.append(s.charAt(0));
        results.add(newS.toString());
        List<String> temp;
        for (int i = 1; i < s.length(); i++) {
            temp = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                for (String str : results) {
                    StringBuilder sb = new StringBuilder();
                    if (j == 0) {
                        sb.append(s.charAt(i)).append(str);
                    } else if (j == i) {
                        sb.append(str).append(s.charAt(i));
                    } else {
                        sb.append(str.substring(0, j)).append(s.charAt(i)).append(str.substring(j));
                    }

                    temp.add(sb.toString());
                }
            }
            results = temp;
        }

        return results;
    }

    public static void main(String[] args) {
        String joe = "joe";
        Solution sol = new Solution();
        List<String> results = sol.permute(joe);
        System.out.println(results.size());
        for (String result : results) {
            System.out.println(result);
        }
    }
}
