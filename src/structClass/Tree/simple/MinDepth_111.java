package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回它的最小深度  2.
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/30 16:12
 */
public class MinDepth_111 {

    public static int test(TreeNode root){
        if(null == root)return 0;
        return root.left==null|| root.right ==null ? test(root.left) + test(root.right)+ 1 : Math.min(test(root.left),test(root.right))+1;
    }
}
