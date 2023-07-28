package Leetcode_0_50;

public class Q28 {
    public int strStr(String haystack, String needle) {
        int index = 0;
        if (!haystack.contains(needle)){
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {

    }
}
