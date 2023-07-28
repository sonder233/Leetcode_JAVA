package csdn.stringProblem;

import java.util.Scanner;

public class OD129 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        String binStr = Long.toBinaryString(num);
        StringBuilder res = new StringBuilder();
        int end = binStr.length();
        while (end - 7 > 0){
            res.append(getHexString("1"+binStr.substring(end - 7,end))  );
            end -= 7;
        }
        if (end >= 0){
            res.append(getHexString(binStr.substring(0,end)));
        }
        System.out.println(res.toString());


    }
    public static String getHexString(String binStr){
        String hexStr = Integer.toHexString(Integer.parseInt(binStr,2));
        if (hexStr.length() == 1) hexStr = "0" + hexStr;
        return hexStr.toUpperCase();
    }
}
