package easy.excelSheetColumnTitle;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

     For example:

     1 -> A
     2 -> B
     3 -> C
     ...
     26 -> Z
     27 -> AA
     28 -> AB
 */
public class Solution {
    public String convertToTitle(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("Input is invalid");
        }

        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            n--;
            char ch = (char)('A' + (n % 26));
            sb.append(ch);
            n /= 26;
        }

        sb.reverse();
        return sb.toString();
    }
}
