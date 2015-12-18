package medium.findTheCelebrity;

import java.util.Stack;

public class Solution {
    public int findCelebrity(int n) {
        if(n <= 0) {
            return -1;
        }
        if(n == 1) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        // put all people into stack
        for(int i = 0; i < n; i++) {
            stack.push(i);
        }

        int a = 0, b = 0;
        while(stack.size() > 1) {
            a = stack.pop();
            b = stack.pop();
            if(knows(a, b)) {
                stack.push(b);
            }
            else {
                stack.push(a);
            }
        }

        // check the remaining one whether is a celebrity
        a = stack.pop();
        for(int i = 0; i < n; i++) {
            if(i != a && (knows(a, i) || !knows(i, a))) {
                return -1;
            }
        }
        return a;
    }

    private boolean knows(int a, int b){
        return true;
    }
}
