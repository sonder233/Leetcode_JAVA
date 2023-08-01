package csdn.stringProblem;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.StringJoiner;

public class P1_21 {
    public static void main(String[] args) {
        String line = "a:3,b:5,c:2@";//a:1,b:2
//        Scanner scanner = new Scanner(System.in);
//        line = scanner.nextLine();
        String dic = line.split("@")[0];

        if (line.charAt(line.length()-1) == '@'){
            System.out.println(dic);
            return;
        }
        String used = line.split("@")[1];
        if (used.equals("")){

        }
        LinkedHashMap<String,Integer> mapDic = getMap(dic);
        LinkedHashMap<String,Integer> mapUsed = getMap(used);
        mapUsed.forEach( (key,value) -> {
            mapDic.replace(key,mapDic.get(key)-value);
        });
        StringJoiner sj = new StringJoiner(",");
        mapDic.forEach( (k,v) ->{
            if (v != 0){
                sj.add(k + ":" +v);
            }
        });

        System.out.println(sj);
    }
    public static LinkedHashMap<String,Integer> getMap(String str){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        String[] split = str.split(",");
        for (String s : split) {
            String key = s.split(":")[0];
            Integer value = Integer.parseInt(s.split(":")[1]);
            map.put(key,value);
        }
        return map;
    }
}
