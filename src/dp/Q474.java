package dp;

public class Q474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < strs.length; i++) {
            int zeros = 0;
            int ones = 0;
            for (char c : strs[i].toCharArray()){
                if (c == '0'){
                    zeros++;
                }else {
                    ones++;
                }
            }
            for (int j = m; j >= zeros ; j--) {
                for (int k = n; k >= ones; k--) {
                    dp[j][k] = Math.max(dp[j][k],dp[j - zeros][k - ones]+1);
                }
            }
        }
        return dp[m][n];
    }
    int[] countZeroAndOne(String str){
        int[] cou = new int[2];
        for (char c : str.toCharArray()){
            cou[c - '0']++;
        }
        return cou;
    }
    public static void main(String[] args) {

    }
}
