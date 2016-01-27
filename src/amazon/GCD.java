package amazon;

public class GCD {
    public int gcd(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        int gcd = nums[0];
        for(int i = 1; i < nums.length; i++) {
            gcd = gcd(gcd, nums[i]);
        }
        return gcd;
    }

    private int gcd(int num1, int num2) {
        if(num1 == 0 || num2 == 0) {
            return 0;
        }

        if(num1 < num2) {
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        while(num1 != 0 && num2 != 0) {
            int temp = num1 % num2;
            num1 = num2;
            num2 = temp;
        }

        return num1 + num2;
    }
}
