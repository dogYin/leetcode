package structClass.offer;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * @Author: jiabin.wang
 * @Date: 2020/12/14 10:24
 */
public class IsSubStructure_26 {
    public static boolean isSubStructure(TreeNode A,TreeNode B){
        if(null == B)return false;
        return isEquals(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);
    }
    private static boolean isEquals(TreeNode A,TreeNode B){
        if(null == A && null == B) return true;
        if(null == A || null == B) return false;
        if(A.val != B.val)return false;
        return isEquals(A.left,B.left) && isEquals(A.right,B.right);
    }
}
