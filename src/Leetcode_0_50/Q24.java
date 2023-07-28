package Leetcode_0_50;

public class Q24 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        ListNode dummy = new ListNode(0,head);
        if (head == null){
            return null;
        }
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next !=null){
            ListNode tmp_1 = cur.next;
            ListNode tmp_2 = null;
            if (cur.next.next.next != null){
                tmp_2 = cur.next.next.next;
            }
            cur.next = tmp_1.next;
            tmp_1.next = tmp_2;
            cur.next.next =tmp_1;
            cur.next.next.next = tmp_2;
            cur = cur.next.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q24 q24 = new Q24();

        ListNode cur = new ListNode(1);
        ListNode dummy = new ListNode(0,cur);
        for (int i = 2; i < 5; i++) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        ListNode test = q24.swapPairs(dummy.next);
        while (test != null){
            System.out.println(test.val);
            test = test.next;
        }
    }
}
