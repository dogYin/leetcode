package structClass.LinkedList.simple;

/**
 * @Description: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/22 9:24
 */
public class MinArray {

    public static int test(int[] numbers){
        if(numbers.length<1){
            return -1;
        }
        if(numbers.length == 1){
            return numbers[0];
        }
        for (int i=0;i<numbers.length-1;i++){
            int end = numbers[i];
            int pre = numbers[i+1];
            if(pre<end){
                return pre;
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {
        int[] numbers = {1,2,3};
        System.out.println(test(numbers));
    }
}
