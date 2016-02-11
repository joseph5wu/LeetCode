package facebook.addHex;

public class Solution {

    public String addHex(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }

        int ai = a.length() - 1;
        int bi = b.length() - 1;
        int av;
        int bv;
        int flag = 0;
        int total;
        StringBuilder sb = new StringBuilder();
        while(ai >= 0 || bi >= 0) {
            if(ai >= 0) {
                av = translate(a.charAt(ai--));
            }
            else {
                av = 0;
            }
            if(bi >= 0) {
                bv = translate(b.charAt(bi--));
            }
            else {
                bv = 0;
            }

            total = flag + av + bv;
            if(total >= 16) {
                total = total - 16;
                flag = 1;
            }
            sb.append(Character.forDigit(total, 16));
        }

        if(flag == 1) {
            sb.append(1);
        }

        return sb.reverse().toString();
    }

    private int translate(char hex) {
        if(hex >= '0' && hex <= '9') {
            return hex - '0';
        }
        if(hex >= 'a' && hex <= 'f') {
            return hex - 'a' + 10;
        }
        if(hex >= 'A' && hex <= 'F') {
            return hex - 'A' + 10;
        }

        return 0;
    }

    public static void main(String[] args) {
        String a = "ff";
        String b = "ff";
        Solution sol = new Solution();
        System.out.println(sol.addHex(a, b));
    }
}
