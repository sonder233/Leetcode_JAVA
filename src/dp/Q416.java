package dp;

import java.util.Arrays;

public class Q416 {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int target = 0;
        if (sum % 2 == 0){
            target = sum/2;
        }else{
            return false;
        }
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - nums[i]]+nums[i] );
            }
        }
        return dp[target] == target;
    }
    public static void main(String[] args) {
        boolean res = canPartition(new int[]{2,2,1,1});
        System.out.println(res);
    }
}
