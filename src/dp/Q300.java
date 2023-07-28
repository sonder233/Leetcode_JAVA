package dp;

import java.util.Arrays;

public class Q300 {
    public static int lengthOfLIS(int[] nums) {
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp,1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                if (dp[i] > res) res = dp[i];
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
