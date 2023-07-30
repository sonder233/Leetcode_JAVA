package csdn.stringProblem;

import java.util.Scanner;
import java.util.StringJoiner;

public class P1_16 {
    public static void main(String[] args) {
        String words = "developer.";
        int begin = -1;
        int end = 2;

        Scanner scanner = new Scanner(System.in);
        words = scanner.nextLine();
        begin = scanner.nextInt();
        end = scanner.nextInt();

        String[] split = words.split(" ");

        begin = Math.min(Math.max(0,begin),split.length-1);
        end = Math.min(Math.max(0,end),split.length-1);

        if (begin >= end){
            System.out.println(words);
            return;
        }

        begin = Math.max(0,begin);
        end = Math.min(end,split.length-1);
        int sub = (end - begin) /2 + 1;
        for (int i = 0; i <  sub;i++, begin++,end--) {
            String temp = split[end];
            split[end] = split[begin];
            split[begin] = temp;
        }
        StringJoiner sj = new StringJoiner(" ");
        for (String s : split) {
            sj.add(s);
        }
        System.out.println(sj);

    }

}
