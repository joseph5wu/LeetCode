package hard.copyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode node = head;
        while(node != null) {
            RandomListNode newNode = new RandomListNode(node.label);
            map.put(node, newNode);
            node = node.next;
        }

        for(RandomListNode temp : map.keySet()) {
            RandomListNode newNode = map.get(temp);
            newNode.next = map.get(temp.next);
            newNode.random = map.get(temp.random);
        }

        return map.get(head);
    }

    public RandomListNode copyRandomList2(RandomListNode head) {
        if(head == null) {
            return null;
        }

        RandomListNode current = head, next = null;
        RandomListNode copy = null;
        // First round: make copy of each node,
        // and link them together side-by-side in a single list.
        while(current != null) {
            next = current.next;
            copy = new RandomListNode(current.label);
            copy.next = next;
            current.next = copy;
            current = next;
        }

        // Second round: assign random pointers for the copy nodes.
        current = head;
        while(current != null) {
            if(current.random != null) {
                current.next.random = current.random.next;
            }
            current = current.next.next;
        }

        // Third round: restore the original list, and extract the copy list.
        current = head;
        RandomListNode dummy = new RandomListNode(0);
        copy = dummy;
        while(current != null) {
            next = current.next.next;
            copy.next = current.next;
            copy = copy.next;
            current.next = next;
            current = next;
        }
        return dummy.next;
    }
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
