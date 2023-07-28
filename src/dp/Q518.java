package dp;

public class Q518 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] += dp[j-coins[i]];
            }
        }
        return dp[amount];
    }


    public static void main(String[] args) {

    }
}
