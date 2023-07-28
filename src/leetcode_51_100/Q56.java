package leetcode_51_100;

import java.util.*;

public class Q56 {
    public static int[][] merge(int[][] intervals) {
        List<Pair> lists = new ArrayList<>();
        if (intervals == null) return null;
        Arrays.sort(intervals,(m,n)->m[0]-n[0]);
        lists.add(new Pair(intervals[0][0],intervals[0][1]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > lists.get(lists.size()-1).second){
                lists.add(new Pair(intervals[i][0],intervals[i][1]));
            }else{
                lists.get(lists.size()-1).second = Math.max(lists.get(lists.size()-1).second,intervals[i][1]);
            }
        }

        int[][] res = new int[lists.size()][2];
        for (int i = 0; i < lists.size(); i++) {
            res[i][0] = lists.get(i).first;
            res[i][1] = lists.get(i).second;
        }
        return res;
    }

    public static void main(String[] args) {
//        int[][] nums = {{1,3},{2,6},{8,10},{15,18}};
        int[][] nums = {{2,3},{4,5},{6,7},{8,9},{1,10}};

        int[][] res = merge(nums);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]+",");
            }
            System.out.println();
        }
    }
}
class Pair{
    public int first;
    public int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}