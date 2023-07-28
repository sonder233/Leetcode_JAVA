public class Q746 {
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        if (len == 0) return 0;
        if (len == 1) return cost[0];
        if (len == 2) return Math.min(cost[0],cost[1]);
        int[] dp = new int[len+1];
        
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < len+1; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2] + cost[i-2]);
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[len];
    }

    public static void main(String[] args) {
        minCostClimbingStairs(new int[]{10,15,20});
    }
}
