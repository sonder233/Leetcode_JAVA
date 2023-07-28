package Leetcode_0_50;

public class Q34 {
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int left = 0;
        int right = nums.length;
        while (left < right){
            int mid = (left + right)/2;
            if (nums[mid] == target){
                //找到了
                int i = mid;
                int j = mid;
                while (i > 0 && nums[i]==target){
                    i--;
                }
                while (j < nums.length && target == nums[j]){
                    j++;
                }
                if (nums[i] == target){
                    res[0] = i;
                }else{
                    res[0] = i+1;
                }
                if (j >= nums.length){
                    res[1] = j-1;
                }else if (nums[j] == target){
                    res[1] = j;
                }else{
                    res[1] = j - 1;
                }
                return res;
            }else if (target < nums[mid]){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1};
        int[] res = Q34.searchRange(nums,1);
        System.out.println(res[0]+","+res[1]);
    }
}
