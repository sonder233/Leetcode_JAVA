package csdn.stringProblem;

import java.util.*;

public class P1_28 {
    public static void main(String[] args) {
        String line = "My sister is in the house not in the yard";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();

        TreeMap<String,Integer> map = new TreeMap<>();
        String[] split = line.split(" ");
        for (String word : split) {
            String sortWord = getSortWord(word);
            if (map.containsKey(sortWord)){
                map.replace(sortWord,map.get(sortWord)+1);
            }else{
                map.put(sortWord,1);
            }
        }

        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a,b) -> {
            if (a.getValue() != b.getValue()){
                return b.getValue() - a.getValue();
            }else{
                if (a.getKey().length() != b.getKey().length()){
                    return a.getKey().length() - b.getKey().length();
                }else{
                    return a.getKey().compareTo(b.getKey());
                }
            }
        });

        StringJoiner sj = new StringJoiner(" ");
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 1){
                for (int i = 0; i < entry.getValue(); i++) {
                    sj.add(entry.getKey());
                }
            }else{
                sj.add(entry.getKey());
            }
        }
        System.out.println(sj);




    }
    public static String getSortWord(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
