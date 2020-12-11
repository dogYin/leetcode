package structClass.offer;

/**
 * @Description:
 *
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。



示例 1：

输入：s = "We are happy."
输出："We%20are%20happy."


限制：

0 <= s 的长度 <= 10000
 * @Author: jiabin.wang
 * @Date: 2020/12/7 18:30
 */
public class ReplaceSpace_05 {

    private static String replaceSpace(String s){
        StringBuilder builder = new StringBuilder();
        for (Character c :s.toCharArray()){
            if(c == ' '){
                builder.append("20%");
            }else {builder.append(c);}
        }
        return builder.toString();
    }
}
