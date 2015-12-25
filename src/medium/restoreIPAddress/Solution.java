package medium.restoreIPAddress;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return results;
        }

        dfs(s, results, 0, "", 0);
        return results;
    }

    private void dfs(String ip, List<String> results, int index, String restored, int count) {
        if(count > 4) {
            return;
        }
        if(count == 4 && index == ip.length()) {
            results.add(restored);
            return;
        }

        for(int i = 1; i < 4; i++) {
            if(index + i > ip.length()) {
                break;
            }
            String ipSeg = ip.substring(index, index + i);
            if((ipSeg.startsWith("0") && i > 1) || (i == 3 && Integer.parseInt(ipSeg) > 255)) {
                continue;
            }
            dfs(ip, results, index + i, restored + ipSeg + (count == 3 ? "" : "."), count + 1);
        }
    }

    public List<String> restoreIpAddresses2(String s) {
        List<String> results = new ArrayList<>();
        if(s == null || s.length() == 0) {
            return results;
        }

        int length = s.length();
        for(int i = 1; i < 4 && i < length - 2; i++) {
            for(int j = i + 1; j < i + 4 && j < length - 1; j++) {
                for(int k = j + 1; k < j + 4 && k < length; k++) {
                    String s1 = s.substring(0, i), s2 = s.substring(i, j);
                    String s3 = s.substring(j, k), s4 = s.substring(k);
                    if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        results.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }

        return results;
    }

    private boolean isValid(String ipSeg) {
        return !(ipSeg.length() > 3 || ipSeg.length() == 0 || (ipSeg.startsWith("0") && ipSeg.length() > 1)
                || (ipSeg.length() == 3 && Integer.parseInt(ipSeg) > 255));
    }
}
