package csdn.stringProblem;

import java.util.*;

public class OD51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        String firstLine =sc.nextLine();
//        String secondLine = sc.nextLine();
        String firstLine ="bdni,wooood";
        String secondLine = "bind,wrong,wood";
//        List<String> words = new ArrayList<>();
        List<int[]> dic = new ArrayList<>();
        StringJoiner sj = new StringJoiner(",","","");
        String[] words = firstLine.split(",");
        String[] split = secondLine.split(",");
        for (String s : split) {
            int[] al = new int[26];
            for (char c : s.toCharArray()) {
                al[c - 'a'] = 1;
            }
            dic.add(al);
        }
        for (String word : words) {
            List<Integer> indexes = isMatched(word,dic);
            if (!indexes.isEmpty()){
                for (Integer index : indexes) {
                    sj.add(split[index]);
                }
            }else{
                sj.add("not found");
            }
        }
        System.out.println(sj.toString());
        sc.close();
    }

    public static List<Integer> isMatched(String a, List<int[]> dic){
        List<Integer> indexes = new ArrayList<>();
        int[] curr = new int[26];
        for (char c : a.toCharArray()){
            curr[c - 'a'] = 1;
        }
        for(int i = 0; i<dic.size();i++){
            if (Arrays.equals(curr,dic.get(i))){
                indexes.add(i);
            }
        }
        return indexes;
    }
}
