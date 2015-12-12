package medium.groupAnagrams;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> results = new ArrayList<>();
        if(strs == null || strs.length == 0) {
            return results;
        }

        Map<String, List<String>> map = new HashMap<>();
        Arrays.sort(strs);
        for(String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }

            map.get(key).add(str);
        }

        for(String key : map.keySet()) {
            results.add(map.get(key));
        }

        return results;
    }
}
