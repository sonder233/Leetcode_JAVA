package leetcode_51_100;

import java.util.ArrayList;
import java.util.List;

public class Q77 {
    public static void main(String[] args) {

    }
    static void backTracking(int n, int k, int startIndex, List<List<Integer>> result,
                             List<Integer> path){
        if (path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backTracking(n,k,i+1,result,path);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backTracking(n, k, 1, res,path);
        return res;
    }
}
