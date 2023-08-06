package csdn.FenZhi;

import java.util.Arrays;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int k = Integer.parseInt(scanner.nextLine());
        int target = Integer.parseInt(scanner.nextLine());

        int[] nums = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
        if(k > nums.length ){
            System.out.println("0");
            return;
        }
        Arrays.sort(nums);
        System.out.println(kSum(nums,k, target,0,0,0));
    }

    public static int kSum(int[] nums, int k, int target, int start, int count, long sum){
        if (k < 2) return count;

        if (k == 2) {
            return twoSum(nums,k,target,start,count,sum);
        }
        for (int i = start; i <= nums.length - k; i++) {
            //剪枝
            if (nums[i] > 0 && sum + nums[i] > target) break;
            //去重
            if (i >  start && nums[i] == nums[i-1]) continue;
            count = kSum(nums,k-1,target,i+1,count,sum+nums[i]);
        }
        return count;
    }
    public static int twoSum(int[] nums, int k, int target, int start, int count, long preSum){
        int l = start;
        int r = nums.length-1;
        while (l < r){
            long sum = preSum + nums[l] + nums[r];
            if (target < sum){
                r--;
            } else if (target > sum) {
                l++;
            }else{
                count++;
                while (l + 1 < r && nums[l] == nums[l+1]){
                    l++;
                }while (r - 1 > l && nums[r] == nums[r-1]){
                    r--;
                }
                l++;
                r--;
            }
        }
        return count;
    }
}
