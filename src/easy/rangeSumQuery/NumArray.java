package easy.rangeSumQuery;

public class NumArray {
    private int[] nums;
    private int[] numSum;

    public NumArray(int[] nums) {
        this.nums = nums;
        numSum = new int[nums.length];
        if(nums.length > 0) {
            numSum[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                numSum[i] = numSum[i - 1] + nums[i];
            }
        }
    }

    public int sumRange(int i, int j) {
        if(i < 0 || i > j || j > nums.length - 1) {
            return 0;
        }
        if(i == 0) {
            return numSum[j];
        }
        else {
            return numSum[j] - numSum[i - 1];
        }
    }

}
