package Leetcode_0_50;

public class Q38 {
    public static String countAndSay(int n) {
        if (n == 1){
            return "1";
        }
        String res = "1";
        for (int i = 2; i <= n; i++) {
            String cur = res;
            res = "";
            int lo = 0, hi = 0;
            while (hi < cur.length()){
                while (hi < cur.length() && cur.charAt(lo) == cur.charAt(hi)){
                    hi++;
                }
                int distance = hi - lo;
                res +=""+ distance + cur.charAt(lo);
                lo = hi;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }
}
