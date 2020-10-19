package structClass.LinkedList.simple;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 两数之和
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 *
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 *
 * 示例:
 *
 * 输入: numbers = [2, 7, 11, 15], target = 18
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/20 15:08
 */
public class  TwoSum {


    /**
     * 使用map解决
     * @param numbers
     * @param target
     * @return
     */
    public static int[] test1(int[] numbers ,int target){
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        int size = numbers.length;
        for (int i = 0;i < size;i++){
            int temp = target - numbers[i];
            if(map.containsKey(temp)){
                res[0] = i+1;
                res[1] = map.get(temp);
            }else {
                map.put(numbers[i],i+1);
            }
        }
        return res;
    }

    /**
     * 双指针
     * @param numbers
     * @param target
     * @return
     */
    public static int[] test2(int[] numbers ,int target){
        int low = 0;
        int high = numbers.length -1;
        while (low<high){
            int temp = numbers[low] + numbers[high];
            if(target == temp){
                return new int[]{low+1,high+1};
            }else if(temp < target){
                ++low;
            }else {
                --high;
            }
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 18;
        System.out.println(test2(numbers, target)[0]+"-"+test2(numbers, target)[1]);
    }
}
