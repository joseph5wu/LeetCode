package medium.simplifyPath;

import java.util.Stack;

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0) {
            return path;
        }

        Stack<String> stack = new Stack<>();
        String[] dirs = path.split("/");
        for(String dir : dirs) {
            if(dir.equals("..")) {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else if(dir.equals(".") || dir.length() == 0) {
                continue;
            }
            else {
                stack.push(dir);
            }
        }

        String result = "";
        while(!stack.isEmpty()) {
            result = "/" + stack.pop() + result;
        }
        return result.length() == 0 ? "/" : result;
    }
}
