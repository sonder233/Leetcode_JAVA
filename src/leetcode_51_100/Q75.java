package leetcode_51_100;

public class Q75 {
    public void sortColors(int[] nums) {
        //冒泡排序
        int n = nums.length;
        boolean sorted = false;
        while (!sorted){
            sorted = true;
            for (int i = 1; i < n; i++) {
                if (nums[i-1] > nums[i]){
                    int tmp = nums[i-1];
                    nums[i-1] = nums[i];
                    nums[i] = tmp;
                    sorted = false;
                }
            }
            n--;
        }

    }
    public static void main(String[] args) {

    }
}
