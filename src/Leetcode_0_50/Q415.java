package Leetcode_0_50;

public class Q415 {
    //415. 字符串相加
    public static String addStrings(String num1, String num2) {
        StringBuilder stringBuilder = new StringBuilder();

        if (num1.length() < num2.length()){//确保num1是大数
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int sub = num1.length() - num2.length();
        for (int i = 0; i < sub; i++) {
            num2 += "0";
        }

        int c = 0;//进位
        int i = 0;
        for (; i < num2.length(); i++) {
            int curNum_1 = num1.charAt(i) - '0';
            int curNum_2 = num2.charAt(i) - '0';
            int sum = curNum_1 + curNum_2 + c;
            c = sum / 10;
            stringBuilder.append(sum%10);
        }
        if (c != 0){
            stringBuilder.append(c);
        }
        stringBuilder.reverse();

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Q415.addStrings("9133","0");
    }
}
