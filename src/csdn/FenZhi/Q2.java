package csdn.FenZhi;

import java.util.Scanner;

public class Q2 {
    public static long ans = Long.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        int count = getCount(num, 0);
        System.out.println(count);
    }
    public static int getCount(long num, int count){
        if (num == 1){
            return count;
        }
        if (num % 2 == 0){//偶数
            return getCount(num / 2, count+1);
        }else {//奇数
            return Math.min(getCount(num + 1, count+1),getCount(num - 1, count+1));
        }
    }
}
