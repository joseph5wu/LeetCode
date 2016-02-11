package facebook.blackboxList;

import java.util.*;
public class Solution {
    private LinkedList<Integer> list = null;
    private Random random = new Random();

    public Solution(List<Integer> list) {
        this.list = new LinkedList<>();
        for(Integer ele : list) {
            this.list.add(ele);
        }
    }

    public int pop() {
        if(list.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int ran = random.nextInt(2);
        if(ran < 1) {
            return list.pollFirst();
        }
        else {
            return list.pollLast();
        }
    }

    public int peek() {
        if(list.isEmpty()) {
            return Integer.MIN_VALUE;
        }

        int ran = random.nextInt(2);
        if(ran < 1) {
            return list.peekFirst();
        }
        else {
            return list.peekLast();
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public List<Integer> generate() {
        Stack<Integer> first = new Stack<>();
        Stack<Integer> second = new Stack<>();
        while(!isEmpty()) {
            int value = pop();
            while(!first.isEmpty() && first.peek() > value) {
                int prev = first.pop();
                second.push(prev);
            }
            first.push(value);
        }

        while(!first.isEmpty()) {
            second.push(first.pop());
        }

        List<Integer> results = new ArrayList<>();
        while(!second.isEmpty()) {
            results.add(second.pop());
        }
        return results;
    }

    public static void main(String[] args) {
        List<Integer> original = new ArrayList<>();
        original.add(2);
        original.add(2);
        original.add(3);
        original.add(5);
        original.add(5);
        Solution sol = new Solution(original);

        List<Integer> results = sol.generate();
        for(Integer result : results) {
            System.out.print(result + " ");
        }

    }
}
