package csdn.stringProblem;

import java.util.*;

public class P1_17 {
    public static void main(String[] args) {
        String tag = "31";
        String line = "32 01 00 AE 90 02 00 01 02 30 03 00 AB 32 31 31 02 00 32 33 33 01 00 CC";
        Scanner scanner = new Scanner(System.in);
        tag = scanner.nextLine();
        line = scanner.nextLine();
        String[] split = line.split(" ");


        int index = 0;

        while (index < split.length){
            String currTag = split[index++];
            String lowNum = split[index++];
            String highNum = split[index++];
            int currLen = Integer.parseInt(highNum + lowNum,16);
//            System.out.println(currTag);
//            System.out.println(currLen);
            List<String> val = new ArrayList<>();
            for (int i = 0; i < currLen; i++) {
                val.add(split[index++]);
            }
            if (currTag.equals(tag)){
                StringJoiner stringJoiner = new StringJoiner(" ");
                for (String s : val) {
                    stringJoiner.add(s);
                }
                System.out.println(stringJoiner);
                return;
            }
        }

    }
}
