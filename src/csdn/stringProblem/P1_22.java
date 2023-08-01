package csdn.stringProblem;

import java.util.Scanner;
import java.util.StringJoiner;

public class P1_22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = 5;
        String line = "2-5g-3-J";

//        k = scanner.nextInt();
//        line = scanner.next();

        String[] split = line.split("-");
        if (split.length == 1){
            System.out.println(split[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        StringJoiner stringJoiner = new StringJoiner("-");
        stringJoiner.add(split[0]);
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i]);
        }

        for (int i = 0; i < sb.length(); i += k) {
            String upperCase = sb.substring(i, Math.min(i + k,sb.length())).toUpperCase();
            stringJoiner.add(upperCase);
        }
        System.out.println(stringJoiner);
    }
}
