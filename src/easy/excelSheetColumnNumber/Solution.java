package easy.excelSheetColumnNumber;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

     For example:

     A -> 1
     B -> 2
     C -> 3
     ...
     Z -> 26
     AA -> 27
     AB -> 28
 */
public class Solution {
    public int titleToNumber(String s) {
        if(s == null || s.length() == 0) {
            throw new IllegalArgumentException("Input is invalid");
        }

        int result = 0;
        int length = s.length();
        int index = 0;
        while(index < length) {
            result += Math.pow(26, length - index - 1) * (s.charAt(index) - 'A' + 1);
            index++;
        }

        return result;
    }
}
