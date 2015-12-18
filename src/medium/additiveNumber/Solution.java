package medium.additiveNumber;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0) {
            return false;
        }

        int len = num.length();
        // choose the first number
        for(int i = 1; i <= (len - 1) / 2; i++) {
            // A cannot start with 0 if its length is more than 1
            if(num.charAt(0) == '0' && i >= 2) {
                continue;
            }

            // choose the second number
            for(int j = i + 1; len - j >= Math.max(j - i, i); j++) {
                // B cannot start with 0 if its length is more than 1
                if(num.charAt(i) == '0' && j - i >= 2) {
                    continue;
                }

                long num1 = Long.parseLong(num.substring(0, i));
                long num2 = Long.parseLong(num.substring(i, j));
                String remain = num.substring(j);
                if(isAdditive(remain, num1, num2)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isAdditive(String num, long num1, long num2) {
        // reach the end
        if(num.length() == 0) {
            return true;
        }

        long sum = num1 + num2;
        String sumStr = String.valueOf(sum);
        if(!num.startsWith(sumStr)) {
            return false;
        }
        return isAdditive(num.substring(sumStr.length()), num2, sum);
    }
}
