package leetcode_51_100;

public class Q79 {
    static boolean res = false;
    public static boolean exist(char[][] board, String word) {
        boolean res = false;

        return res;
    }
    boolean StringContains(StringBuilder sb, String str){
        return sb.toString().contains(str);
    }
    void dfs(int x, int y, StringBuilder sb,char[][] board,String word){
        if (x >= board.length || y >= board[0].length
                || x < 0 || y < 0){
            return;
        }
        if (StringContains(sb,word)){
            res = true;
        }
        sb.append(board[x][y]);
        dfs(x-1,y,sb,board,word);
        dfs(x+1,y,sb,board,word);
        dfs(x,y-1,sb,board,word);
        dfs(x,y+1,sb,board,word);
        sb.deleteCharAt(sb.length()-1);
    }
    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        System.out.println(exist(board,word));
    }
}
