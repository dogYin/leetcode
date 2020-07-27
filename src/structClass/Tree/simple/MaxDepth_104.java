package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最大深度 3 。
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/27 16:49
 */
public class MaxDepth_104 {

    public static int test(TreeNode root){
        if(null== root)return 0;
        int left = test(root.left);
        int right = test(root.right);
        return Math.max(left,right)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        System.out.println(test(root));
    }

}
