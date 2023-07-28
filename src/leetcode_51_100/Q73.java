package leetcode_51_100;

import java.util.ArrayList;
import java.util.List;

public class Q73 {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean row_0 = false;
        boolean col_0 = false;
        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0){
                col_0 = true;
            }
             
        }
        for (int i = 0; i < m; i++) {
            if (matrix[0][i] == 0){
                row_0 = true;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] ==0 ){
                    matrix[i][j] = 0;
                }
            }
        }
        if (row_0){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col_0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {

    }
}
