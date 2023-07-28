package leetcode_51_100;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Q60 {
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k==0 ){
            return head;
        }
        //计算节点数
        int n = 1;
        ListNode iter = head;
        while (iter.next != null){
            iter = iter.next;
            n++;
        }
        int add = n - k % n;
        if (add == n){
            return head;
        }
        iter.next = head;
        while (add-- > 0){
            iter = iter.next;
        }
        ListNode res = iter.next;
        iter.next = null;
        return res;

    }
    public static void main(String[] args) {
        ListNode test_1 = new ListNode(1
                ,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5,null)))));
        ListNode test_2 = new ListNode(1,new ListNode(2));
        ListNode res = rotateRight(test_2,1);
        while (res.next != null){
            res = res.next;
            System.out.println(res.val);
        }
    }
}
