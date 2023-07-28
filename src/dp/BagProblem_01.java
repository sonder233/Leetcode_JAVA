package dp;
import myUtils.MyUtil;
public class BagProblem_01 {
    public static void main(String[] args) {
        int size = 4;
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int n = weight.length;// n:物品的数量
        int[][] dp = new int[n][size+1];
        //初始化dp数组
        for (int i = weight[0]; i <= size; i++) {
            dp[0][i] = value[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= size; j++) {
                if (weight[i] > j){ //i号物品重量大于背包剩余容量j，则不放
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }
        MyUtil.printTwpDimenArray(dp);
        System.out.println(dp[2][4]);
    }
}
