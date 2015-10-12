package easy.romanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.

 Input is guaranteed to be within the range from 1 to 3999.
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> dict = new HashMap<>(7);
        dict.put('M', 1000);
        dict.put('D', 500);
        dict.put('C', 100);
        dict.put('L', 50);
        dict.put('X', 10);
        dict.put('V', 5);
        dict.put('I', 1);

        // 遍历给定String s中的字符，在总数中加上每个字符代表的数字，
        // 如果字符比上一个字符所代表的数字大，则在总数中减去两倍的上一个字符所代表的数字。
        int result = 0;
        int current = 0;
        int last = 0;
        for(int i = 0; i < s.length(); i++) {
            current = dict.get(s.charAt(i));
            result += current;

            if(i == 0) {
                last = current;
                continue;
            }

            if(current > last) {
                result -= last * 2;
            }
            last =current;
        }

        return result;
    }
}
