package airbnb.decodeFind;

public class Solution {
    private String valid = null;
    private int times = 0;

    public void setValid(String valid) {
        this.valid = valid;
        this.times = 0;
    }

    private int decode(String str) {
        times++;
        return str.equals(valid) ? times : -1;
    }

    public int decodeFind(String str) {
        return helper(str, 0);
    }

    private int helper(String str, int pos) {
        if(pos == str.length()) {
            return decode(str);
        }

        char[] chars = str.toCharArray();
        // upper case
        chars[pos] = Character.toUpperCase(chars[pos]);
        int result = helper(new String(chars), pos + 1);
        if(result != -1) {
            return result;
        }

        // lower case
        chars[pos] = Character.toLowerCase(chars[pos]);
        return helper(new String(chars), pos + 1);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.setValid("kljJJ324hjkS_");
        System.out.println(sol.decodeFind("kljJJ324hjks_"));
    }
}
