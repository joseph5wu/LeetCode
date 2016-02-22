package facebook.addHex;

import java.util.Arrays;

public class Solution {
    public static String add(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        int pos1 = len1 - 1, pos2 = len2 - 1;
        int val1 = 0, val2 = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        while(pos1 >= 0 || pos2 >= 0) {
            val1 = pos1 >= 0 ? getIntVal(s1.charAt(pos1--)) : 0;
            val2 = pos2 >= 0 ? getIntVal(s2.charAt(pos2--)) : 0;
            sum += val1 + val2;
            sb.append(getChar(sum % 16));
            sum = sum / 16;
        }
        if(sum != 0) {
            sb.append(sum);
        }

        String result = sb.reverse().toString();
        int nonZeroIndex = 0;
        while(nonZeroIndex < sb.length() && result.charAt(nonZeroIndex) == '0') {
            nonZeroIndex++;
        }
        if(nonZeroIndex == 0) {
            return result;
        }
        else if(nonZeroIndex == result.length()) {
            return "0";
        }
        else {
            return result.substring(nonZeroIndex);
        }
    }

    private static int getIntVal(char c) {
        if(c >= '0' && c <= '9') {
            return c - '0';
        }
        if(c >= 'A' && c <= 'F') {
            return c - 'A' + 10;
        }
        if(c >= 'a' && c <= 'f') {
            return c - 'a' + 10;
        }
        return 0;
    }

    private static char getChar(int i) {
        if(i >= 0 && i <= 9) {
            return (char) ('0' + i);
        }
        if(i <= 15) {
            return (char) ('A' + i - 10);
        }
        return '0';
    }

    public static int[] multiply(int[] num1, int[] num2) {
        int[] results = new int[num1.length + num2.length];
        for(int i = num1.length - 1; i >= 0; i--) {
            for(int j = num2.length - 1; j >= 0; j--) {
                results[i + j + 1] += num1[i] * num2[j];
            }
        }

        // adjust the results
        int sum = 0;
        for(int i = results.length - 1; i >= 0; i--) {
            sum += results[i];
            results[i] = sum % 10;
            sum = sum / 10;
        }

        // skip zero in the beginning
        int nonZeroPos = 0;
        while(nonZeroPos < results.length && results[nonZeroPos] == 0) {
            nonZeroPos++;
        }
        if(nonZeroPos == results.length) {
            results = new int[1];
        }
        else if(nonZeroPos != 0) {
            int[] temp = new int[results.length - nonZeroPos];
            int i = 0;
            while(nonZeroPos < results.length) {
                temp[i++] = results[nonZeroPos++];
            }
            results = temp;
        }

        return results;
    }

    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] num2 = {4,5,6,7};
        System.out.println(Arrays.toString(multiply(num1, num2)));

        String s1 = "1";
        String s2 = "00ff";
        System.out.println(add(s1, s2));
    }
}
