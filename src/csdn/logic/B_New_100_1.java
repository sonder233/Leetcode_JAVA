package csdn.logic;

import java.util.Scanner;

public class B_New_100_1 {

    public static int getResult(int m, int n, int[][] matrix){
        int count = 0;
        //暴力方法
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1){
                    count++;
                    continue;
                }
                if(isLegal(i-1,j,m,n) && matrix[i-1][j] == 1){
                    count++;
                    continue;
                }
                if(isLegal(i+1,j,m,n) && matrix[i+1][j] == 1){
                    count++;
                    continue;

                }
                if(isLegal(i,j-1,m,n) && matrix[i][j-1] == 1){
                    count++;
                    continue;

                }
                if(isLegal(i,j+1,m,n) && matrix[i][j+1] == 1){
                    count++;
                    continue;

                }
            }
        }
        return count;
    }
    public static boolean isLegal(int x,int y,int m, int n){
        if (x >= 0 && x < m && y >= 0 && y < n){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        /*
         3 3
         0 0 0
         0 1 0
         0 0 0

         */
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println(getResult(m,n,matrix));
    }
}
