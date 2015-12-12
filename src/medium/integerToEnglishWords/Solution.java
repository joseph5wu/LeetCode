package medium.integerToEnglishWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Integer, String> digitWordMap = new HashMap<>();

    public Solution() {
        digitWordMap.put(0, "");
        digitWordMap.put(1, "One");
        digitWordMap.put(2, "Two");
        digitWordMap.put(3, "Three");
        digitWordMap.put(4, "Four");
        digitWordMap.put(5, "Five");
        digitWordMap.put(6, "Six");
        digitWordMap.put(7, "Seven");
        digitWordMap.put(8, "Eight");
        digitWordMap.put(9, "Nine");
        digitWordMap.put(10, "Ten");
        digitWordMap.put(11, "Eleven");
        digitWordMap.put(12, "Twelve");
        digitWordMap.put(13, "Thirteen");
        digitWordMap.put(14, "Fourteen");
        digitWordMap.put(15, "Fifteen");
        digitWordMap.put(16, "Sixteen");
        digitWordMap.put(17, "Seventeen");
        digitWordMap.put(18, "Eighteen");
        digitWordMap.put(19, "Nineteen");
        digitWordMap.put(20, "Twenty");
        digitWordMap.put(30, "Thirty");
        digitWordMap.put(40, "Forty");
        digitWordMap.put(50, "Fifty");
        digitWordMap.put(60, "Sixty");
        digitWordMap.put(70, "Seventy");
        digitWordMap.put(80, "Eighty");
        digitWordMap.put(90, "Ninety");
    }

    public String numberToWords(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        if(num == 0) {
            return "Zero";
        }
        List<Integer> temp = new ArrayList<>();
        while(num != 0) {
            temp.add(num % 1000);
            num /= 1000;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = temp.size() - 1; i >= 0; i--) {
            if(temp.get(i) > 0) {
                sb.append(helper(temp.get(i)));
                if(i == 3) {
                    sb.append(" Billion");
                }
                else if(i == 2) {
                    sb.append(" Million");
                }
                else if(i == 1){
                    sb.append(" Thousand");
                }
            }
        }
        return sb.toString().trim();
    }

    private String helper(int num) {
        StringBuilder sb = new StringBuilder();
        int n = num / 100;
        if(n > 0) {
            sb.append(digitToWord(n) + " Hundred");
        }
        num = num % 100;
        if(num <= 20) {
            sb.append(digitToWord(num));
        }
        else {
            n = num / 10;
            sb.append(digitToWord(n * 10));
            if(num % 10 != 0) {
                sb.append(digitToWord(num % 10));
            }
        }

        return sb.toString();
    }

    private String digitToWord(int n) {
        if(n == 0) {
            return "";
        }
        else {
            return " " + digitWordMap.get(n);
        }
    }
}
