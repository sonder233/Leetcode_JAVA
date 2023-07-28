package dp;

public class BagProblem_02 {
    public static void main(String[] args) {
        int size = 4;
        int[] weight = new int[]{1,3,4};
        int[] value = new int[]{15,20,30};
        int n = weight.length;// n:物品的数量
        int[] dp = new int[size+1];
        // 二维数组 压缩成一维数组 （滚动数组）、后无效性
        for (int i = 0; i < n ; i++) {
            for (int j = size; j >= weight[i] ; j--) {
                dp[j] = Math.max(dp[j],dp[j - weight[i]] + value[i]);
            }
        }
        System.out.println(dp[size]);
    }
}
