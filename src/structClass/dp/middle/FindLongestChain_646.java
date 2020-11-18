package structClass.dp.middle;

import java.util.Arrays;

/**
 * @Description:
 *
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 *
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 *
 * 给定一个数对集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 *
 *  
 *
 * 示例：
 *
 * 输入：[[1,2], [2,3], [3,4]]
 * 输出：2
 * 解释：最长的数对链是 [1,2] -> [3,4]
 *  
 *
 * 提示：
 *
 * 给出数对的个数在 [1, 1000] 范围内。
 *
 * 链接：https://leetcode-cn.com/problems/maximum-length-of-pair-chain
 * @Author: jiabin.wang
 * @Date: 2020/11/16 19:11
 */
public class FindLongestChain_646 {


    private static int findLongestChain(int[][] pairs){
        if(null == pairs || pairs.length == 0)return 0;
        Arrays.sort(pairs,((o1, o2) -> o1[0]-o2[0]));
        int[] res = new int[pairs.length];
        Arrays.fill(res,1);
        int max = 0;
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if(pairs[j][1] < pairs[i][0])
                res[i] = Math.max(res[i],res[j]+1);
            }
            max = Math.max(max,res[i]);
        }
        return max;
    }

}
