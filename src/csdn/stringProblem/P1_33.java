package csdn.stringProblem;

import java.util.*;

public class P1_33 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());
        String[] dic = new String[N];
        for (int i = 0; i < N; i++) {
            dic[i] = scanner.nextLine();
        }
        String key = scanner.nextLine();
        List<String> res = new ArrayList<>();
        for (String word : dic) {
            if (isFamiliar(key,word)){
                res.add(word);
            }
        }
        res.sort(String::compareTo);
        StringJoiner stringJoiner = new StringJoiner(" ");
        for (String word : res) {
            stringJoiner.add(word);
        }
        if (stringJoiner.length() == 0){
            System.out.println("null");
        }else{
            System.out.println(stringJoiner);
        }
    }

    public static boolean isFamiliar(String key, String word){
        if (key.length() != word.length()) return false;
        if (key == word) return true;
        char[] keyChar = key.toCharArray();
        char[] wordChar = word.toCharArray();
        Arrays.sort(keyChar);
        Arrays.sort(wordChar);
        if (new String(keyChar).compareTo(new String(wordChar)) == 0){
            return true;
        }else{
            return false;
        }
    }

}
