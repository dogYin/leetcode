package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * 给定一个二叉树，检查它是否是镜像对称的。
 *
 *  
 *
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *  
 *
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *  
 *
 * 进阶：
 *
 * 你可以运用递归和迭代两种方法解决这个问题吗？
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/27 15:25
 */
public class IsSymmetric_101 {

    public static boolean test(TreeNode root){
        if(null==root)return true;
        return judge(root.left,root.right);
    }

    public static boolean judge(TreeNode l,TreeNode r){
        if(null == l && null == r)return true;
        if(null == l || null == r)return false;
        if(l.val!=r.val)return false;
        return judge(l.left,r.right)&&judge(l.right,r.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3,new TreeNode(4),new TreeNode(5));
        root.right = new TreeNode(3,new TreeNode(5),new TreeNode(4));
        System.out.println(test(root));
    }
}
