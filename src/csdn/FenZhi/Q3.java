package csdn.FenZhi;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public static void main(String[] args) {
        String line = "AXdddF";

        char[] chars = line.toCharArray();
        int n = chars.length;
        //存储前缀和 加快运算速度
        int[] preSum = new int[n+1];
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n ; i++) {
            preSum[i] = preSum[i-1] + chars[i-1];
        }

        getCount(n, preSum, 0,0,res);
        if (res.size() == 0){
            System.out.println(0);
        } else if (res.size() == 1) {
            System.out.println(res.get(0));
        }else{
            System.out.println(-1);
        }

    }
    public static void getCount(int n, int[] preSum, int start, int count,List<Integer> res) {
        if (start == n){
            res.add(count);
            return;
        }
        for (int end = start + 1; end <= n; end++){
            if (isShuiXian(preSum[end] - preSum[start])){
                getCount(n,preSum,end,count+1,res);
            }
        }
    }



    public static boolean isShuiXian(int num){
        if (num < 100 || num > 999){
            return false;
        }
        int x = num/100;//百
        int y = (num%100)/10;
        int z = (num%10);

        return num == x*x*x + y*y*y + z*z*z;
    }
}
