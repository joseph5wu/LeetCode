package easy.plusOne;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.

 The digits are stored such that the most significant digit is at the head of the list.
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;

        for(int i = length - 1; i >= 0; i--) {
            if(digits[i] == 9) {
                digits[i] = 0;
            }
            else {
                digits[i] += 1;
                break;
            }
        }

        // 如果最高位为0则需要在前面补1
        if(digits[0] == 0) {
            int[] newDigits = new int[length + 1];
            newDigits[0] = 1;
            for(int i = 0; i < length; i++) {
                newDigits[i + 1] = digits[i];
            }
            return newDigits;
        }
        return digits;
    }
}
