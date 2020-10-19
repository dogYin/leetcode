package structClass.TwoPoninter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 *
 *  
 *
 * 示例 1：
 *
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 *
 * 输入："leetcode"
 * 输出："leotcede"
 *
 * @Author: jiabin.wang
 * @Date: 2020/10/13 15:59
 */
public class ReverseVowels_345 {

    private static List<Character> list = new ArrayList<Character>(
            Arrays.asList('a','e','i','o','u','A','E','I','O','U'));

    public static String reverseVowels(String target){
        if("".equals(target) || null ==target || target.length() == 1){
            return target;
        }
        int head = 0;
        int end = target.length()-1;
        char[] res = new char[target.length()];
        while (head<=end){
            char headChar = target.charAt(head);
            char endChar = target.charAt(end);
            if(!list.contains(headChar)){
                res[head++] = headChar;
            }else if(!list.contains(endChar)){
                res[end--] = endChar;
            }else {
                res[end--] = headChar;
                res[head++] = endChar;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
