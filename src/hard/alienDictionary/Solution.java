package hard.alienDictionary;

import java.util.*;

public class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0) {
            return "";
        }
        if(words.length == 1) {
            return words[0];
        }

        Map<Character, Set<Character>> graph = buildGraph(words);
        Map<Character, Integer> indegree = computeIndegree(graph);

        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for(Character c : indegree.keySet()) {
            if(indegree.get(c) == 0) {
                queue.add(c);
            }
        }

        while(!queue.isEmpty()) {
            char c = queue.poll();
            sb.append(c);
            for(Character neighbor : graph.get(c)) {
                if(indegree.get(neighbor) == 1) {
                    queue.add(neighbor);
                }
                else {
                    indegree.put(neighbor, indegree.get(neighbor) - 1);
                }
            }
        }

        return sb.length() == indegree.size() ? sb.toString() : "";
    }

    private Map<Character, Set<Character>> buildGraph(String[] words) {
        Map<Character, Set<Character>> graph = new HashMap<>();
        int n = words.length;
        for(int i = 1; i < n; i++) {
            int w1Len = words[i - 1].length();
            int w2Len = words[i].length();
            int len = Math.max(w1Len, w2Len);
            boolean isFound = false;
            for(int j = 0; j < len; j++) {
                char c1 = j < w1Len ? words[i - 1].charAt(j) : ' ';
                if(c1 != ' ' && !graph.containsKey(c1)) {
                    graph.put(c1, new HashSet<Character>());
                }
                char c2 = j < w2Len ? words[i].charAt(j) : ' ';
                if(c2 != ' ' && !graph.containsKey(c2)) {
                    graph.put(c2, new HashSet<Character>());
                }

                if(c1 != ' ' && c2 != ' ' && c1 != c2 && !isFound) {
                    graph.get(c1).add(c2);
                    isFound = true;
                }
            }
        }
        return graph;
    }

    private Map<Character, Integer> computeIndegree(Map<Character, Set<Character>> graph) {
        Map<Character, Integer> indegree = new HashMap<>();
        for(Character key : graph.keySet()) {
            if(!indegree.containsKey(key)) {
                indegree.put(key, 0);
            }
            for(Character neighbor : graph.get(key)) {
                if(!indegree.containsKey(neighbor)) {
                    indegree.put(neighbor, 1);
                }
                else {
                    indegree.put(neighbor, indegree.get(neighbor) + 1);
                }
            }
        }

        return indegree;
    }
}
