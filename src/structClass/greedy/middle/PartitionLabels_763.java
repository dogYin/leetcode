package structClass.greedy.middle;

import java.util.List;

/**
 * @Description:
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 *  
 *
 * 示例：
 *
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *  
 *
 * 提示：
 *
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 *
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * @Author: jiabin.wang
 * @Date: 2020/11/9 10:44
 */
public class PartitionLabels_763 {

    private static List<Integer> partitionLabels(String S){
        return null;
    }

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= 255; i++) {
            builder.append("我");
        }
        System.out.println(builder.toString());
    }
}
