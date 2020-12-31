package structClass.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/find-the-difference/
 * @Author: jiabin.wang
 * @Date: 2020/12/18 19:39
 */
public class FindTheDifference_389 {


    public static char findTheDifference(String s,String t){
       /* if( (null == s || s.length() == 0 ) && t.length() >0)return t.charAt(0);
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i < s.length();i++){
            char c = s.charAt(i);
            Integer integer = map.get(c);
            if(null == integer)map.put(c,1);
            else map.put(c,integer+1);
        }

        for (int j = 0;j<t.length();j++){
            char c = t.charAt(j);
            Integer integer = map.get(c);
            if(null == integer) {
                return c;
            }
            if(integer.intValue() == 1){
                map.remove(c);
            }else {
                map.put(c,integer-1);
            }

        }
        return ' ';*/
       return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("ae","aea"));
    }
}
