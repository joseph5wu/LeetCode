package hard.trappingRainWater;

public class Solution {
    public int trap(int[] height) {
        int max = 0;
        for(int i = 1; i < height.length; i++) {
            if(height[i] > height[max]) {
                max = i;
            }
        }

        int water = 0;
        int peak = 0;
        for(int i = 0; i < max; i++) {
            if(height[i] > peak) {
                peak = height[i];
            }
            else {
                water += peak - height[i];
            }
        }
        peak = 0;
        for(int i = height.length - 1; i > max; i--) {
            if(height[i] > peak) {
                peak = height[i];
            }
            else {
                water += peak - height[i];
            }
        }

        return water;
    }
}
