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
}

class RandomListNode {
    int label;
    RandomListNode next, random;

    RandomListNode(int x) {
        this.label = x;
    }
}
