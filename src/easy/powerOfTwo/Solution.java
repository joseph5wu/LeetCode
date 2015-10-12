package easy.powerOfTwo;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }

        while(n > 1) {
            int t = n >> 1;
            int c = t << 1;

            if(n != c)
            {
                return false;
            }
            n >>= 1;
        }

        return n == 1;
    }
}
