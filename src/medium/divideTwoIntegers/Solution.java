package medium.divideTwoIntegers;

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dividendL = Math.abs((long)dividend);
        long divisorL = Math.abs((long)divisor);
        int result = 0;
        while(dividendL >= divisorL) {
            long temp = divisorL;
            long multiple = 1;
            while(dividendL >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dividendL -= temp;
            result += multiple;
        }

        return result * sign;
    }
}
