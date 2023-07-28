package Leetcode_0_50;

import java.util.Arrays;

public class Q16 {

    public static int threeSumClosest(int[] nums, int target) {
        int res = Integer.MAX_VALUE;
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < len; ++i) {
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            int lo = i+1;
            int hi = len - 1;
            while (lo < hi){
                int sum = nums[i]+nums[lo]+nums[hi];
                if (sum == target){
                    return target;
                }
                if (Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                if (sum>target){
                    int hi0 = hi-1;
                    while (lo < hi0 && nums[hi0] == nums[hi]){
                        hi0--;
                    }
                    hi = hi0;
                }else{
                    int lo0 = lo+1;
                    while (lo0<hi && nums[lo] == nums[lo0]){
                        lo0++;
                    }
                    lo = lo0;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(Q16.threeSumClosest(nums,1));
    }
}
