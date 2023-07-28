package csdn.stringProblem;

import java.util.Scanner;

public class String_3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(",");
        int res = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i != j && !haveSame(words[i],words[j])){
                    res = Math.max(words[i].length() * words[j].length(),res);
                }
            }
        }
        /*
        iwdvpbn,hk,iuop,iikd,kadgpf
         */
        System.out.println(res);
    }
    public static boolean haveSame(String a,String b){
        boolean res = false;
        for (int i = 0; i < a.length(); i++) {
            if (b.contains(a.charAt(i)+"")){
                return true;
            }
        }
        return false;
    }
}
