package hard.wordLadder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() != endWord.length()) {
            return 0;
        }
        if(beginWord.length() == 0 || endWord.length() == 0) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordList.add(endWord);
        int step = 0;
        while(!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String source = queue.poll();
                if(source.equals(endWord)) {
                    return step;
                }
                for(int j = 0; j < source.length(); j++) {
                    char[] chars = source.toCharArray();
                    for(char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String newSource = new String(chars);
                        // avoid replicate
                        if(wordList.contains(newSource)) {
                            wordList.remove(newSource);
                            queue.add(newSource);
                        }
                    }
                }
            }
        }

        return wordList.contains(endWord) ? 0 : step;
    }
}
