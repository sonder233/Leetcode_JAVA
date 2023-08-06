package Leetcode_0_50;

import java.util.ArrayList;
import java.util.List;

public class Q46_2 {
    public static void main(String[] args) {

    }
    public void backtrack(int[] nums, int n, int[] used,List<List<Integer>> res,List<Integer> path){
        if (path.size() == n){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (used[i] == 1) continue;
            used[i] = 1;
            path.add(nums[i]);
            backtrack(nums,n,used,res,path);
            path.remove(path.size()-1);
            used[i] = 0;
        }

    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        int len = nums.length;
        int[] used = new int[len];
        backtrack(nums,len,used,res,path);
        return res;
    }
}
