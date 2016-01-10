package hard.strobogrammaticNumber;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int strobogrammaticInRange(String low, String high) {
        int count = 0;
        if(low == null || low.length() == 0 || high == null || high.length() == 0) {
            return count;
        }

        List<String> results = new ArrayList<>();
        for(int length = low.length(); length <= high.length(); length++) {
            results.addAll(findStrobogrammatic(length));
        }

        for(String result : results) {
            if((result.length() == low.length() && result.compareTo(low) < 0)
                || (result.length() == high.length() && result.compareTo(high) > 0)) {
                continue;
            }
            count++;
        }

        return count;
    }

    private List<String> findStrobogrammatic(int length) {
        List<String> results = new ArrayList<>();

        int i = 0;
        if(length % 2 == 0) {
            results.add("");
        }
        else {
            results.add("0");
            results.add("1");
            results.add("8");
            i++;
        }

        while(i < length) {
            List<String> temp = new ArrayList<>();
            for(String prev : results) {
                if(i + 2 != length) {
                    temp.add("0" + prev + "0");
                }
                temp.add("1" + prev + "1");
                temp.add("6" + prev + "9");
                temp.add("8" + prev + "8");
                temp.add("9" + prev + "6");
            }
            i += 2;
            results = temp;
        }

        return results;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.strobogrammaticInRange("0", "0"));
    }
}
