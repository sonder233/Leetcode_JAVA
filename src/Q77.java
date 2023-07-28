import java.util.ArrayList;
import java.util.List;

public class Q77 {
    List<List<Integer>> result = new ArrayList<>();;
    List<Integer> path = new ArrayList<>();

    void backTracking(int n, int k, int startIndex){
        if (path.size()==k){
            result.add(new ArrayList<>(path));
            System.out.println(path.toString());
            return;
        }
        for (int i = startIndex; i <= n; i++) {
            path.add(i);
            backTracking(n,k,i+1);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        backTracking(n,k,1);
        return result;
    }

    public static void main(String[] args) {
        Q77 q77 = new Q77();
        q77.combine(4,2);
    }
}
