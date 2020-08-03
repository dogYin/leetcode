package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 *
 * 给定二叉树 [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例 2:
 *
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * 返回 false 。
 *
 *  
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/30 15:17
 */
public class IsBalanced_110 {

    public static boolean test(TreeNode root){
        if(null==root)return true;
        return Math.abs(getDept(root.left)-getDept(root.right))<=1 && test(root.left) && test(root.right);
    }

    private static int getDept(TreeNode root){
        if(null == root)return 0;
        return Math.max(getDept(root.left),getDept(root.right))+1;
    }

    public static void main(String[] args) {

    }
}
