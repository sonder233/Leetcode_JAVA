package dp;

public class Q1143 {

    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int res = 0;
        int[][] dp = new int[m+1][n+1];


        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char c_1 = text1.charAt(i-1);
                char c_2 = text2.charAt(j-1);
                if (c_1 == c_2){
                    dp[i][j] = dp[i-1][j-1]+1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {

    }
}
