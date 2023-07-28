package Leetcode_0_50;

import java.util.ArrayList;
import java.util.List;

public class Q22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backtrack(res,stringBuilder,0,0,n);
        return res;
    }
    void backtrack(List<String> list,StringBuilder stringBuilder,int left, int right,int n){
        if (stringBuilder.length() == n*2){
            list.add(stringBuilder.toString());
            return;
        }
        if (left < n){
            stringBuilder.append("(");
            backtrack(list,stringBuilder,left+1,right,n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if (right < left){
            stringBuilder.append(")");
            backtrack(list,stringBuilder,left,right+1,n);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

    }

    public static void main(String[] args) {
        Q22 q22 = new Q22();
        System.out.println(q22.generateParenthesis(2));
    }
}
