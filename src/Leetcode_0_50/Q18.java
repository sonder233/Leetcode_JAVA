package Leetcode_0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length<4){
            return res;
        }
        Arrays.sort(nums);//排序
        int len = nums.length;
        for (int i = 0; i < len-3; i++) {
            if (i>0 && nums[i] == nums[i-1]){
                continue;
            }
            if ((long)nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if ((long) nums[i]+nums[len-3]+nums[len-2]+nums[len-1]<target){
                continue;
            }
            for (int j = i+1;j<len-2;j++){
                if (j>i+1 && nums[j] == nums[j-1]){
                    continue;
                }
                if ((long)nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if ((long)nums[i]+nums[j]+nums[len-2]+nums[len-1]<target){
                    continue;
                }
                int left = j+1;
                int right = len-1;
                while (left<right){
                    long sum = (long) nums[i]+nums[j]+nums[left]+nums[right];
                    if (sum == target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        while (left<right && nums[left] == nums[left+1]){
                            left++;
                        }
                        left++;
                        while (left<right && nums[right-1] == nums[right]){
                            right--;
                        }
                        right--;
                    } else if (sum < target) {
                        left++;
                    }else {
                        right--;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Q18 q18 = new Q18();
        int[] nums = {-3,-1,0,2,4,5};
        System.out.println(q18.fourSum(nums,0).toString());
    }
}
