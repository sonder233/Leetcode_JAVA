package csdn.stringProblem;

import java.sql.Array;
import java.util.Scanner;
import java.util.Stack;

public class P1_12_2 {

    public static void main(String[] args) {
        String line = "bb3c4b";//这个是问题！
//        Scanner scanner = new Scanner(System.in);
//        line = scanner.nextLine();
        int len = line.length();

        int i = 0;
        StringBuilder sb_buffer = new StringBuilder();
        StringBuilder sb_result = new StringBuilder();
        StringBuilder sb_number ;
        StringBuilder sb_repeat = new StringBuilder();;
        while (i < len){
            char c_curr = line.charAt(i);
            if (Character.isDigit(c_curr)){//数字
                //是数字时 把之前缓存的字母存入结果串
                sb_result.append(sb_buffer);

                if (c_curr == '0'){// 数字起始是0 违法
                    System.out.println("!error");
                    return;
                }
                if (i == len-1){ // 字符串最后一位是数字 违法
                    System.out.println("!error");
                    return;
                }
                //遇到数字之后遍历所有的数字
                sb_number = new StringBuilder();
                sb_number.append(c_curr);
                int j=i+1;
                while (j < len && Character.isDigit(line.charAt(j))){
                    if(j >= len -1){// 字符串最后一位是数字 违法
                        System.out.println("!error");
                        return;
                    }
                    sb_number.append(line.charAt(j));
                    j++;
                }
                i = j ;
                int number = Integer.parseInt(sb_number.toString());
                if (number < 3 ) {
                    System.out.println("!error");
                    return;
                }
                char c_next = line.charAt(i);
                if ((sb_result.length() > 0 &&
                    c_next == sb_result.charAt(sb_result.length()-1))
                || !Character.isLowerCase(c_next)){
                    //此时是b4b情况 非法
                    System.out.println("!error");
                    return;
                }
                sb_repeat = new StringBuilder();
                for (int k = 0; k < number; k++) {
                    sb_repeat.append(c_next);
                }
                sb_result.append(sb_repeat);
                //然后清空缓存串
                sb_buffer = new StringBuilder();
            } else if (Character.isLowerCase(c_curr)) {
                if (sb_repeat.length() > 0 ){//说明上一个是通过数字+字母方式获得的
                    if (c_curr==sb_repeat.charAt(0)){//违法的 --> 4aa
                        System.out.println("!error");
                        return;
                    }else{
                        sb_buffer.append(c_curr);//先加入缓冲串
                        sb_repeat = new StringBuilder();//清空
                    }
                }else{//上一个传入的也是单个字符
                    if (sb_buffer.length() >= 2
                        && sb_buffer.charAt(sb_buffer.length()-1) == c_curr
                        && sb_buffer.charAt(sb_buffer.length()-2) == c_curr
                    ){//单个字符串重复  aaa情况
                        System.out.println("!error");
                        return;
                    }else {
                        sb_buffer.append(c_curr);
                    }
                }

            }else{
                System.out.println("!error");
                return;
            }
            i++;
        }
        if (sb_buffer.length()>0){
            sb_result.append(sb_buffer);
        }

        System.out.println(sb_result);


    }
//    public static boolean judge(StringBuilder stringBuilder){
//
//    }
}
