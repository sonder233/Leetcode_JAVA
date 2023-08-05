package Leetcode_0_50;

import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (0 < nums[i]){
                break;
            }
            if (i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i + 1;
            int right = len - 1;
            while (left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0){
                    List<Integer> integers = Arrays.asList(nums[i],nums[left],nums[right]);
                    ans.add(integers);
                    while (left < right && nums[left] == nums[left+1]){
                        left++;
                    }
                    while (left < right && nums[right] == nums[right-1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if (sum > 0){
                    right--;
                }else if(sum < 0){
                    left++;
                }
            }
        }

        return ans;

    }
    public static void main(String[] args) {

    }
}
