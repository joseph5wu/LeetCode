package amazon;

import commons.models.ListNode;

public class LinkedListInsert {
    public ListNode inset(ListNode start, int val) {
        ListNode node = new ListNode(val);
        if(start == null) {
            node.next = node;
            return node;
        }

        ListNode cur = start;
        do {
            if(cur.val <= val && cur.next.val >= val) {
                break;
            }
            if(cur.val > cur.next.val && (val >= cur.val || val <= cur.next.val)) {
                break;
            }
            cur = cur.next;
        }while(cur != start);

        node.next = cur.next;
        cur.next = node;
        return node;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        LinkedListInsert sol = new LinkedListInsert();
        ListNode node = sol.inset(node3, 5);
        ListNode cur = node;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(cur.val).append("->");
            cur = cur.next;
        } while(cur != node);
        System.out.println(sb.substring(0, sb.length() - 2));
    }
}
