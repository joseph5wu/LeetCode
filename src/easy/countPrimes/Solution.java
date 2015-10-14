package easy.countPrimes;

/**
 * Count the number of prime numbers less than a non-negative number, n.
 */
public class Solution {
    public int countPrimes(int n) {
        if(n <= 2) {
            return 0;
        }

        boolean[] flags = new boolean[n];
        for(int i = 2; i < n; i++) {
            flags[i] = true;
        }
        // 标记所有非质数,原理是从2开始，每次累加循环的i，即i倍肯定不为质数
        for(int i = 2; i <= Math.sqrt(n - 1); i++) {
            if(flags[i]) {
                for(int j = i + i; j < n; j += i) {
                    flags[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n; i++) {
            if(flags[i]) {
                count++;
            }
        }
        return count;
    }
}
