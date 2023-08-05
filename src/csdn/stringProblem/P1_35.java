package csdn.stringProblem;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class P1_35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String key = scanner.nextLine();
        String regex = "[0-9a-f]+";
        String[] valid = line.split(regex);
        int number = getNumber(key);
        String[] res = Arrays.stream(valid).filter(v -> !"".equals(v) && getNumber(v) <= number)
                .toArray(String[]::new);
        if (res.length == 0) {
            System.out.println("Not Found");
            return;
        }

        Arrays.sort(res,(a,b) ->{
            int n_1 = getNumber(a);
            int n_2 = getNumber(b);
            if (n_1 != n_2){
                return n_2 - n_1;
            }else{
                return b.compareTo(a);
            }
        });

        System.out.println(res[0]);


    }

    private static int getNumber(String key) {
        HashSet<Character> set = new HashSet<>();
        for (char c : key.toCharArray()) {
            set.add(c);
        }
        return set.size();
    }
}
