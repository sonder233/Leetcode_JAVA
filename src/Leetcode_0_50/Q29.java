package Leetcode_0_50;

public class Q29 {
    public static int divide(int dividend, int divisor) {
        int res = 0;
        int flag = 1;
        if (dividend > 0 && divisor < 0){
            flag = -1;
        } else if (dividend<0 && divisor>0) {
            flag = -1;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        while (dividend - divisor >= 0){
            dividend -= divisor;
            res++;
        }


        return res*flag;
    }

    public static void main(String[] args) {
        System.out.println(Q29.divide(10,3));
    }
}
