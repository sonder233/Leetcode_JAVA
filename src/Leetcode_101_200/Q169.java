package Leetcode_101_200;

import java.util.HashMap;
import java.util.Map;

public class Q169 {
    public static void main(String[] args) {

    }
    public int majorityElement(int[] nums) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int target = nums.length/2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > target){
                result = entry.getKey();
            }
        }
        return result;
    }
}
