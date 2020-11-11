package structClass.greedy.simple;

/**
 * @Description:
 *
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 *
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 * 示例 2:
 *
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 *
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * @Author: jiabin.wang
 * @Date: 2020/11/7 11:46
 */
public class CheckPossibility_665 {

    private static boolean checkPossibility(int[] nums){
        if(null == nums || nums.length == 0)return false;
        int res = 0;
        int low = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]< low){
                res++;
                if(res>=2)return false;
                continue;
            }
            low = nums[i];
        }
        return res<=1;
    }

    public static void main(String[] args) {
        System.out.println(checkPossibility(new int[]{ 4,2,1}));
    }
}
