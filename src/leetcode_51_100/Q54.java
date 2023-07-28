package leetcode_51_100;

import java.util.ArrayList;
import java.util.List;

public class Q54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        if (matrix == null){
            return ans;
        }
        int upper = 0, down = matrix.length-1,
                left = 0, right = matrix[0].length-1;
        while (true){
            for (int i = left; i <= right; i++) {
                ans.add(matrix[upper][i]);
            }
            if (++upper > down) break;
            for (int i = upper; i <= down; i++) {
                ans.add(matrix[i][right]);
            }
            if (--right < left) break;
            for(int i = right;i>= left;i--){
                ans.add(matrix[down][i]);
            }
            if (--down < upper) break;
            for(int i = down;i>= upper;i--){
                ans.add(matrix[i][left]);
            }
            if (++left > right)break;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }
}
