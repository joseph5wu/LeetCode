package easy.longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        // 找出最短的单词长度
        int shortestLength = Integer.MAX_VALUE;
        for(int i = 0; i < strs.length; i++) {
            if(shortestLength > strs[i].length()) {
                shortestLength = strs[i].length();
            }
        }
        if(shortestLength == 0) {
            return "";
        }

        for (int i = 0; i < shortestLength; i++) {
            char prev = strs[0].charAt(i);
            for(int j = 1; j < strs.length; j++) {
                if(prev != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, shortestLength);
    }
}
