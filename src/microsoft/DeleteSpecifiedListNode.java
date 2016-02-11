package microsoft;

import commons.models.ListNode;

public class DeleteSpecifiedListNode {
    public int delete(ListNode node, int target) {
        int index = -1;
        if(node == null){
            return index;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = node;
        ListNode temp = dummy;
        int count = 0;
        while(temp.next != null) {
            if(temp.next.val == target) {
                if(index == -1) {
                   index = count;
                }
                temp.next = temp.next.next;
            }
            else {
                temp = temp.next;
            }
            count++;
        }

        return index;
    }

    public static void main(String[] args) {
        int count = 1;
        ListNode node1 = new ListNode(count++);
        ListNode node2 = new ListNode(count++);
        ListNode node3 = new ListNode(count++);
        ListNode node4 = new ListNode(count++);
        ListNode node5 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        DeleteSpecifiedListNode sol = new DeleteSpecifiedListNode();
        System.out.println(node1);
        System.out.println(sol.delete(node1, 2));
        System.out.println(node1);
    }
}
