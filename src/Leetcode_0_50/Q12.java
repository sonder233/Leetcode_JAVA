package Leetcode_0_50;

import java.util.TreeMap;

public class Q12 {
    public String intToRoman(int num) {
        String res = "";
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1,"I");
        map.put(4,"IV");
        map.put(5,"V");
        map.put(9,"IX");
        map.put(10,"X");
        map.put(40,"XL");
        map.put(50,"L");
        map.put(90,"XC");
        map.put(100,"C");
        map.put(400,"CD");
        map.put(500,"D");
        map.put(900,"CM");
        map.put(1000,"M");
        var treeMap = map.descendingMap();
        int number = num;//记录
        while (number > 0){
            for (var entry: treeMap.entrySet()) {
                int k = entry.getKey();
                String v = entry.getValue();
                if (k <= number){
                    res += v;
                    number -= k;
                    break;
                }
            }
        }

//        System.out.println(treeMap);
        return res;
    }
    public static void main(String[] args) {
        Q12 q12 = new Q12();
        System.out.println(q12.intToRoman(9));
    }
}
