package dp;

public class Q96 {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j-1] * dp[i - j];
            }
        }
        for (int i : dp) {
            System.out.println(i);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        numTrees(3);
    }
}
