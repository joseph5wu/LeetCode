package easy.climbingStairs;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 The easiest idea is a Fibonacci number. f(n) = f(n-1) + f(n-2).
 The nth stairs is from either n-1th the stair or the n-2th stair.
 However recursive is time-consuming. We know that recursion can be written in loop,
 the trick here is not construct a length of n array, only three element array is enough.
 */
public class Solution {
    public int climbStairs(int n) {
        if(n <= 0) {
            throw new IllegalArgumentException("Input is invalid");
        }
        if(n < 3) {
            return n;
        }

        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i < n + 1; i++) {
            f2 = f1 + f2;
            f1 = f2 - f1;
        }

        return f2;
    }
}
