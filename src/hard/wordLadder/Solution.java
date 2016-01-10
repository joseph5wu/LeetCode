package hard.wordLadder;

import java.util.*;

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


    private List<String> neighbors(String word, Set<String> dict) {
        List<String> results = new ArrayList<>();
        char[] wordChars = word.toCharArray();
        for(int i = 0; i < wordChars.length; i++) {
            char original = wordChars[i];
            for(char c = 'a'; c <= 'z'; c++) {
                if(c != original) {
                    wordChars[i] = c;
                    String newWord = new String(wordChars);
                    if(dict.contains(newWord)) {
                        results.add(newWord);
                    }
                }
            }
            wordChars[i] = original;
        }
        return results;
    }

    private void dfs(List<List<String>> results, List<String> path, Map<String, Set<String>> parents, String word, String startWord) {
        // end case
        if(word.equals(startWord)) {
            List<String> newPath = new ArrayList<>(path);
            results.add(newPath);
            return;
        }

        // edge cased
        if(!parents.containsKey(word)) {
            return;
        }

        // recursion
        for(String neighbor : parents.get(word)) {
            path.add(0, neighbor);
            dfs(results, path, parents, neighbor, startWord);
            path.remove(0);
        }
    }

    public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.length() == 0 || beginWord.length() != endWord.length()) {
            throw new IllegalArgumentException("Invalid input");
        }

        List<List<String>> results = new ArrayList<>();
        Map<String, Set<String>> parents = new HashMap<>();

        // initiate
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        wordList.remove(beginWord);
        wordList.add(endWord);

        // bfs construct the tree
        boolean found = false;
        while(!found && !queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                String word = queue.poll();
                for(String neighbor : neighbors(word, wordList)) {
                    queue.add(neighbor);
                    Set<String> parentList = parents.get(neighbor);
                    if(parentList == null) {
                        parentList = new HashSet<>();
                        parents.put(neighbor, parentList);
                    }
                    parentList.add(word);

                    if(neighbor.equals(endWord)) {
                        found = true;
                    }
                }
            }

            wordList.removeAll(queue);
        }

        // dfs construct the result list
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(results, path, parents, endWord, beginWord);

        return results;
    }
}
