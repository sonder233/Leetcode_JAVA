package Leetcode_0_50;

public class Q33_rev {

    public int search(int[] nums, int target) {
        //将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。
        //此时有序部分用二分法查找。无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
        int left = 0;
        int right = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] == target){
                return mid;
            }
            if (nums[0] <= nums[mid] ){
                //mid处在有序的那部分
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else{
                //mid处于另一半不确定的部分
                if (nums[mid] < target && target <= nums[nums.length-1]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }

        }


        return -1;
    }

    public static void main(String[] args) {

    }
}
