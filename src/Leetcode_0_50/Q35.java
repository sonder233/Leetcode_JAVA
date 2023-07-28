package Leetcode_0_50;

public class Q35 {
    public int searchInsert(int[] nums, int target) {
        int index = -1;
        int lo = 0;
        int hi = nums.length;
        while (lo < hi){
            int mid = (lo+hi)/2;
            if (target < nums[mid]){
                hi = mid;
            }else if (nums[mid] < target){
                lo = mid+1;
            }
        }
        return lo;
    }
}
