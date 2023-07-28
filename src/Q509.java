public class Q509 {
    public static int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        for (int x :
                dp) {
            System.out.println(x);
        }
        return dp[n-1];
    }
    public static void main(String[] args) {
        fib(5);
    }
}
