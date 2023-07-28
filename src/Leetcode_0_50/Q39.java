package Leetcode_0_50;

import java.util.ArrayList;
import java.util.List;

public class Q39 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(candidates,0,target,res,path);
        return res;
    }
    static void backtrack(int[] candidates, int begin, int target, List<List<Integer>> res, List<Integer> path){
        if (target < 0){
            return;
        }
        if (target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            path.add(candidates[i]);
//            System.out.println("当前元素："+candidates[i]+",索引："+i);
//            System.out.println("递归之前=>"+path.toString()+", 当前元素："+candidates[i]+",剩余值："+(target-candidates[i]));
            backtrack(candidates,i,target-candidates[i],res,path);
            path.remove(path.size()-1);
//            System.out.println("递归之后=>"+path.toString());

        }
    }

    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        List<List<Integer>> res = combinationSum(nums,7);
        System.out.println(res.toString());
    }
}
