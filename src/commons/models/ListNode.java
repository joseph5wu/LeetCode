package commons.models;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public String toString() {
        ListNode cur = this;
        StringBuilder sb = new StringBuilder();
        do {
            sb.append(cur.val).append("->");
            cur = cur.next;
        } while(cur!= null && cur != this);
        return sb.substring(0, sb.length() - 2);
    }
}
