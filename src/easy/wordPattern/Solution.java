package easy.wordPattern;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

     Examples:
     pattern = "abba", str = "dog cat cat dog" should return true.
     pattern = "abba", str = "dog cat cat fish" should return false.
     pattern = "aaaa", str = "dog cat cat dog" should return false.
     pattern = "abba", str = "dog dog dog dog" should return false.
     Notes:
     You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        if(pattern == null ||str == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        String[] words = str.split(" ");
        if(words.length != pattern.length()) {
            return false;
        }
        Map<String, Integer> wordIndex = new HashMap<>();
        Map<Character, Integer> patternIndex = new HashMap<>();
        for(int i = 0; i < words.length; i++) {
            // 使用hashmap的put返回旧值的逻辑判断word/pattern是不是一致
            if(!Objects.equals(wordIndex.put(words[i], i), patternIndex.put(pattern.charAt(i), i))) {
               return false;
            }
        }

        return true;
    }
}
