package csdn.stringProblem;

import java.util.*;

public class P1_15 {
    public static void main(String[] args) {
        String dic = "fhe furthest,distance in.the world,life death?in front!";
        String key = "f";
        Scanner scanner = new Scanner(System.in);
        dic =scanner.nextLine();
        key =scanner.nextLine();

        StringJoiner stringJoiner = new StringJoiner(" ");

        String regx = "[^a-zA-z]";
        String[] strings = dic.split(regx);
        TreeSet<String> treeSet = new TreeSet<>();
        Collections.addAll(treeSet,strings);
        for (String s : treeSet) {
            if (s.startsWith(key)){
                stringJoiner.add(s);
            }
        }

        if (stringJoiner.length() == 0){
            System.out.println(key);
        }else{
            System.out.println(stringJoiner);
        }


    }
}
