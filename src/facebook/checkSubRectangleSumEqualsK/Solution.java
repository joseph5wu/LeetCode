package facebook.checkSubRectangleSumEqualsK;

public class Solution {
    public boolean check(int[][] nums, int k) {
        if(nums == null || nums.length == 0 || nums[0].length == 0) {
            return false;
        }

        // use the same size array to mark the sum
        int[][] sums = new int[nums.length][nums[0].length];
        sums[0][0] = nums[0][0];
        for(int i = 1; i < nums.length; i++) {
            sums[i][0] = sums[i - 1][0] + nums[i][0];
        }
        for(int i = 1; i < nums[0].length; i++) {
            sums[0][i] = sums[0][i - 1] + nums[0][i];
        }
        for(int i = 1; i < nums.length; i++) {
            for(int j = 1; j < nums[0].length; j++) {
                sums[i][j] = sums[i - 1][j] + sums[i][j - 1] - sums[i - 1][j - 1] + nums[i][j];
            }
        }

        // find the match sub rectangle from the sum array
        return dfs(sums, 0, 0, 0, 0, k);

    }

    private boolean dfs(int[][] sums, int startX, int startY, int endX, int endY, int target) {
        if(startX > endX || startY > endY) {
            return false;
        }
        if(startX < 0 || startX >= sums.length || startY < 0 || startY >= sums[0].length) {
            return false;
        }
        if(endX < 0 || endX >= sums.length || endY < 0 || endY >= sums[0].length) {
            return false;
        }


        int total = sums[endX][endY];
        if(startY > 0) {
            total -= sums[endX][startY - 1];
        }
        if(startX > 0) {
            total -= sums[startX - 1][endY];
        }
        if(startX > 0 && startY > 0) {
            total += sums[startX - 1][startY - 1];
        }

        if(total == target) {
            return true;
        }
        else if(total > target) {
            return dfs(sums, startX + 1, startY, endX, endY, target) || dfs(sums, startX, startY + 1, endX, endY, target);
        }
        else {
            return dfs(sums, startX, startY, endX + 1, endY, target) || dfs(sums, startX, startY, endX, endY + 1, target);
        }

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[][] nums = new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
        System.out.println(sol.check(nums, 100));
    }
}
