package leetcode_51_100;

public class Q81 {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int len = nums.length;
        int right = len - 1;
        while (left <= right){
            int mid = left + (left + right) / 2;
            if (nums[mid] == target){
                return true;
            }
            if (nums[left] == nums[mid]){
                left++;
            }
            //前半部分有序
            if (nums[left] < nums[mid]){
                //target在前半部分
                if (nums[left] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{//否在在后半部分
                    left = mid + 1;
                }
            }else {
                if (nums[mid] < target && target <= nums[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }
        return false;
    }
    public static void main(String[] args) {

    }
}
