package csdn.stringProblem;

import java.util.*;

public class P1_09 {
    public static void main(String[] args) {
        //aaa_passwor
        int index = 2;
        String line = "aaa_password___\"a12_45678\"__timeout_100_\"\"_";
        System.out.println(line);
////aaa_password___"a12_45678"__timeout_100_""_
////password__a12345678_timeout_100
//        System.out.println("password__a12345678_timeout_100");
//        Scanner scanner = new Scanner(System.in);
//        int index = -1 ;
//        String line ="";
//        index = scanner.nextInt();
//        scanner.nextLine();
//        line = scanner.nextLine();

        List<String> words = new ArrayList<>();
        int len = line.length();
        int left = 0;
        int right = 0;
        boolean flag = false;

        while (right < len){
            char c = line.charAt(right);
            if (right == len - 1 && right != left){
                words.add(line.substring(left,len));
            }
            if (c == '"'){
                if (flag == false){ //第一个"
                    flag = true;
                    right++;
                    left = Math.min(right  , len);
                    continue;
                }else{//第2个",可以分割了
                    flag = false;
                    String substring = line.substring(left, right);
                    left = Math.min(right + 1 , len);
                    //找到下一个非_的位置
                    while (left < len && line.charAt(left) == '_' ){
                        left++;
                    }
                    right = left;
                    words.add(substring);
                }

            }else if (c == '_' ){
                if (flag == true){//在"之后，这里的下划线不分割
                    right++;
                    continue;
                }else{
                    //分割
                    String substring = line.substring(left, right);
                    left = Math.min(right + 1 , len);
                    //找到下一个非_的位置
                    while (left < len && line.charAt(left) == '_' ){
                        left++;
                    }
                    right = left;
                    words.add(substring);
                    System.out.println("left = right = " + line.charAt(right));
                    right++;
                }
            }else{
                right++;
            }

        }

        if (index > words.size()){
            System.out.println("ERROR");
        }else{
            words.set(index,"******");
            StringJoiner sj = new StringJoiner("_");
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).equals("")){
                    sj.add("\"\"");
                }else{
                    sj.add(words.get(i));
                }
            }

            System.out.println(sj);
        }

    }
}
