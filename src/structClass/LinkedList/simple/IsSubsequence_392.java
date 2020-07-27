package structClass.LinkedList.simple;

/**
 * @Description:
 *
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 *
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 *
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 *
 * 示例 1:
 * s = "abc", t = "ahbgdc"
 *
 * 返回 true.
 *
 * 示例 2:
 * s = "axc", t = "ahbgdc"
 *
 * 返回 false.
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/27 11:46
 */
public class IsSubsequence_392 {

    public static boolean test(String s,String t){
        if(s==null|| null == t){return false;}
        if(t.length()==s.length()){
            return t.equals(s);
        }
        int j =0;
        for (int i = 0; i <t.length() ; i++) {
            if(j== s.length()){
                return true;
            }
            char tmpT = t.charAt(i);
            char tmpS = s.charAt(j);
            if(tmpT == tmpS){
                j++;
            }
        }
        if(j== s.length()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abc"; String t = "abcabc";
        System.out.println(test(s,t));
    }
}
