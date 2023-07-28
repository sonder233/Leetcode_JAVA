package Leetcode_0_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        Map<Integer,String> phoneMap = new HashMap<>();
        phoneMap.put(2,"abc");
        phoneMap.put(3,"def");
        phoneMap.put(4,"ghi");
        phoneMap.put(5,"jkl");
        phoneMap.put(6,"mno");
        phoneMap.put(7,"pqrs");
        phoneMap.put(8,"tuv");
        phoneMap.put(9,"wxyz");
        backtrack(phoneMap,res,digits,0,new StringBuilder());

        return res;
    }
    public void backtrack(Map<Integer,String> map,List<String> result,
                          String digits,int index,StringBuilder stringBuilder){
        if (index==digits.length()){
            result.add(stringBuilder.toString());
            return;
        }
        int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String letters = map.get(digit);
        int letterCount = letters.length();
        for (int i=0;i<letterCount;i++){
            stringBuilder.append(letters.charAt(i));
            backtrack(map, result, digits, index+1,stringBuilder);
            stringBuilder.deleteCharAt(index);
        }
    }
    public static void main(String[] args) {

    }
}
