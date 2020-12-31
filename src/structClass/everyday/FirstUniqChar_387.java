package structClass.everyday;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/23 10:05
 */
public class FirstUniqChar_387 {

    public static int firstUniqChar(String s){
        if(null == s || "".equals(s))return -1;
        Map<Character,Integer> map = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer integer = map.get(c);
            if(null == integer){
                map.put(c,1);
            }else {
                map.put(c,integer+1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            Integer temp = map.get(s.charAt(i));
            if(temp == 1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
