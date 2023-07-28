package leetcode_51_100;

public class Q79_2 {
    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board,word,i,j,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }
    static boolean dfs(char[][] board,String word, int x, int y, int cur, boolean[][] visited){
        //不在网格内
        if (x >= board.length || y >= board[0].length
                || x < 0 || y < 0){
            return false;
        }
        //重复访问
        if (visited[x][y] == false){
            return false;
        }
        //当前字符不相等
        if (board[x][y] != word.charAt(cur)){
            return false;
        }
        if (cur == word.length()){
            return true;
        }
        visited[x][y] = true;
        boolean f = dfs(board,word,x+1,y,cur+1,visited)
                ||  dfs(board,word,x-1,y,cur+1,visited)
                ||  dfs(board,word,x,y+1,cur+1,visited)
                ||  dfs(board,word,x,y-1,cur+1,visited);
        if (f){
            return true;
        }
        visited[x][y] = false;
        return false;
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
