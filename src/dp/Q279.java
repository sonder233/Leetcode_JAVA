package dp;

public class Q279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i*i <= n ; i++) {
            for (int j = 1; j <= n; j++) {
                if (j - i*i >= 0){
                    dp[j] = Math.min(dp[j - i * i]+1,dp[j]);
                }
            }
        }
        return dp[n];
    }
}
