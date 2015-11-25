package hard.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    Map<Integer, Node> map;
    Node head = null;
    Node end = null;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.val;
        }

        return -1;
    }

    public void set(int key, int value) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            old.val = value;
            remove(old);
            setHead(old);
        }
        else {
            Node created = new Node(key, value);
            if(map.size() >= capacity) {
                map.remove(end.key);
                remove(end);
            }
            setHead(created);
            map.put(key, created);
        }
    }

    private void remove(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        }
        else {
            head = node.next;
        }

        if(node.next != null) {
            node.next.prev = node.prev;
        }
        else {
            end = node.prev;
        }
    }

    private void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }
        head = node;

        if(end == null) {
            end = head;
        }
    }
}

class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
