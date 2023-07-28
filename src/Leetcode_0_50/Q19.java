package Leetcode_0_50;

public class Q19 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = new ListNode(0,head);
        ListNode tmp = head;
        int len = 0;
        while (tmp != null){
            len++;
            tmp = tmp.next;
        }


        ListNode cur = first;
        for (int i=1;i<len-n+1;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode res = first.next;
        return res;
    }

    public static void main(String[] args) {
        Q19 q19 = new Q19();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2 );
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode first = q19.removeNthFromEnd(head,2);

//        System.out.println(q19.removeNthFromEnd(head,2).toString());

        while (first!=null){
            System.out.println(first.val);
            first = first.next;
        }
    }

}
