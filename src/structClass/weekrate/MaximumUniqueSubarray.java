package structClass.weekrate;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/20 11:38
 */
public class MaximumUniqueSubarray {

    public static int test(int[] nums){
        if(null == nums || nums.length<1)return -1;
        int max = nums[0];
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if(i>0 &&nums[i] > nums[i-1]){
                flag = nums[i]  +flag;
            }
            max = Math.max(flag,max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(test(new int[]{4,2,4,5,6}));
    }
}
