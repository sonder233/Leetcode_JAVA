package Leetcode_0_50;

import java.util.ArrayList;
import java.util.List;

public class Q43 {
    public static String multiply(String num1, String num2) {
        List<String> list = new ArrayList<>();
        num2 = new StringBuilder(num2).reverse().toString();
        for (int i = 0; i < num2.length(); i++) {
            String tail = "";
            for (int j = 0; j < i; j++) {
                tail += "0";
            }
            String tmp = multiplyOne(num1,num2.charAt(i)+"");
            tmp += tail;
            list.add(tmp);
        }
        String res = "0";
        for (int i = 0; i < list.size(); i++) {
            res = Q415.addStrings(res,list.get(i));
        }
        return res;
    }
    static public String multiplyOne(String num1, String num2){
        StringBuilder stringBuilder = new StringBuilder();
        int n = num2.charAt(0) - '0';
        int c = 0;
        num1 = new StringBuilder(num1).reverse().toString();
        for (int i = 0; i < num1.length(); i++) {
            int n_i = num1.charAt(i)-'0';
            int sum = n * n_i + c;
            c = sum / 10;
            stringBuilder.append(sum % 10);
        }
        if (c != 0){
            stringBuilder.append(c);
        }
        return stringBuilder.reverse().toString();
    }

    public static void main(String[] args) {
        String test = multiply("2","3");
        System.out.println(test);
    }
}
