package structClass.Math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 *
 * 链接：https://leetcode-cn.com/problems/3sum
 * @Author: jiabin.wang
 * @Date: 2020/12/10 10:43
 */
public class ThreeSum_15 {

    public static List<List<Integer>> threeSum(int[] nums){
        if(nums == null || nums.length <3)return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>0)break;
            if(i >0 && nums[i] == nums[i-1])continue;
            int L = i+1;
            int R = nums.length-1;
            while (L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    res.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L < R && nums[L] == nums[L+1])L++;
                    while (L < R && nums[R] == nums[R-1])R--;
                    L++;
                    R--;
                }else if(sum < 0){
                    L++;
                }else if(sum > 0) {
                    R--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1, 0, 1, 2, -1, -4}).forEach(temp ->{
            temp.forEach(System.out::print);
            System.out.println();
        });
    }
}
