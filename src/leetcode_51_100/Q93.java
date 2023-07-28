package leetcode_51_100;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Q93 {
    static List<String> result;
    static List<String> path;
    public static List<String> restoreIpAddresses(String s) {
        if (s.length() > 12 || s.length() < 4){
            return result;
        }
        result = new ArrayList<>();
        path = new ArrayList<>();
        backtrack(0,4,s);
        return result;
    }
    static void backtrack(int begin, int residue, String s){
        if (begin == s.length()){
            if (residue == 0){
                result.add(String.join(",",path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if ( begin >= s.length()){
                break;
            }
            if (s.length() - i > residue * 3 ){
                continue;
            }
            if (judgeIpSegment(s,begin,i)){
                String currentIpSegment = s.substring(begin, i + 1);
                path.add(currentIpSegment);
                backtrack(i + 1, residue - 1, s);
                path.remove(path.size()-1);
            }
        }
    }
    static boolean judgeIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') {
            return false;
        }

        int res = 0;
        while (left <= right) {
            res = res * 10 + s.charAt(left) - '0';
            left++;
        }

        return res >= 0 && res <= 255;
    }

    static boolean judgeIp(String ip){
        //判断ip
        System.out.println("判断ip: " + ip);
        if (ip.length() > 1 && ip.charAt(0) == '0'){
            return false;
        }
        int int_ip = Integer.parseInt(ip);
        return int_ip >=0 && int_ip <= 255;

    }

    public static void main(String[] args) {

        System.out.println(restoreIpAddresses("25525511135"));
    }
}
