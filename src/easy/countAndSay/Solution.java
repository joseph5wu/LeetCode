package easy.countAndSay;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 */
public class Solution {
    public String countAndSay(int n) {
        if(n < 1) {
            return "";
        }

        String result = "1";
        int i = 1;
        while(i < n) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for(int j = 1; j < result.length(); j++) {
                if(result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                }
                else {
                    temp.append(count);
                    temp.append(result.charAt(j - 1));
                    count = 1;
                }
            }
            temp.append(count);
            temp.append(result.charAt(result.length() - 1));
            result = temp.toString();
            i++;
        }

        return result;
    }
}
