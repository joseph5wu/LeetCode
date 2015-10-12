package easy.factorialTrailingZeroes;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

    Note: Your solution should be in logarithmic time complexity.
    n!后缀0的个数 = n!质因子中5的个数= floor(n/5) + floor(n/25) + floor(n/125) + ....
 */
public class Solution {
    public int trailingZeroes(int n) {
        if(n <= 0) {
            return 0;
        }

        int count = 0;
        for(long i = 5; n / i > 0; i *= 5) {
            count += n / i;
        }

        return count;
    }
}
