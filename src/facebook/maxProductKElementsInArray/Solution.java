package facebook.maxProductKElementsInArray;

import java.util.*;
public class Solution {
    public static long find(Integer[] nums, int k) {
        Arrays.sort(nums, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return Math.abs(b) - Math.abs(a);
            }
        });

        long prod = 1;
        int pos = 0;
        int negCount = 0, posCount = 0, zeroCount = 0;
        int lastNegInd = -1, lastPosInd = -1;
        while (negCount + posCount < k && pos < nums.length) {
            if (nums[pos] == 0) {
                return 0;
            } else {
                prod *= nums[pos];
                if (nums[pos] > 0) {
                    posCount++;
                    lastPosInd = pos;
                } else {
                    negCount++;
                    lastNegInd = pos;
                }
            }
            pos++;
        }

        if (negCount % 2 == 0) {
            return prod;
        } else {
            if (nums[pos] == 0) {
                return 0;
            }

            // add more neg or delete the last one
            int nextNegInd = -1, nextPosInd = -1;
            while (pos < nums.length && (nextNegInd == -1 || nextPosInd == -1)) {
                if (nums[pos] == 0) {
                    break;
                }
                if (nums[pos] > 0 && nextPosInd == -1) {
                    nextPosInd = pos;
                } else if (nums[pos] < 0 && nextNegInd == -1) {
                    nextNegInd = pos;
                }
                pos++;
            }

            long add = Long.MIN_VALUE;
            if (nextNegInd != -1 && lastPosInd != -1) {
                add = prod / nums[lastPosInd] * nums[nextNegInd];
            }
            long remove = Long.MIN_VALUE;
            if (nextPosInd != -1 && lastNegInd != -1) {
                remove = prod / nums[lastNegInd] * nums[nextPosInd];
            }

            return Math.max(prod, Math.max(add, remove));
        }
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, -1, 0, 1, 2, -3};
        System.out.println(find(nums, 6));
    }

}
