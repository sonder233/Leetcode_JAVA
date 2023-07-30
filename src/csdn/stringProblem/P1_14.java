package csdn.stringProblem;

import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class P1_14 {
    public static void main(String[] args) {
        String word_1 = "bach";
        String word_2 = "bbaaccedfg";
        Scanner scanner = new Scanner(System.in);
        word_1 = scanner.nextLine();
        word_2 = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();
        Set<Character> set = new TreeSet<>((a,b) -> {
            return a.compareTo(b);
        });

        for (int i = 0; i < word_1.length(); i++) {
            char c = word_1.charAt(i);
            if (word_2.contains(c+"")){
                set.add(c);
            }
        }
        for (Character character : set) {
            stringBuilder.append(character);
        }
        System.out.println(stringBuilder);

    }
}
