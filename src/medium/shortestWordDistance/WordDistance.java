package medium.shortestWordDistance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDistance {
    private Map<String, List<Integer>> map;

    public WordDistance(String[] words) {
        map = new HashMap<>();
        if(words != null && words.length > 0) {
            for(int i = 0; i < words.length; i++) {
                String word = words[i];
                if(!map.containsKey(word)) {
                    map.put(word, new ArrayList<>());
                }
                map.get(word).add(i);
            }
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int distance = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while(i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            if(index1 < index2) {
                distance = Math.min(distance, index2 - index1);
                i++;
            }
            else {
                distance = Math.min(distance, index1 - index2);
                j++;
            }
        }

        return distance;
    }
}
