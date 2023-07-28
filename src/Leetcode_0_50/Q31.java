package Leetcode_0_50;

public class Q31 {
    public static void nextPermutation(int[] nums) {
        if (nums.length<=1){
            return;
        }
        //123654
        int len = nums.length;
        int left = -1;
        for (int i = len - 1; i > 0; i--) {
            if (nums[i-1] < nums[i]){
                left = i - 1;
                break;
            }
        }
        int right = len-1 ;
        if (left>=0){
            for (int i = len - 1; i >= left; i--) {
                if (nums[left] < nums[i]){
                    right = i;
                    //swap
                    int tmp = nums[right];
                    nums[right] = nums[left];
                    nums[left] = tmp;
                    break;
                }
            }
        }

        //reverse
        int start = left+1;
        int end = len - 1;
        while (start < end){
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,2};
        Q31.nextPermutation(nums);
    }
}
