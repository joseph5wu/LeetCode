package medium.strobogrammaticNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

 Find all strobogrammatic numbers that are of length = n.

 For example,
 Given n = 2, return ["11","69","88","96"].
 */
public class Solution {
    public List<String> findStrobogrammatic(int n) {
        List<String> result = new ArrayList<>();
        if(n < 0) {
            return result;
        }

        int i = 0;
        if(n % 2 == 0) {
            result.add("");
        }
        else {
            result.add("0");
            result.add("1");
            result.add("8");
            i = 1;
        }

        while(i < n) {
            List<String> temp = new ArrayList<>();
            for(String prev : result) {
                if(i + 2 != n) {
                    temp.add("0" + prev + "0");
                }
                temp.add("1" + prev + "1");
                temp.add("6" + prev + "9");
                temp.add("8" + prev + "8");
                temp.add("9" + prev + "6");
            }
            i += 2;
            result = temp;
        }

        return result;
    }
}
