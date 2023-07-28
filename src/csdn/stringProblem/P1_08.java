package csdn.stringProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String[] split = line.split(" ");

        String key = split[0];
        List<String> res = new ArrayList<>();
        int number = Integer.parseInt(split[1]);
        for (int i = 2; i < split.length; i++) {
            if (split[i].startsWith(key)){
                res.add(split[i]);
            }
        }

        if (res.isEmpty()){
            System.out.println(-1);
        }else{
            res.forEach(i -> {
                System.out.println(i);
            });
        }




    }
}
