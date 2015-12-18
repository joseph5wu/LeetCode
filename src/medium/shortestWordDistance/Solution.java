package medium.shortestWordDistance;

public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if(word1 == null || word2 == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1) || words[i].equals(word2)) {
                if(index != -1 && !words[index].equals(words[i])) {
                    min = Math.min(min, i - index);
                }
                index = i;
            }
        }

        return min;
    }

    public int shortestWordDistance(String[] words, String word1, String word2) {
        if(word1 == null || word2 == null || words == null || words.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int index = -1;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(word1) || words[i].equals(word2)) {
                if(index != -1 && ((!word1.equals(word2) && !words[index].equals(words[i])) || (word1.equals(word2)))) {
                    min = Math.min(min, i - index);
                }
                index = i;
            }
        }

        return min;
    }
}
