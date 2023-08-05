package csdn.LuoJi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringJoiner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();
        HashMap<String, HashSet<String>> warns = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String[] split = scanner.nextLine().split(" ");
             if (warns.containsKey(split[1])){
                warns.get(split[1]).add(split[0]);
             }else{
                 HashSet<String> temp = new HashSet<>();
                 temp.add(split[0]);
                 warns.put(split[1],temp);
             }
        }
        String line = scanner.nextLine();
        String[] split = line.split(" ");
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String warn : split) {
            if (warns.containsKey(warn)){
                boolean flag = false;
                for (int i = 0; i < split.length; i++) {
                    if (warns.get(warn).contains(split[i])){
                        flag = true;
                        break;
                    }
                }
                if (flag == false){
                    stringJoiner.add(warn);
                }
            }else{
                stringJoiner.add(warn);
            }
        }
        System.out.println(stringJoiner);
    }
}
