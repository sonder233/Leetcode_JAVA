package Leetcode_0_50;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40 {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates,0,0,target,res,path);
        return res;
    }
    static void backtrack(int[] candidates,int index,int sum,int target,List<List<Integer>> res,List<Integer> path){
        if (sum == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index;i < candidates.length && sum + candidates[i] <= target;i++){
            if (i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            backtrack(candidates,i+1,sum,target,res,path);
            sum -= candidates[i];
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> res = combinationSum2(nums,8);
        System.out.println(res);
    }
}
