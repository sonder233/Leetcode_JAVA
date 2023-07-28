import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q491 {
    static List<List<Integer>> result;
    static List<Integer> path;
//    static boolean[] used;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
//        used = new boolean[nums.length];
        backtrack(nums,0);
        return result;
    }

    static void backtrack(int[] nums, int startIndex){
//        if(startIndex < nums.length && nums[startIndex] < path.get(path.size()-1)){
//            return;
//        }
        if(path.size() > 1){
            result.add(new ArrayList<>(path));
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && startIndex<nums.length
                    && nums[i] < path.get(path.size()-1)){
                continue;
            }
            if (map.getOrDefault(nums[i],0)>=1){
                continue;
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
            path.add(nums[i]);
            backtrack(nums,i + 1);
            path.remove(path.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {4,6,7,7};
        List<List<Integer>> res = findSubsequences(nums);
        System.out.println(res);
    }
}
