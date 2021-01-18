package structClass.greedy.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * 非递增顺序的最小子序列
 *
 * @link: https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
 * @Author: jiabin.wang
 * @Date: 2021/1/12 15:13
 */
public class MinSubsequence_1403 {

    static List<Integer> minSubsequence(int[] nums){
        List<Integer> res = new ArrayList<>();
        if(nums.length == 1){
            res.add(nums[0]);
            return res;
        }
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        int temp = 0;
        for (int i = nums.length -1; i >= 0; i--) {
            res.add(nums[i]);
            sum  -= nums[i];
            temp += nums[i];
            if(temp > sum)break;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minSubsequence(new int[]{8,8}));
    }
}
