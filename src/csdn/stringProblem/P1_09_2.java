package csdn.stringProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class P1_09_2 {
    public static void main(String[] args) {

        //aaa_password_"_"__"a12_45678"__timeout_100_""_
        //password__a12345678_timeout_100

        int index = 1;
//        String line = "aaa_password___\"a12_45678\"__timeout_100_\"\"_";
        String line = "password__a12345678_timeout_100";
        Scanner scanner = new Scanner(System.in);
        index = Integer.parseInt(scanner.nextLine());
        line = scanner.nextLine();

        List<String> words = new ArrayList<>();
        String[] split = line.split("_");

        int i = 0;
        boolean flag = false;//是否正在寻找
        StringJoiner stringJoiner = new StringJoiner("_");
        while (i < split.length){

            String word = split[i];
            if (!word.isEmpty()){

                if (flag){
                    if (word.endsWith("\"")){
//                        stringJoiner.add(word.substring(0,word.length()-1));
                        stringJoiner.add(word);
                        //搜寻接收，关闭搜寻，把拼接结果放入列表
                        flag = false;
                        words.add(stringJoiner.toString());
                        //清空拼接器
                        stringJoiner = new StringJoiner("_");
                    }else{
                        stringJoiner.add(word);
                    }
                }else{//不在搜寻过程中
                    if (word.startsWith("\"")){
                        if (word.equals("\"\"")){
                            words.add(word);
                        }else{
                            flag = true;//开始搜寻
                            //第一次寻找
//                            stringJoiner.add(word.substring(1,word.length()));
                            stringJoiner.add(word);
                        }

                    }else{//就是普通的
                        words.add(word);
                    }
                }

            }else{

            }
            i++;
        }
//        System.out.println("=================================");

        if (index >=words.size()){
            System.out.println("ERROR");
        }else{
            words.set(index,"******");
            StringJoiner sj = new StringJoiner("_");
            words.forEach(w -> sj.add(w));
            System.out.println(sj);
        }

//        words.forEach(s -> System.out.println(s));
//        System.out.println(words.size());
    }
}
