package csdn.stringProblem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1_18 {
    public static void main(String[] args) {
        String line = "AbCdeFG";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        int k = 3;
        k = scanner.nextInt();

        List<Character> characterList = new ArrayList<>();
        for (int i = 0; i < line.length(); i++) {
            characterList.add(line.charAt(i));
        }

        characterList.sort(Character::compareTo);
        k = Math.min(characterList.size(),k);
        System.out.println(line.indexOf(characterList.get(k-1)));







    }
}
