package easy.powerOfThree;

public class Solution {
    public boolean isPowerOfThree(int n) {
        //return Integer.toString(n, 3).matches("10*");
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}
