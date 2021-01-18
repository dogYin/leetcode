package structClass.dp.middle;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * @Author: jiabin.wang
 * @Date: 2021/1/12 16:38
 */
public class LongestPalindrome_5 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for(int i=1;i< triangle.size();i++){
            for(int j =0;j<=i;j++){
                if(j > 0)dp[i][j] =Math.min(dp[i][j],dp[i-1][j-1]+ triangle.get(i).get(j));
                if(j < i)dp[i][j] = Math.min(dp[i][j],dp[i-1][j]+ triangle.get(i).get(j));
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i =0;i< triangle.size();i++){
            res = Math.min(res,dp[triangle.size()-1][i]);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "123";
        char c = s.charAt(0);
        Integer value = Integer.valueOf(String.valueOf(c));
        System.out.println(c);
        System.out.println(value);

    }
}
