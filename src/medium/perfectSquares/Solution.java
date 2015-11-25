package medium.perfectSquares;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 */
public class Solution {
    public int numSquares(int n) {
        if(n < 0) {
            return 0;
        }

        int[] records = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            records[i] = i;
            for(int j = 1; j * j <= i; j++) {
                records[i] = Math.min(records[i], records[i - j * j] + 1);
            }
        }

        return records[n];
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.print(sol.numSquares(4));
    }
}
