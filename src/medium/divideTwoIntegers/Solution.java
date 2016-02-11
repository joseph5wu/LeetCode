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

    public int divide2(int dividend, int divisor) {
        if(dividend == 0) {
            return 0;
        }
        if(divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }

        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        long dividendL = Math.abs((long) dividend);
        long divisorL = Math.abs((long) divisor);
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

    public static void main(String[] args) {
        int i1 = -2147483648;
        int i2 = -1;
        Solution sol = new Solution();
        System.out.println(sol.divide2(i1, i2));
        System.out.println(sol.divide(i1, i2));
    }
}
