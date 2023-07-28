package dp;

import java.util.Arrays;

public class Q213 {
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        //从第一家开始
        int[] nums_1 = Arrays.copyOfRange(nums,0,nums.length-1);
        int[] nums_2 = Arrays.copyOfRange(nums,1,nums.length);

        return Math.max(myRob(nums_1),myRob(nums_2));
    }
    public static int myRob(int[] nums){
        int curr = 0;
        int prev = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(curr,prev + nums[i]);
            prev = curr;
            curr = temp;
        }
        return curr;
    }
    public static void main(String[] args) {

    }
}
