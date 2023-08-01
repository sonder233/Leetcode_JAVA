package csdn.stringProblem;

import java.util.Scanner;

public class P1_19 {
    public static void main(String[] args) {
        String line = "iwdvpbn,hk,iuop,iikd,kadgpf";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        int maxPlus = 0;
        String[] split = line.split(",");
        for (int i = 0; i < split.length; i++) {
            for (int j = i+1; j < split.length; j++) {
                if (!judge(split[i],split[j])){
                    maxPlus = Math.max(maxPlus,split[i].length() * split[j].length());
                }
            }
        }
        System.out.println(maxPlus);
    }
    public static boolean judge(String s_1,String s_2){
        for (int i = 0; i < s_1.length(); i++) {
            if (s_2.contains(s_1.charAt(i)+"")){
                return true;
            }
        }
        return false;
    }
}
