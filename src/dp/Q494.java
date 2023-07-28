package dp;

public class Q494 {
    public int findTargetSumWays(int[] nums, int target) {
        /*
        类01背包问题:
        设pos为取+的数字和,neg为取-的数字和(均为正数),则target=pos-neg=pos-(sum-pos)=2*pos-sum
        故pos=(sum+target)/2>=0且为常数,因此此问题等价于求有多少种方式用nums[i]凑成和为pos
        进而该问题抽象为:用价值与体积均为nums[i]的物品,恰好凑满容量为pos的背包方案数
        1.状态定义:dp[j]为恰好能凑满容量为j的背包方案数
        2.状态转移:背包容量能或者不能装下nums[i]
            2.1 当不能装下nums[i]时,方案数直接继承之前的dp[j]
            2.2 当能装下nums[i]时,总的方案数为不考虑nums[i]的方案数+有nums[i]参与新增的方案数
                dp[j] += dp[j - nums[i]],dp[j - nums[i]]种方案与nums[i]共同凑成pos,即1*dp[j - nums[i]]
        3.状态初始化:dp[0]=1,因为后面总会一直查找至j=0,如dp[3] += dp[3-3],空集是任意一条有效路径的起点,当属一条
        4.遍历顺序:i正序,j倒序
        5.返回形式:dp[pos]就是凑成pos总的方案数
         */
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum) return 0;
        int pos = (sum + target) / 2;

        int[] dp = new int[pos+1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = pos; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[pos];
    }
    public static void main(String[] args) {

    }
}
