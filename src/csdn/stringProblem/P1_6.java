package csdn.stringProblem;

import java.util.Arrays;
import java.util.Scanner;

public class P1_6 {
    public static void main(String[] args) {
//        String[] words = new String[]{"abca","ca","pca"};

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] split = line.substring(1, line.length() - 1).split(",");
        String[] words = Arrays.stream(split).map(s -> s.substring(1, s.length() - 1))
                .toArray(String[]::new);


        words = Arrays.stream(words)
                .map(s -> {
                   return new StringBuilder(s).reverse().toString();
                })
                .toArray(String[]::new);

        StringBuilder sb = new StringBuilder();
        int index = 0;
        boolean flag = true;
        while (flag){
            char current ;
            if (index + 1 > words[0].length()){
                break;
            }else{
                current = words[0].charAt(index);
                sb.append(current);
            }

            for (int i = 0; i < words.length; i++) {
                if (index+1 > words[i].length()){
                    //中途有某个字符串到头了，把上一个字符删了
                    sb.deleteCharAt(sb.length()-1);
                    flag = false;
                    break;
                }else{
                    if (words[i].charAt(index) != current){
                        sb.deleteCharAt(sb.length()-1);
                        flag = false;
                        break;
                    }
                }
            }
            index++;
        }
        if (sb.length() == 0){
            System.out.println("@Zero");
        }else{
            System.out.println(sb.reverse());
        }


//        for(String s : words) {
//            System.out.println(s);
//        }


    }
}
