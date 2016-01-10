package hard.substringwithConcatenationofAllWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>();
        if(s == null || words == null || words.length == 0 || s.length() < words.length * words[0].length()) {
            return results;
        }

        int sLen = s.length();
        int wordCount = words.length;
        int wordLen = words[0].length();
        Map<String, Integer> wordMap = new HashMap<>();
        for(String word : words) {
            if(wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            }
            else {
                wordMap.put(word, 1);
            }
        }

        // 此处为了保证一开始的时候能够使得可以出现每次取一个单词的时候能够取中words里面的,因此循环次数为word长度
        for(int j = 0; j < wordLen; j++) {
            Map<String, Integer> tempMap = new HashMap<>();
            String currentStr = null;
            int count = 0;
            int start = j;
            for(int i = start; i <= sLen - wordLen; i = i + wordLen) {
                currentStr = s.substring(i, i + wordLen);
                if (wordMap.containsKey(currentStr)) {
                    if (tempMap.containsKey(currentStr)) {
                        tempMap.put(currentStr, tempMap.get(currentStr) + 1);
                    } else {
                        tempMap.put(currentStr, 1);
                    }

                    count++;

                    while (tempMap.get(currentStr) > wordMap.get(currentStr)) {
                        String left = s.substring(start, start + wordLen);
                        tempMap.put(left, tempMap.get(left) - 1);
                        count--;
                        start += wordLen;
                    }

                    if (count == wordCount) {
                        results.add(start);
                        // shift right and reset tempMap, count and start point
                        String left = s.substring(start, start + wordLen);
                        tempMap.put(left, tempMap.get(left) - 1);
                        count--;
                        start += wordLen;
                    }
                } else {
                    tempMap.clear();
                    start = i + wordLen;
                    count = 0;
                }
            }
        }


        return results;
    }

    public static void main(String args[]) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = new String[]{"fooo","barr","wing","ding","wing"};
        Solution sol = new Solution();
        System.out.println(sol.findSubstring(s, words));
    }
}
