package leetcode_51_100;

import java.util.ArrayList;
import java.util.List;

public class Q78 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();
    public static List<List<Integer>> subsets(int[] nums) {
        backtrack(nums,0);
        return result;
    }
    public static void backtrack(int[] nums, int startIndex){
        result.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtrack(nums,i+1);
            path.remove(path.size()-1);
        }
    }
    public static void main(String[] args) {
        int[] nums = {0};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res);
    }
}
