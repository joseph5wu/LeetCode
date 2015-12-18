package hard.validNumber;

public class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        s = s.trim();
        if(s.length() == 0 || s.contains(" ")) {
            return false;
        }
        if(s.length() == 1) {
            return isPureNumber(s);
        }

        // check whether has neg/pos sign
        if(s.charAt(0) == '-' || s.charAt(0) == '+') {
            s = s.substring(1);
        }

        // if e exist, split to two halves
        if(s.contains("e")) {
            int index = s.indexOf("e");
            if(index == 0 || index == s.length() - 1) {
                return false;
            }
            String part1 = s.substring(0, index);
            String part2 = s.substring(index + 1);

            if(part1.contains("e") || part2.contains("e")) {
                return false;
            }
            if(part2.contains(".")) {
                return false;
            }
            return isNumber(part1) && isNumber(part2);
        }
        else if(s.contains(".")) {
            int index = s.indexOf(".");
            if(index == 0) {
                return isPureNumber(s.substring(1));
            }
            if(index == s.length() - 1) {
                return isPureNumber(s.substring(0, index));
            }
            String part1 = s.substring(0, index);
            String part2 = s.substring(index + 1);
            return isPureNumber(part1) && isPureNumber(part2);
        }
        else {
            return isPureNumber(s);
        }
    }

    private boolean isPureNumber(String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) > '9' || s.charAt(i) < '0') {
                return false;
            }
        }

        return true;
    }

}
