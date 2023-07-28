package Leetcode_0_50;

public class Q8 {
    public int myAtoi(String s) {
        if (s.length() == 0) return 0;
        int len = s.length();
        int res = 0;
        int sign = 1;
        int i = 0;
        while (i < len && s.charAt(i)==' '){
            i++;
        }
        int start = i;
        int j = 0;
        for (;i < len; i++){
            char c = s.charAt(i);
            if (i == start && c == '+'){
                sign = 1;
            } else if (i == start && c == '-') {
                sign = -1;
            } else if (Character.isDigit(c)){
                int num = c - '0';
                if (res > Integer.MAX_VALUE/10 ||
                        (res == Integer.MAX_VALUE/10 && num > Integer.MAX_VALUE %10)){
                    return Integer.MAX_VALUE;
                }
                if (res < Integer.MIN_VALUE/10 ||
                        (res == Integer.MIN_VALUE/10 && -num < Integer.MIN_VALUE%10)  ){
                    return Integer.MIN_VALUE;
                }
                res = res*10 + sign*num;
            }else{
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
