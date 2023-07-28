package leetcode_51_100;

public class Q80 {
    public static int removeDuplicates(int[] nums) {
        int res = 0;
        if (nums.length <= 2) return 0;
        //双指针
        int i = 0;
        int j = 0;
        int currNum = nums[0];
        int currSum = 0;
        int len = nums.length;
        while (i < len){
            if (nums[i] == currNum){
                if (currSum == 2){
                    //开始去重

                    if ( (j = Math.min(i+1,nums.length)) == nums.length ){//是最后一个
                        len--;
                    }else{
                        int temp = i;
                        while (j < len && nums[j] == currNum){
                            j++;
//                            len--;
                        }
                        int sub = j - i;
                        for (int k = j; k < len; k++,i++) {
                            nums[i] = nums[k];
                        }
                        i = temp-1;
                        len -= sub;
                    }
                }else{
                    currSum++;
                }
            }else{
                currNum = nums[i];
                currSum = 1;
            }
            i++;
        }
        for (int k = 0; k < nums.length; k++) {
            System.out.print(nums[k]+" ");
        }
        System.out.println();
        return len;
    }
    public static void main(String[] args) {
        int[] nums ={0,1,2,2,2,2,2,3,4,4,4};
        int res = removeDuplicates(nums);
        System.out.println(res);
    }
}
