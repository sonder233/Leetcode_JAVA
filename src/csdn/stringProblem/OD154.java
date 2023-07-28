package csdn.stringProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class OD154 {
    public static void main(String[] args) {
        // 12abc-abCABc-4aB@
        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        String origin = scanner.nextLine();
        String[] list_origin = origin.split("-");
        StringJoiner stringJoiner = new StringJoiner("-");
        stringJoiner.add(list_origin[0]);

        StringBuilder stringBuilder =  new StringBuilder();
        for (int i = 1; i < list_origin.length; i++) {
            stringBuilder.append(list_origin[i]);
        }
        String newStr = stringBuilder.toString();

        for (int i = 0; i < newStr.length(); i += k) {
            String sub = newStr.substring(i,Math.min(i+k,newStr.length()));
            int upper = 0;
            int lower = 0;
            for (int j = 0; j < sub.length(); j++) {
                if (Character.isUpperCase(sub.charAt(j))){
                    upper++;
                }else if (Character.isLowerCase(sub.charAt(j))){
                    lower++;
                }
            }
            if (lower > upper){
                sub = sub.toLowerCase();
            }else if (upper > lower){
                sub = sub.toUpperCase();
            }
            stringJoiner.add(sub);

//            res.add();
        }
        System.out.println(stringJoiner.toString());

    }
}
