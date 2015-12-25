package medium.bulbSwitcher;

public class Solution {
    public int bulbSwitch(int n) {
        if(n < 0) {
            throw new IllegalArgumentException("Invalid input");
        }
        else {
            // Only bulbs with index equaling a perfect square number will be on in the end.
            // (because it has an odd number of divisors)
            return (int)Math.sqrt(n);
        }
    }
}
