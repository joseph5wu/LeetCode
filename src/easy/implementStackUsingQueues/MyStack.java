package easy.implementStackUsingQueues;

import java.util.LinkedList;

public class MyStack {
    LinkedList<Integer> temp = new LinkedList<>();
    LinkedList<Integer> value = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        if(value.isEmpty()) {
            value.offer(x);
        }
        else{
            while(!value.isEmpty()) {
                temp.offer(value.pop());
            }
            value.offer(x);
            while(!temp.isEmpty()) {
                value.offer(temp.pop());
            }
        }
    }

    // Removes the element on top of the stack.
    public void pop() {
        value.pop();
    }

    // Get the top element.
    public int top() {
        return value.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return value.isEmpty();
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.print(stack.top());
    }
}
