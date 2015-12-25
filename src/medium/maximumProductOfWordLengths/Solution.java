package medium.maximumProductOfWordLengths;

public class Solution {
    public int maxProduct(String[] words) {
        if(words == null || words.length < 2) {
            return 0;
        }

        // using bits to mark each letter
        int[] wordsBits = new int[words.length];
        int max = 0;
        for(int i = 0; i < words.length; i++) {
            for(char c : words[i].toCharArray()) {
                wordsBits[i] = wordsBits[i] | (1 << (c - 'a'));
            }
        }

        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                // if the and of bits equals 0, these two words are different
                if((wordsBits[i] & wordsBits[j]) == 0) {
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }

        return max;
    }
}
