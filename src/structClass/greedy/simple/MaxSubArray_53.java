package structClass.greedy.simple;

/**
 * @Description:
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-subarray
 * @Author: jiabin.wang
 * @Date: 2020/11/9 10:20
 */
public class MaxSubArray_53 {

    private static int maxSubArray(int[] nums){
        if(null == nums ||nums.length == 0)return 0;
        int res = nums[0],sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = Math.max(sum+nums[i],nums[i]);
            res = Math.max(sum,res);
            System.out.printf("第"+i+"次：sum:%d,res:%d ",sum,res);
            System.out.println();
        }
        return res;
    }

    public static void main(String[] args) {
        maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
    }
}
