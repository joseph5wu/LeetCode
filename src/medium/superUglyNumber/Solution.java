package medium.superUglyNumber;

public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if(primes == null || primes.length == 0 || n < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] results = new int[n];
        results[0] = 1;
        // 记录每个prime上次相乘的位置,从而保证每次都是从最右边开始处理,最终达到最小
        int[] indexes = new int[primes.length];

        for(int i = 1; i < n; i++) {
            results[i] = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                results[i] = Math.min(results[i], primes[j] * results[indexes[j]]);
            }
            for(int j = 0; j < indexes.length; j++) {
                if(results[i] == primes[j] * results[indexes[j]]) {
                    indexes[j]++;
                }
            }
        }

        return results[n - 1];
    }

    public int nthUglyNumber(int n) {
        if(n < 1) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] results = new int[n];
        results[0] = 1;
        int i2 = 0, i3 = 0, i5 = 0;
        for(int i = 1; i < n; i++) {
            results[i] = Math.min(2 * results[i2], Math.min(3 * results[i3], 5 * results[i5]));
            if(results[i] == 2 * results[i2]) {
                i2++;
            }
            if(results[i] == 3 * results[i3]) {
                i3++;
            }
            if(results[i] == 5 * results[i5]){
                i5++;
            }
        }

        return results[n - 1];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.nthUglyNumber(7));
    }
}
