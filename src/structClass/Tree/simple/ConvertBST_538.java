package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 *
 *  
 *
 * 例如：
 *
 * 输入: 原始二叉搜索树:
 *               5
 *             /   \
 *            2     13
 *
 * 输出: 转换为累加树:
 *              18
 *             /   \
 *           20     13
 *
 * @Author: jiabin.wang
 * @Date: 2020/8/6 15:37
 */
public class ConvertBST_538 {

    private int sum;
    public TreeNode convertBST(TreeNode root){
        if(root==null)return null;
        convertBST(root.right);
        sum += root.val;
        root.val = sum;
        convertBST(root.left);
        return root;
    }


}
