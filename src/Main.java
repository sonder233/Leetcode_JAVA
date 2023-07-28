
public class Main {
    // 409. 最长回文串
    public int longestPalindrome(String s) {
        int ans = 0;
        int[] count =  new int[128];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c]++;
        }
        for (int i = 0; i < count.length; i++) {
            int tmp = count[i];
            ans += tmp / 2 * 2 ;
            if (ans %2 == 0 && tmp %2 == 1){
                ans++;
            }
        }
        return ans;
    }
    //376. 摆动序列
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int ans = 1;
        int curDiff = 0;
        int preDiff = 0;
        for (int i = 0; i < nums.length-1; i++) {
            curDiff = nums[i+1] - nums[i];
            if ((preDiff <= 0 && curDiff > 0) || (preDiff >= 0 && curDiff <0)){
                ans++;
                preDiff = curDiff;
            }
        }
        return ans;
    }
    //53. 最大子数组和
    public static int maxSubArray(int[] nums) {
        if (nums.length <= 1) return nums[0];
        int result = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0){
                sum = nums[i];

            }else{
                sum += nums[i];

            }
            result = Math.max(result,sum);
        }
        return result;
    }
    //122. 买卖股票的最佳时机 II
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i-1] > 0){
                res += prices[i] - prices[i-1];
            }
        }
        return res;
    }
    //55. 跳跃游戏
    public boolean canJump(int[] nums) {
        if (nums.length <= 1) return true;
        boolean b = false;
        int maxIndex = nums[0];
        for (int i = 1; i < nums.length && i <= maxIndex; i++) {
            maxIndex = Math.max(maxIndex,i+nums[i]);
            if (maxIndex >= nums.length-1){
                b = true;
            }
        }
        return b;
    }
    //45. 跳跃游戏 II
    public int jump(int[] nums) {
        if (nums.length < 1) return 0;
        int steps = 0;
        int border = 0;
        int maxIndex = 0;
        for (int i = 0; i < nums.length-1; i++) {
            maxIndex =  Math.max(maxIndex, i+nums[i]);
            if (i ==  border){
                steps++;
                border = maxIndex;
            }
        }
        return steps;
        
    }
    //203. 移除链表元素
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        ListNode soilder = new ListNode(val-1);
        soilder.next = head;
        ListNode node = soilder;
        while (node.next != null){
            if (node.next.val == val){
                node.next = node.next.next;
            }else{
                node = node.next;

            }
        }
        return soilder;
    }
    
    public static void main(String[] args) {
//        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int[] nums = new int[]{-2,-1};
        System.out.println(maxSubArray(nums));
    }
}