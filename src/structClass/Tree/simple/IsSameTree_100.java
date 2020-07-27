package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * 示例 1:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * 输出: true
 * 示例 2:
 *
 * 输入:      1          1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * 输出: false
 * 示例 3:
 *
 * 输入:       1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * 输出: false
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/27 14:38
 */
public class IsSameTree_100 {


    public static boolean test(TreeNode p, TreeNode q){
        if(null == p && null ==q)return true;
        if (null==p || null == q) return false;
        if(q.val!=p.val)return false;
        return test(p.right,q.right) && test(p.left,q.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

    }
}
