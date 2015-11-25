package easy.groupShiftedStrings;

import java.util.*;

public class Solution {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> results = new ArrayList<>();
        if(strings == null || strings.length == 0) {
            return results;
        }

        Map<String, List<String>> map = new HashMap<>();
        for(String string : strings) {
            String shifted = shift(string);
            if(!map.containsKey(shifted)) {
                map.put(shifted, new ArrayList<String>());
            }
            map.get(shifted).add(string);
        }

        for(String shifted : map.keySet()) {
            List<String> temp = map.get(shifted);
            Collections.sort(temp);
            results.add(temp);
        }

        return results;
    }

    private String shift(String word) {
        word = word.trim();
        if(word.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int diff = word.charAt(0) - 'a';
        sb.append('a');
        for(int i = 1; i < word.length(); i++) {
            char temp = word.charAt(i);
            if(temp - diff >= 'a') {
                sb.append(temp - diff);
            }
            else{
                sb.append(temp + 26 - diff);
            }
        }

        return sb.toString();
    }
}
