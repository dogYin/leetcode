package structClass.offer;

import structClass.util.TreeNode;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/15 10:06
 */
public class IsSymmetric_28 {


    public static boolean isSymmetric(TreeNode root){
        if(null == root)return true;
        return isEquals(root.left,root.right);
    }
    private static boolean isEquals(TreeNode left,TreeNode right){
        if(null == left && null == right)return true;
        if(null == left || null == right)return false;
        return left.val == right.val && isEquals(left.left,right.right) && isEquals(left.right,right.left);
    }
}
