package csdn.stringProblem;

import java.util.*;

public class P1_24 {

    public static void main(String[] args) {
        String line = "1,2,5,-21,22,11,55,-101,42,8,7,32";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        String[] split = line.split(",");
        List<String> list = new ArrayList<>();
        Collections.addAll(list,split);
        list.sort( (a,b) -> {
            int n_a = a.charAt(a.length()-1);
            int n_b = b.charAt(b.length()-1);
            return n_a - n_b;
        });
        StringJoiner sj = new StringJoiner(",");
        for (String s : list) {
            sj.add(s);
        }
        System.out.println(sj);

    }
}
