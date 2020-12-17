package structClass.offer;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/16 17:17
 */
public class VerifyPostorder_33 {

    public static boolean verifyPostOrder(int[] postorder){
        return recur(postorder,0,postorder.length-1);
    }
    static boolean recur(int[] postorder,int i ,int j){
        if(i == j)return true;
        return false;
    }
}
