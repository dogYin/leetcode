package structClass.TwoPoninter;

/**
 * @Description:
 *
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 *
 * 示例 1：
 *
 * 输入：c = 5
 * 输出：true
 * 解释：1 * 1 + 2 * 2 = 5
 * 示例 2：
 *
 * 输入：c = 3
 * 输出：false
 * 示例 3：
 *
 * 输入：c = 4
 * 输出：true
 * 示例 4：
 *
 * 输入：c = 2
 * 输出：true
 * 示例 5：
 *
 * 输入：c = 1
 * 输出：true
 *
 * @Author: jiabin.wang
 * @Date: 2020/10/13 15:34
 */
public class JudgeSquareSum_633 {

    public static boolean judgeSquareSum(int target){
        int head = 0;
        int top = (int) Math.sqrt(target);
        while (head<=top){
            int temp = head * head + top * top;
            if(temp == target){
                return true;
            }else if(temp > target){
                top--;
            }else {
                head++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(2));
    }
}
