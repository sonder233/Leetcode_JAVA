package leetcode_51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Q71 {
    public static String simplifyPath(String path) {
        StringBuilder res = new StringBuilder("/");
        Stack<String> stack = new Stack<>();
        path = path.replaceAll("//","/");

        String[] paths = path.split("/");
        for (String current:paths) {
            if (current.equals("")){
                continue;
            }else if (current.equals(".")){
                continue;
            }else if (current.equals("..")){
                if (stack.empty()){
                    continue;
                }else{
                    stack.pop();
                }
            }else{
                stack.push(current);
            }
        }
        List<String> result = new ArrayList<>();

        while (!stack.empty()){
            result.add(stack.peek());
            stack.pop();
        }
        for (int i = result.size()-1; i >= 0 ; i--) {
            res.append(result.get(i) + "/");
        }
        if (res.length() != 1){
            res.delete(res.length()-1,res.length());
        }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }
}
