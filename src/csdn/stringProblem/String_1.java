package csdn.stringProblem;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class String_1 {
    static class Word{
        int id;
        String content;
        public Word(int id, String content){
            this.id = id;
            this.content = content;
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        String[] output = new String[n];
        List<Word> list = new ArrayList<>();
        Pattern pattern = Pattern.compile("([a-zA-Z]+)(\\d+)");
        for (int i = 0; i < strings.length; i++) {
            Matcher matcher = pattern.matcher(strings[i]);
            if (matcher.find()){
                String group = matcher.group(1);
                String group_2 = matcher.group(2);
                int number = Integer.parseInt(group_2);
                list.add(new Word(number,group));
            }
        }
        list.sort((a,b) -> a.id - b.id);
        StringJoiner stringJoiner = new StringJoiner(" ");
        list.forEach(i -> stringJoiner.add(i.content));
        System.out.println(stringJoiner.toString());
    }
    void basic(){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        String[] output = new String[n];
        for (int i = 0; i < n; i++) {
            String str = strings[i];
            int index = 0;
            int numberIndex = 0;
            for (int j = str.length()-1; j >= 0; j--) {
                if (!Character.isDigit(str.charAt(j))){
                    numberIndex = j+1;
                    if (j+1 ==  str.length()-1){
                        index = Integer.parseInt(str.substring(j+1))-1;
                    }else {
                        index = Integer.parseInt(str.substring(j+1,str.length()))-1;
                    }
                    break;
                }
            }
            String sub = str.substring(0,numberIndex);
            output[index] = sub;
        }
        String res = "";
        for (int i = 0; i < output.length; i++) {
            res += output[i] ;
            if (i != output.length-1) res += " ";
        }
        /*
        4
        rol3 stone4 like1 a2

        10
        sd10 sfg2 fgg8 sdf1 dfg3 fdg4 dfg5 dfg6 dty7 ser9

         */
        System.out.println(res);
    }
}
