package Leetcode_0_50;

import java.util.*;

public class Q15 {
    public List<List<Integer>> threeSum(int[] nums) {
        //暴力解法
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        int len = nums.length;
        if (nums == null || len < 3){
            return list;
        }
        Arrays.sort(nums);

        for (int i = 0; i < len; i++) {
            if (nums[i] > 0){
                break;
            }
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int lo = i+1;
            int hi = len-1;
            while (lo < hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if (sum == 0){
                    list.add(Arrays.asList(nums[i],nums[lo],nums[hi]));

                    while (lo<hi && nums[lo] == nums[lo+1]){
                        lo++;
                    }
                    while (lo<hi && nums[hi] == nums[hi-1]){
                        hi--;
                    }
                    lo++;
                    hi--;
                }else if (sum > 0){
                    hi--;
                }else{
                    lo++;
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {

    }
}
