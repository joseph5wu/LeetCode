package hard.removeInvalidParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> results = new ArrayList<>();
        if(s == null) {
            return results;
        }
        Set<String> resultSet = new HashSet<>();

        // calculate max remove left and right parentheses
        int rmL = 0, rmR = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                rmL++;
            }
            else if(s.charAt(i) == ')') {
                if(rmL != 0) {
                    rmL--;
                }
                else {
                    rmR++;
                }
            }
        }

        dfs(resultSet, s, 0, rmL, rmR, 0, new StringBuilder());
        for(String result : resultSet) {
            results.add(result);
        }
        return results;
    }

    private void dfs(Set<String> resultSet, String s, int position, int rmL, int rmR, int current, StringBuilder sb) {
        if(position == s.length() && rmL == 0 && rmR == 0 && current == 0) {
            resultSet.add(sb.toString());
            return;
        }
        else if(position == s.length() || rmL < 0 || rmR < 0 || current < 0){
            return;
        }

        char c = s.charAt(position);
        if(c == '(') {
            // remove it
            dfs(resultSet, s, position + 1, rmL - 1, rmR, current, sb);
            // keep it
            dfs(resultSet, s, position + 1, rmL, rmR, current + 1, sb.append(c));
        }
        else if(c == ')') {
            dfs(resultSet, s, position + 1, rmL, rmR - 1, current, sb);
            dfs(resultSet, s, position + 1, rmL, rmR, current - 1, sb.append(c));
        }
        else {
            dfs(resultSet, s, position + 1, rmL, rmR, current, sb.append(c));
        }

        sb.setLength(sb.length() - 1);
    }
}
