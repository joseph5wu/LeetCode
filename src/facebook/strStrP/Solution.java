package facebook.strStrP;

import java.util.*;
public class Solution {
    public boolean strStrP(String a, String b) {
        if (a == null || b == null || a.length() < b.length()) {
            return false;
        }

        // using a map to store the times of every char in b
        Map<Character, Integer> bMap = new HashMap<>();
        for (int i = 0; i < b.length(); i++) {
            if (!bMap.containsKey(b.charAt(i))) {
                bMap.put(b.charAt(i), 1);
            } else {
                bMap.put(b.charAt(i), bMap.get(b.charAt(i)) + 1);
            }
        }

        for (int i = 0; i <= a.length() - b.length(); i++) {
            // create a temp map from bMap to compare
            Map<Character, Integer> temp = new HashMap<>(bMap);
            System.out.println(temp);
            for (int j = 0; j < b.length(); j++) {
                char c = a.charAt(i + j);
                if (temp.containsKey(c)) {
                    if (temp.get(c) <= 0) {
                        break;
                    } else if (temp.get(c) == 1) {
                        temp.remove(c);
                    } else {
                        temp.put(c, temp.get(c) - 1);
                    }
                } else {
                    break;
                }
            }
            if (temp.isEmpty()) {
                return true;
            }
        }

        return false;
    }

    public boolean strStrP2(String a, String b) {
        if(a == null || b == null || a.length() < b.length()) {
            return false;
        }

        // using a map to store the times of every char in b
        Map<Character, Integer> bMap = new HashMap<>();
        for(int i = 0; i < b.length(); i++) {
            if(!bMap.containsKey(b.charAt(i))) {
                bMap.put(b.charAt(i), 1);
            }
            else {
                bMap.put(b.charAt(i), bMap.get(b.charAt(i)) + 1);
            }
        }

        int count = 0;
        int moves = 0;
        int i = 0, j = 0;
        while(i < a.length()) {
            // if moves != 0, need to move j
            while(moves-- > 0) {
                char c = a.charAt(j++);
                if(bMap.containsKey(c)) {
                    bMap.put(c, bMap.get(c) + 1);
                }
            }

            char c = a.charAt(i);
            if(bMap.containsKey(c)) {
                if(bMap.get(c) > 0) {
                    count++;
                    if(count == b.length()) {
                        return true;
                    }
                    bMap.put(c, bMap.get(c) - 1);
                    i++;
                }
                else {
                    // let j moves 1 step
                    moves = 1;
                }
            }
            else {
                // meet other char, need to reset count
                count = 0;
                i++;
                moves = i - j;
            }
        }

        return false;
    }


    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.strStrP2("helilleo", "lel"));
    }
}