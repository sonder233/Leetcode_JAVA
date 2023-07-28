package leetcode_51_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q57 {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> lists = new ArrayList<>();
        int i = 0;
        int len = intervals.length;
        while (i < len && intervals[i][1] < newInterval[0]){
            lists.add(intervals[i]);
            i++;
        }
        while (i < len && intervals[i][0] <= newInterval[1] ){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        lists.add(newInterval);
        while (i < len){
            lists.add(intervals[i]);
            i++;
        }

        return lists.toArray(new int[0][]);
    }
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {2,5};
        int[][] res = insert(intervals,newInterval);
        System.out.println(res);
    }
}

