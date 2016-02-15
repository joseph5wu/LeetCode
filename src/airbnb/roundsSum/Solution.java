package airbnb.roundsSum;

import java.util.*;
public class Solution {
    public static int[] round(double[] nums) {
        // calculate the round sum, and then sort the nums with the difference between ceiling
        // and then make those close to ceil be ceiling, close to floor be floor
        NumWithDiff[] diffNums = new NumWithDiff[nums.length];
        double sum = 0.0;
        int floorSum = 0;
        for(int i = 0; i < nums.length; i++) {
            double num = nums[i];
            int floor = (int) num;
            int ceil = floor;
            if(floor < num) {
                ceil++;
            }
            floorSum += floor;
            sum += num;
            diffNums[i] = new NumWithDiff(ceil, ceil - num);
        }

        // sort the diffNums
        Arrays.sort(diffNums, new Comparator<NumWithDiff>() {
            public int compare(NumWithDiff n1, NumWithDiff n2) {
                if(n1.diff <= n2.diff) {
                    return -1;
                }
                return 1;
            }
        });

        int roundSum = (int)Math.round(sum);
        int toCeilNum = roundSum - floorSum;
        int[] results = new int[nums.length];
        int i = 0;
        while(i < toCeilNum) {
            results[i] = diffNums[i].num;
            i++;
        }
        while(i < nums.length) {
            results[i] = diffNums[i].num - 1;
            i++;
        }
        return results;
    }

    public static void main(String[] args) {
        double[] arr = { 1.2, 3.7, 2.3, 4.8 };
        int[] res = round(arr);
        System.out.println(Arrays.toString(res));
    }
}

class NumWithDiff {
    int num;
    double diff;
    NumWithDiff(int num, double diff) {
        this.num = num;
        this.diff = diff;
    }
}
