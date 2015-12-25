package medium.largestNumber;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return "";
        }

        String[] numsStr = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            numsStr[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;
                // sort in descending order
                return s2.compareTo(s1);
            }
        };
        Arrays.sort(numsStr, comp);

        if(numsStr[0].equals("0")) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(String numStr : numsStr) {
            sb.append(numStr);
        }
        return sb.toString();
    }
}
