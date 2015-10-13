package easy.reverseInteger;

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 */
public class Solution {
    public int reverse(int x) {
        if(x == 0) {
            return 0;
        }
        else if (x > 0) {
            return reversePositive(x);
        }
        else {
            return 0 - reversePositive(Math.abs(x));
        }
    }

    private int reversePositive(int x) {
        int temp = x;
        long reverse = 0;
        while(temp > 0) {
            // 获得此时个位数
            reverse = reverse * 10 + temp % 10;
            temp /= 10;

            if(reverse > Integer.MAX_VALUE || reverse < Integer.MIN_VALUE) {
                return 0;
            }
        }

        return (int)reverse;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reverse(1534236469));
    }
}
