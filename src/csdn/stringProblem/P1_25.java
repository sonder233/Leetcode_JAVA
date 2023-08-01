package csdn.stringProblem;


import com.alibaba.druid.sql.visitor.functions.Char;

import java.util.*;

public class P1_25 {
    public static void main(String[] args) {
        String line = "xyxyXX";
        Scanner scanner = new Scanner(System.in);
        line = scanner.nextLine();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (map.containsKey(c)){
                map.replace(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        StringBuilder sb =new StringBuilder();
        map.entrySet().stream()
                .sorted((a,b)->{
                    if (a.getValue() != b.getValue()){
                        return b.getValue() - a.getValue();
                    }else{
                        if ((Character.isLowerCase(a.getKey()) && Character.isLowerCase(b.getKey())) ||
                                (Character.isUpperCase(a.getKey()) && Character.isUpperCase(b.getKey()))
                        ){
                            return a.getKey() - b.getKey();
                        }else{
                            if (Character.isUpperCase(a.getKey())){
                                return 1;
                            }else{
                                return -1;
                            }
                        }
                    }
                })
                .forEach(entry ->{
                    sb.append(entry.getKey()+":"+entry.getValue()+";");
                });
        System.out.println(sb);




    }
}
