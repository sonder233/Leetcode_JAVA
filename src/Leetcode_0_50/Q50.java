package Leetcode_0_50;

public class Q50 {
    public double myPow(double x, int n) {
        //递归实现
        long N = n;
        if (N >= 0){
            return quickMul(x,N);
        }else{
            return 1.0/quickMul(x,-N);
        }
    }
    public double quickMul(double x, long N){
        if (N == 0){
            return 1.0;
        }
        double y = quickMul(x,N/2);
        if (N%2 == 0){
            return y*y;
        }else{
            return y*y*x;
        }
    }
}
