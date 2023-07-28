package leetcode_51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q90 {
    static List<List<Integer>> result ;
    static List<Integer> path;
    static boolean[] used;
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        path = new ArrayList<>();
        used = new boolean[nums.length];
        backtrack(nums,0,used);
        return result;
    }
    static void backtrack(int[] nums,int startIndex, boolean[] used){
        result.add(new ArrayList<>(path));
        if (startIndex >= nums.length){
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i-1] == nums[i] && !used[i-1]){
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            //！！！！！！i+1 ！！！！！！！！！
            backtrack(nums,i+1,used);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res);
    }
}
