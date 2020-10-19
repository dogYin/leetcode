package structClass.TwoPoninter;

/**
 * @Description:
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * 示例 1:
 *
 * 输入: "aba"
 * 输出: True
 * 示例 2:
 *
 * 输入: "abca"
 * 输出: True
 * 解释: 你可以删除c字符。
 *
 * @Author: jiabin.wang
 * @Date: 2020/10/14 11:09
 */
public class ValidPalindrome_II_680 {


    public static boolean validPalindrome(String s) {
        int low = 0;
        int high = s.length()-1;
        while(low<high){
            if(s.charAt(low) == s.charAt(high)){
                low++;
                high--;
            }else{
                return delHighOrLow(low+1,high,s) || delHighOrLow(low,high-1,s);
            }
        }
        return true;
    }

    private static boolean delHighOrLow(int low,int high,String s){
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("deee"));
    }
}
