package easy.happyNumber;

import java.util.HashSet;

/**
 * Write an algorithm to determine if a number is "happy".

 A happy number is a number defined by the following process: Starting with any positive integer, replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1. Those numbers for which this process ends in 1 are happy numbers.

     Example: 19 is a happy number

     12 + 92 = 82
     82 + 22 = 68
     62 + 82 = 100
     12 + 02 + 02 = 1

 The key to solve this problem is the stop condition for the loop.
 */
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(!set.contains(n)) {
            set.add(n);

            n = sum(n);
            if(n == 1) {
                return true;
            }
        }

        return false;
    }

    private int sum(int n) {
        int sum = 0;
        int temp = n;
        int i = 0;
        while(temp > 0) {
            i = temp % 10;
            sum += i * i;
            temp /= 10;
        }

        return sum;
    }
}
