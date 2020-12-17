package structClass.everyday;

/**
 * @Description:
 *
 * link: https://leetcode-cn.com/problems/monotone-increasing-digits/
 * @Author: jiabin.wang
 * @Date: 2020/12/15 10:32
 */
public class MonotoneIncreasingDigits_201215 {

    public static int monotoneIncreasingDigits(int N){
        while (true){
            String s = Integer.toString(N);
            boolean flag = true;
            int i;
            for ( i = 0;i<s.length();i++){
                if(i > 0 && Integer.valueOf(s.charAt(i)).intValue() <  Integer.valueOf(s.charAt(i-1)).intValue() ){
                    flag = false;
                    break;
                }
            }
            if(flag){
                break;
            }
            N--;
        }
        return N;
    }

    public static int montoneIncreasingDigits(int N){
        if(N <10 )return N;
        char[] chars = Integer.toString(N).toCharArray();
        int flag = chars.length;
        for (int i =chars.length -1 ;i > 0;i--){
            if(chars[i] <  chars[i-1]){
                chars[i]--;
                flag = i;
            }
        }
        for (int j = flag; j < chars.length;j++){
            chars[j] = '9';
        }
        return Integer.valueOf(new String(chars));
    }

    public static void main(String[] args) {
        String s = "89";
        char[] chars = s.toCharArray();
        System.out.println(--chars[1]);
        System.out.println(montoneIncreasingDigits(100));
    }
}
