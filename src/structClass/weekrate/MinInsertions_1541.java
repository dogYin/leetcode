package structClass.weekrate;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/20 12:09
 */
public class MinInsertions_1541 {

    public static int minInsertions(String s){
        if(null == s || "".equals(s))return -1;
        int left = 0;
        int res = 0;
        int i = 0;
        while (i<s.length()){
            if (s.charAt(i) == '(') {
                left ++;
                i++;
            } else if (s.charAt(i) == ')') {
                if (i+1<s.length()  && s.charAt(i+1) == ')') {
                    if(left>0){
                        left--;
                    }else {
                        res++;
                    }
                    i+=2;
                } else {
                    if(left>0){
                        left--;
                        res++;
                    }else {
                        res += 2;
                    }
                    i++;
                }
            }else {
                i++;
            }
        }
        res+= left*2;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(minInsertions("(()))")); //1
        System.out.println(minInsertions("())")); //0
        System.out.println(minInsertions("))())(")); //3
        System.out.println(minInsertions("((((((")); //12
        System.out.println(minInsertions(")))))))")); //5
        System.out.println(minInsertions("((  ))) ((  )))   ()())))")); //4
    }
}
