package easy.minStack;

public class MinStack {
    private Node header;

    public void push(int x) {
        if(header == null) {
            header = new Node(x, x, null);
        }
        else {
            int min = Math.min(x, header.min);
            header = new Node(x, min, header);
        }
    }

    public void pop() {
        if(header != null) {
            header = header.next;
        }
    }

    public int top() {
        if(header == null) {
            return Integer.MAX_VALUE;
        }

        return header.val;
    }

    public int getMin() {
        if(header == null) {
            return Integer.MAX_VALUE;
        }

        return header.min;
    }
}

class Node {
    int val;
    int min;
    Node next;

    Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}
