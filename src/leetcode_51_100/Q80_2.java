package leetcode_51_100;

public class Q80_2 {
    public int removeDuplicates(int[] nums) {
        //米老鼠他妈给米老鼠开门---妙到家了
        int n = nums.length;
        if (n < 2) return n;
        int slow = 2;
        for (int fast = 2; fast < n; fast++) {
            if (nums[fast] != nums[slow-2]){
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }
}
