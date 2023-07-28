package csdn.stringProblem;

import java.util.Scanner;
import java.util.StringJoiner;

public class P1_11 {
    static int[] fact;
    public static void main(String[] args) {
//        int number = 12;
//        String line = "12abc-abCABc4aB@";

        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String line = scanner.next();

        String[] arr = line.split("-");
        StringJoiner sj = new StringJoiner("-");
        //    sj.add(convert(arr[0])); // 看用例说明，对应第一个子串是不需要做大小写转换的，但是也拿不准，考试时可以都试下
        sj.add(arr[0]);
//        int index = line.indexOf("-");
//        String head = line.substring(0,index);
//        String tail = line.substring(index,line.length()).replaceAll("-","");
        StringBuilder sb = new StringBuilder();
        String[] split = line.split("-");
        for (int i = 1; i < split.length; i++) {
            sb.append(split[i]);
        }
        String tail = sb.toString();
//        StringJoiner sj = new StringJoiner("-");
//        sj.add(head);

//        System.out.println(tail);
        for (int i = 0; i < tail.length(); i += number) {
            String substring = tail.substring(i, Math.min(i + number, tail.length()));
            int upper = 0;
            int lower = 0;
            for (int j = 0; j < substring.length(); j++) {
                char c = substring.charAt(j);
                if ( c >= 'A' && c <= 'Z'){
                    upper++;
                } else if (c >= 'a' && c <= 'z') {
                    lower++;
                }
            }
            if (lower < upper){
                substring = substring.toUpperCase();
            }else if (lower > upper ){
                substring = substring.toLowerCase();
            }
//            System.out.println(substring);
            sj.add(substring);
        }
        System.out.println(sj);

    }
}
