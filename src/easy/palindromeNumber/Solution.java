package easy.palindromeNumber;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class Solution {

    public boolean isPalindrome(int x) {
        if(x < 0)
        {
            return false;
        }

        int temp = x, times = 1;
        while(temp / times >= 10)
        {
            times *= 10;
        }

        while(temp > 0)
        {
            if(temp / times != temp % 10)
            {
                return false;
            }

            temp = temp % times;
            temp = temp / 10;
            times =  times / 100;
        }
        return true;
    }
}
