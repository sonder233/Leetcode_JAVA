package dp;

public class Q343 {

    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i ; j++) {
                dp[i] = Math.max(dp[i],Math.max(j * (i-j),j * dp[i - j]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {

    }
}
