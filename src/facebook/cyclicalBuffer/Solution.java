package facebook.cyclicalBuffer;

import java.util.*;
public class Solution {
    private int[] list;
    private int head;
    private int tail;
    private int used;
    private int capacity;


    public Solution(int capacity) {
        list = new int[capacity];
        this.head = 0;
        this.tail = -1;
        this.used = 0;
        this.capacity = capacity;
    }

    public void push(int val) {
        if(used == capacity) {
            throw new IllegalStateException("list full");
        }
        tail = (tail + 1) % capacity;
        list[tail] = val;
        used++;
    }

    public int pop() {
        if(used == 0) {
            throw new IllegalStateException("list empty");
        }
        head = head % capacity;
        used--;
        return list[head++];
    }

    public static void main(String[] args){
        Solution sol = new Solution(5);
        for(int i = 0; i < 5; i++) {
            sol.push(i);
        }
        for(int i = 0; i < 3; i++) {
            System.out.println(sol.pop());
        }
        for(int i = 6; i < 10; i++) {
            sol.push(i);
        }
    }

}
