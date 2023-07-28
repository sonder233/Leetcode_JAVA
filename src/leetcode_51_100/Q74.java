package leetcode_51_100;

public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean res = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            if (target <= matrix[i][col-1]){
                for (int j = 0; j < col; j++) {
                    if (matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
