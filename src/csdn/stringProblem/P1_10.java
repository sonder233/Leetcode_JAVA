package csdn.stringProblem;

import java.util.Scanner;

public class P1_10 {
    public static void main(String[] args) {
        String line = "01#01#01#01";
//        Scanner scanner = new Scanner(System.in);
//        line = scanner.nextLine();
        boolean isLegal = judge(line);


        //验证是否合法
        //......
        if (isLegal){
            String[] split = line.split("#");
            String binString = "";
            for (String s : split) {
                String head = "";
                String bin = Integer.toBinaryString(Integer.parseInt(s));
                for (int i = 0; i < 8 - bin.length(); i++) {
                    head += "0";
                }
                binString += head + bin;

            }
            long result = Long.parseLong(binString,2);
            System.out.println(result);

        }else{
            System.out.println("invalid IP");
        }

    }

    public static boolean judge(String ip){

        int before = ip.length();
        int after = ip.replaceAll("#","").length();
        if ( before - after != 3){
            //井号的数量不是三
            return false;
        }
        String[] split = ip.split("#");
        for (String str : split) {
            if ("".equals(str)){
                return false;
            }
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))){
                    //包含非数字的字符
                    return false;
                }
            }
            if (!str.equals(Integer.parseInt(str)+"")){
                return false;
            }
        }

        if ((Integer.parseInt(split[0]) < 1 || Integer.parseInt(split[0]) > 128)
            ||(Integer.parseInt(split[1]) < 0 || Integer.parseInt(split[1]) > 255)
            ||(Integer.parseInt(split[2]) < 0 || Integer.parseInt(split[2]) > 255)
            ||(Integer.parseInt(split[3]) < 0 || Integer.parseInt(split[3]) > 255)){
            return false;
        }

        return true;

    }
}
