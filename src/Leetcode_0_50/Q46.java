package Leetcode_0_50;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,path,res);
        return res;
    }
    public static void backtrack(int[] nums,boolean[] used, List<Integer> path, List<List<Integer>> res){
        if (nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtrack(nums,used,path,res);
            path.remove(path.size()-1);
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
