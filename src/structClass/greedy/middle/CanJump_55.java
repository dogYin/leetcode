package structClass.greedy.middle;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/jump-game/
 * @Author: jiabin.wang
 * @Date: 2021/1/6 14:52
 */
public class CanJump_55 {


    public static boolean canJump(int[] nums){
        if(null == nums || nums.length ==0)return true;
        int max = 0;
        for (int i=0 ; i < nums.length && i <= max ;i++){
            max = Math.max(max,nums[i]+ i);
        }
        return max >= nums.length -1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2,3,1,1,4}));
    }
}
