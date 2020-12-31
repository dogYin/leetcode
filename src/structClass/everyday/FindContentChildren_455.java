package structClass.everyday;

import java.util.Arrays;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/25 13:41
 */
public class FindContentChildren_455 {

    static int findContentChildren(int[] g,int[] s){
        if(null == s || s.length ==0)return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int res =0;
        int j = 0;
        for (int i=0;i<g.length;i++){
            if(j< s.length &&  g[i]<=s[j]){
                res++;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{1,1}));
        System.out.println(findContentChildren(new int[]{1,2,3},new int[]{3}));
    }
}
