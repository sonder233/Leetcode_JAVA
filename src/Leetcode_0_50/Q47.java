package Leetcode_0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrack(nums,used,ans,path);
        return ans;
    }
    public void backtrack(int[] nums, boolean[] used, List<List<Integer>> ans, List<Integer> path){
        if (path.size() == nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && used[i-1] == false){
                continue;
            }
            if (used[i] == false){
                used[i] = true;
                path.add(nums[i]);
                backtrack(nums,used,ans,path);
                path.remove(path.size()-1);
                used[i] = false;
            }

        }
    }
}
