package csdn.stringProblem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P1_26 {
    public static void main(String[] args) {
        String line = "0";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        String binaryString = Long.toBinaryString(Long.parseLong(line));
        List<String> hexList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder(binaryString);
        stringBuilder.reverse();
        for (int i = 0;i<stringBuilder.length(); i += 7){
            String substring = stringBuilder.substring(i, Math.min(i + 7,stringBuilder.length()));
            String head = "";
            if (i + 7 >= stringBuilder.length() ){
                for (int j = 0; j < 8 - substring.length(); j++) {
                    head += "0";
                }
            }else{
                head = "1";
            }
            substring = new StringBuilder(substring + head).reverse().toString();
            String toHexString = Long.toHexString(Integer.parseInt(substring, 2));
            if (toHexString.length() < 2){
                toHexString = "0"+toHexString;
            }
            hexList.add(toHexString.toUpperCase());
        }
//        Collections.reverse(hexList);
        StringBuilder sb = new StringBuilder();
        for (String s : hexList) {
            sb.append(s);
        }
        if (sb.length() < 2 ){
            System.out.println("0"+sb);
        }else{
            System.out.println(sb);
        }
    }

}
