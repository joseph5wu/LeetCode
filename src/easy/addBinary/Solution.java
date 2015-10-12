package easy.addBinary;

/**
 * Given two binary strings, return their sum (also a binary string).

     For example,
     a = "11"
     b = "1"
     Return "100".
 */
public class Solution {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }

        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        while(ai >= 0 || bi >=0) {
            int av = 0;
            int bv = 0;
            if(ai >= 0) {
                av = a.charAt(ai) == '0' ? 0 : 1;
                ai--;
            }
            if(bi >= 0) {
                bv = b.charAt(bi) == '0' ? 0 : 1;
                bi--;
            }

            int sum = av + bv + flag;
            if(sum >= 2) {
                flag = 1;
                sum -= 2;
            }
            else {
                flag = 0;
            }
            sb.append(sum);
        }

        if(flag == 1) {
            sb.append(flag);
        }
        return sb.reverse().toString();
    }
}
