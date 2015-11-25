package easy.strobogrammaticNumber;

public class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.isEmpty()) {
            return true;
        }

        char[] numChars = num.toCharArray();
        for(int i = 0 ; i <= numChars.length / 2; i++) {
            char c = numChars[i];
            if(c == '2' || c == '3' || c == '4' || c == '5' || c == '7') {
                return false;
            }
            if((c == '0' || c == '1' || c == '8') && c != numChars[numChars.length - 1 - i]) {
                return false;
            }
            if((c == '6' && numChars[numChars.length - 1 - i] != '9') || (c == '9' && numChars[numChars.length - 1 - i] != '6')) {
                return false;
            }
        }

        return true;
    }
}
