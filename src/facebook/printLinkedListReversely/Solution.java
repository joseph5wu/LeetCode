package facebook.printLinkedListReversely;

public class Solution {
    public String print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode reverseHead = print(head, sb);
        System.out.println(sb.toString());
        StringBuilder sb2 = new StringBuilder();
        while(reverseHead != null) {
            sb2.append(reverseHead.val).append("->");
            reverseHead = reverseHead.next;
        }
        System.out.println(sb2.toString());
        return sb.substring(0, sb.length() - 2);
    }

    private ListNode print(ListNode node, StringBuilder sb) {
        if(node == null) {
            return node;
        }
        if(node.next == null) {
            sb.append(node.val).append("->");
            return node;
        }

        ListNode next = node.next;
        node.next = null;
        ListNode reverseHead = print(next, sb);
        next.next = node;
        sb.append(node.val).append("->");
        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution sol = new Solution();
        System.out.println(sol.print(node1));
    }

}

class ListNode {
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}
