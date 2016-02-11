package amazon.wordLadder;

import java.util.*;
/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

    public class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            List<List<String>> results = new ArrayList<>();
            if(beginWord == null || beginWord.length() == 0 || endWord == null || endWord.length() == 0) {
                return results;
            }

            wordList.remove(beginWord);
            wordList.add(endWord);
            Map<String, List<String>> neighbors = new HashMap<>();
            neighbors.put(beginWord, new ArrayList<>());
            Map<String, Integer> visited = new HashMap<>(); // store those visited word

            // using bfs to find the shortest steps to endWord
            bfs(beginWord, endWord, wordList, neighbors, visited);
            // using dfs to generate the path
            dfs(beginWord, endWord, neighbors, new ArrayList<>(), results);
            System.out.println(neighbors);
            System.out.println(visited);
            return results;
        }

        private void dfs(String word, String endWord, Map<String, List<String>> neighbors, List<String> path, List<List<String>> results) {
            path.add(word);
            if(endWord.equals(word)) {
                results.add(new ArrayList<>(path));
            }
            else {
                if(neighbors.containsKey(word)) {
                    for(String neighbor : neighbors.get(word)) {
                        dfs(neighbor, endWord, neighbors, path, results);
                    }
                }
            }
            path.remove(path.size() - 1);
        }

        private void bfs(String beginWord, String endWord, Set<String> wordList, Map<String, List<String>> neighbors, Map<String, Integer> visited) {
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            visited.put(beginWord, 0);
            while(!queue.isEmpty()) {
                int size = queue.size();
                boolean found = false;
                for(int i = 0; i < size; i++) {
                    String word = queue.poll();
                    int level = visited.get(word);
                    List<String> next = getNeighbors(word, wordList);
                    neighbors.put(word, new ArrayList<>());
                    for(String neighbor : next) {
                        if(!visited.containsKey(neighbor) || visited.get(neighbor) == level + 1) {
                            neighbors.get(word).add(neighbor); // consider move to the next line
                            visited.put(neighbor, level + 1);
                            if(endWord.equals(neighbor)) {
                                found = true;
                            }
                            else {
                                queue.add(neighbor);
                            }
                        }
                    }
                }
                if(found) {
                    break;
                }
            }
        }

        private List<String> getNeighbors(String word, Set<String> wordList) {
            char[] chars = word.toCharArray();
            List<String> results = new ArrayList<>();
            for(int i = 0; i < chars.length; i++) {
                char prev = chars[i];
                for(char c = 'a'; c <= 'z'; c++) {
                    if(c == prev) {
                        continue;
                    }
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(wordList.contains(newWord)) {
                        results.add(newWord);
                    }
                }
                chars[i] = prev;
            }
            return results;
        }

        public static void main(String[] args) {
            Set<String> wordList = new HashSet<>();
//            String[] words = {"hot","dot","dog","lot","log"};
            String[] words = {"a", "b", "c"};
            for(String word : words) {
                wordList.add(word);
            }

            Solution sol = new Solution();
            List<List<String>> results = sol.findLadders("a", "c", wordList);
            System.out.println(results);
        }
    }


    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }
