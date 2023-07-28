package DS_java.BinTreeDemo;



public class binarySearchTest {

    static int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static int binarySearch(int target){
        int index = -1;
        int lo = 0;
        int hi = nums.length;
        while (lo < hi){
            int mid = (lo+hi)/2;
            if (target < nums[mid]){
                hi = mid;
            }else if(nums[mid] < target){
                lo = mid;
            }else{
                return mid;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(5));
    }
}
