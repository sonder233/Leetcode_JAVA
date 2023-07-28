package leetcode_51_100;

import java.util.Arrays;

public class Q62 {

    public static int uniquePaths(int m, int n) {
        int[][] visit = new int[m][n];
        int result = 0;
        dfs(m,n,0,0,result,visit);
        return result;
    }
    static void dfs(int m, int n, int x, int y, int result,int[][] visit){
        if (x >= m || x < 0 ||  y >= n || y < 0){
            return;
        }
        if (visit[x][y] == 1){
            return;
        }
        if (x == m-1 && y == n-1){
            result++;
            return;
        }
        visit[x][y] = 1;
        dfs(m,n,x+1,y,result,visit);
        dfs(m,n,x,y+1,result,visit);
        visit[x][y] = 0;

    }
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,2));
    }
}
