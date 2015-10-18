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

    public String countAndSay2(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        String prev = "1";
        if(n == 1) {
            return prev;
        }
        int count = 0;
        for(int i = 1; i < n; i++) {
            int j = 0;
            StringBuilder sb = new StringBuilder();
            while(j < prev.length()) {
                if(j == 0) {
                    count = 1;
                }
                else {
                    if(prev.charAt(j - 1) == prev.charAt(j)) {
                        count++;
                    }
                    else {
                        sb.append(count);
                        sb.append(prev.charAt(j - 1));
                        count = 1;
                    }
                }
                j++;
            }
            sb.append(count);
            sb.append(prev.charAt(prev.length() - 1));

            prev = sb.toString();
        }

        return prev;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String result1 = sol.countAndSay(25);
        String result2 = sol.countAndSay2(25);
        System.out.println(result1.equals(result2));
    }
}
