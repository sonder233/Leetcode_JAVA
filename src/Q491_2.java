import java.util.ArrayList;
import java.util.List;

public class Q491_2 {
    static List<List<Integer>> result;
    static List<Integer> path;
    public static List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        path = new ArrayList<>();
        dfs(0,Integer.MIN_VALUE,nums);
        return result;
    }
    static void dfs(int cur, int last, int[] nums){
        if (cur == nums.length){
            if (path.size()>=2){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        if (nums[cur] >= last){
            path.add(nums[cur]);
            dfs(cur+1,nums[cur],nums);
            path.remove(path.size()-1);
        }
        if (nums[cur] != last){
            dfs(cur+1,last,nums);
        }

    }
    public static void main(String[] args) {

    }
}
