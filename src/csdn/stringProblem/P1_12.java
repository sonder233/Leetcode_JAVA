package csdn.stringProblem;

import java.util.Scanner;

public class P1_12 {
    public static void main(String[] args) {

        String line = "bbb4f";
        int len = line.length();
//
//        int from = 0;
//        char test_curr = line.charAt(from);
//        int to = Math.min(from+1,len-1);;
//        while (to < len){
//            to = Math.min(to+1,len-1);
//            if (line.charAt(to) != test_curr){
//                break;
//            }else{
//
//            }
//        }
//        System.out.println();

        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        boolean flag = false;
        char c_pre = line.charAt(0);
        String numberStr = "";
        while ( i < line.length()){
            char c_curr = line.charAt(i);
            if (Character.isDigit(c_curr)){
                int number = c_curr - '0';
                numberStr += number;
                i++;
                if (i >= len){
                    System.out.println("!error");
                    return;
                }else{
                    char c_afterNumber = line.charAt(i);
                    if (Character.isLowerCase(c_afterNumber)){
                        if (stringBuilder.length() > 0){
                            char c_last = stringBuilder.charAt(stringBuilder.length() - 1);
                            if (c_afterNumber == c_last){
                                System.out.println("!error");
                                return;
                            }
                        }
                        int count = Integer.parseInt(numberStr);
                        if (count < 3){
                            System.out.println("!error");
                            return;
                        }
                        for (int j = 0; j < count; j++) {
                            stringBuilder.append(c_afterNumber);
                            flag = true;//表示上一个是通过数字进去的
                            c_pre = c_curr;
                        }
                        numberStr = "";
                    }else if(Character.isDigit(c_afterNumber)){
                        numberStr += c_afterNumber;
                    }else{
                        System.out.println("!error");
                        return;
                    }
                }
            }else if (Character.isLowerCase(c_curr)){
                if (i < len -2){
                    if (c_curr==line.charAt(i+1) && c_curr == line.charAt(i+2)){
                        System.out.println("!error");
                        return;
                    }
                }
                if (stringBuilder.length() > 0 && flag == true){
                    char c_last = stringBuilder.charAt(stringBuilder.length()-1);
                    if (c_curr == c_last){
                        System.out.println("!error");
                        return;
                    }
                }
                stringBuilder.append(c_curr);
                flag = false;
                c_pre = c_curr;
            }else{
                System.out.println("!error");
                return;
            }
            i++;

        }
        System.out.println(stringBuilder);
    }
}
