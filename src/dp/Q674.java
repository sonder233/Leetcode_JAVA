package dp;

import java.util.Arrays;

public class Q674 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]){
                dp[i] = dp[i-1] + 1;
            }
            if (result < dp[i]){
                result = dp[i];
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,4,7};
        System.out.println(findLengthOfLCIS(nums));
    }
}
