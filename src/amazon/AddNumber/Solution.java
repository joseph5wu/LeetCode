package amazon.AddNumber;

public class Solution {
    private int sum = 0;

    public ListNode add(ListNode node1, ListNode node2) {
        sum = 0;
        ListNode temp1 = node1, temp2 = node2;
        int len1 = 0, len2 = 0;
        while(temp1 != null) {
            len1++;
            temp1 = temp1.next;
        }
        while(temp2 != null) {
            len2++;
            temp2 = temp2.next;
        }

        ListNode head = add(node1, len1, node2, len2);
        if(sum != 0) {
            ListNode node = new ListNode(sum);
            node.next = head;
            head = node;
        }
        return head;

    }

    private ListNode add(ListNode node1, int index1, ListNode node2, int index2) {
        ListNode pre;
        if(index1 < index2) {
            return add(node2, index2, node1, index1);
        }
        else if(index1 > index2) {
            pre = add(node1.next, index1 - 1, node2, index2);
            sum += node1.value;
        }
        else {
            if(node1 == null && node2 == null) {
                return null;
            }
            pre = add(node1.next, index1 - 1, node2.next, index2 - 1);
            sum += node1.value + node2.value;
        }

        ListNode node = new ListNode(sum % 10);
        node.next = pre;
        sum /= 10;
        return node;

    }

    public static void main(String[] args) {
        /**
         Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
         Output: 8 -> 0 -> 7
         */
        ListNode node10 = new ListNode(2);
        ListNode node11 = new ListNode(4);
        ListNode node12 = new ListNode(3);
        node10.next = node11;
        node11.next = node12;

        ListNode node20 = new ListNode(5);
        ListNode node21 = new ListNode(6);
        ListNode node22 = new ListNode(4);
        ListNode node23 = new ListNode(9);
        node20.next = node21;
        node21.next = node22;
        node22.next = node23;

        Solution sol = new Solution();
        ListNode node = sol.add(node10, node20);
        while(node != null) {
            System.out.print(node.value + " ");
            node = node.next;
        }
    }
}

class ListNode {
    int value;
    ListNode next;
    public ListNode(int value) {
        this.value = value;
    }
}

