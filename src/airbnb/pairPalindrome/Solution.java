package airbnb.pairPalindrome;

import java.util.*;
public class Solution {
    public static List<List<String>> findPalindrome(List<String> words) {
        List<List<String>> results = new ArrayList<>();

        Set<String> wordSet = new HashSet<>();
        for (String word : words) {
            wordSet.add(word);
        }

        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                String suffix = reverse(word, j, word.length() - 1);
                if (isPalindrome(word, 0, j - 1) && wordSet.contains(suffix) && !word.equals(suffix)) {
                    List<String> pair = new ArrayList<>();
                    pair.add(suffix);
                    pair.add(word);
                    results.add(pair);
                }
            }

            for (int j = word.length() - 1; j >= 0; j--) {
                String prefix = reverse(word, 0, j);
                if (isPalindrome(word, j + 1, word.length() - 1) && wordSet.contains(prefix) && !word.equals(prefix)) {
                    List<String> pair = new ArrayList<>();
                    pair.add(word);
                    pair.add(prefix);
                    results.add(pair);
                }
            }

            wordSet.remove(word);

        }

        return results;
    }

    private static String reverse(String word, int start, int end) {
        StringBuilder sb = new StringBuilder();
        while (start <= end) {
            sb.append(word.charAt(end--));
        }
        return sb.toString();
    }

    private static boolean isPalindrome(String word, int start, int end) {
        while (start < end) {
            if (word.charAt(start) != word.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("ababc");
        words.add("babc");
        words.add("cbab");
        words.add("cb");
        words.add("bc");
        words.add("baba");
        words.add("cbaba");
        words.add("c");
        List<List<String>> results = findPalindrome(words);
        System.out.println(results);
    }
}
