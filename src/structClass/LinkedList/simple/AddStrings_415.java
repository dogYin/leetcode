package structClass.LinkedList.simple;

/**
 * @Description:
 *
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 * 注意：
 *
 * num1 和num2 的长度都小于 5100.
 * num1 和num2 都只包含数字 0-9.
 * num1 和num2 都不包含任何前导零。
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * @Author: jiabin.wang
 * @Date: 2020/8/3 15:16
 */
public class AddStrings_415 {

    public static String addStrings(String num1,String num2){
        if(null == num1||"".equals(num1) || null == num2 || "".equals(num2)){
            return null == num1 || "".equals(num1) ? num2 : num1;
        }
        int length1 = num1.length()-1;
        int length2 = num2.length()-1;
        while (length1>=0 || length2>=0){
            int tmp1 = num1.charAt(length1);
        }
        return "";
    }

    public static void main(String[] args) {
        String s = "1234";

//        System.out.println(x);
    }
}
