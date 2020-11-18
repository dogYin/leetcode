package structClass.dp.middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
 *
 * 若这两个字符串没有公共子序列，则返回 0。
 *
 *  
 *
 * 示例 1:
 *
 * 输入：text1 = "abcde", text2 = "ace"
 * 输出：3
 * 解释：最长公共子序列是 "ace"，它的长度为 3。
 * 示例 2:
 *
 * 输入：text1 = "abc", text2 = "abc"
 * 输出：3
 * 解释：最长公共子序列是 "abc"，它的长度为 3。
 * 示例 3:
 *
 * 输入：text1 = "abc", text2 = "def"
 * 输出：0
 * 解释：两个字符串没有公共子序列，返回 0。
 *
 * 链接：https://leetcode-cn.com/problems/longest-common-subsequence
 * @Author: jiabin.wang
 * @Date: 2020/11/16 21:07
 */
public class LongestCommonSubsequence_1143 {

    private static int longestCommonSubsequence(String text1,String text2){
        if("".equals(text1) || null == text1 || "".equals(text2) || null == text2)return 0;
        int len1 = text1.length();
        int len2 = text2.length();
        String textShort =  len1 >len2 ? text2 :text1;
        String textLong =  len1 >len2 ? text1 :text2;
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i< textShort.length();i++){
            map.put(textShort.charAt(i),i);
        }
        int res = 0;
        int preIndex = -1;
        for (int i = 0;i<textLong.length();i++){
            if(map.containsKey(textLong.charAt(i)) && map.get(textLong.charAt(i)).intValue() > preIndex){
                res++;
                preIndex = map.get(textLong.charAt(i)).intValue();
            }
        }
        return res;
    }

    public static void main(String[] args) {
        /**
         * "ezupkr"
         * "ubmrapg"
         */
        System.out.println(longestCommonSubsequence("ezupkr","ubmrapg"));
    }
}
