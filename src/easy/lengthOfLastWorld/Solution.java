package easy.lengthOfLastWorld;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.
 */
public class Solution {
    public int lengthOfLastWord(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }

        char current;
        boolean flag = false;
        int length = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            current = s.charAt(i);
            if((current >= 'a' && current <= 'z') || (current >= 'A' && current <= 'Z')) {
                flag = true;
                length++;
            }
            else {
                if(flag) {
                    return length;
                }
            }
        }
        return length;
    }
}
