package structClass.offer;

import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description:
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *  
 *
 * 限制：
 *
 * 0 <= s 的长度 <= 50000
 *
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * @Author: jiabin.wang
 * @Date: 2020/12/8 10:40
 */
public class FirstUniqChar_50 {

    private static char firstUniqChar1(String s){
        if (s == null || "".equals(s))return ' ';
        Map<Character,Boolean>  map = new HashMap<>();
        for (Character c :s.toCharArray()) {
            map.put(c,!map.containsKey(c));
        }
        for (Character c:s.toCharArray()) {
            if(map.get(c))return c;
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
