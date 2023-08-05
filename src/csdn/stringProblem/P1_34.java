package csdn.stringProblem;

import java.util.*;

public class P1_34 {
    public static void main(String[] args) {
        String line = "abczcccddzz";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        List<Character> left = new ArrayList<>();
        Set<Character> characters = map.keySet();
        String mid = "";
        for (Character c : characters) {
            int n = map.get(c);
            if (n >= 2) {
                for (int i = 0; i < n/2; i++) {
                    left.add(c);
                }
            }
            if (n % 2 == 1 && ("".equals(mid) || mid.compareTo(c + "") > 0)){
                mid = c + "";
            }
        }
        left.sort((a,b) -> a-b);
        StringBuilder sb = new StringBuilder();
        for (Character character : left) {
            sb.append(character);
        }
        String result = sb.toString() + mid + sb.reverse().toString();
        System.out.println(result);

    }
}
