package medium.repeatedDNASequences;

import java.util.*;

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() < 10) {
            return results;
        }

        Map<Character, Integer> dnaMap = new HashMap<>();
        dnaMap.put('A', 0);
        dnaMap.put('C', 1);
        dnaMap.put('G', 2);
        dnaMap.put('T', 3);

        Set<Integer> first = new HashSet<>();
        // mark second times to avoid adding to results repeatedly
        Set<Integer> second = new HashSet<>();
        int hash = 0;
        for(int i = 0; i < s.length(); i++) {
            hash = (hash << 2) + dnaMap.get(s.charAt(i));
            if(i >= 9) {
                // get the latest 10 dna codes
                hash = hash & (1 << 20) - 1;
                if(first.contains(hash)) {
                    if(!second.contains(hash)) {
                        second.add(hash);
                        results.add(s.substring(i - 9, i + 1));
                    }
                }
                else {
                    first.add(hash);
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findRepeatedDnaSequences("AAAAAAAAAAA"));
    }
}
