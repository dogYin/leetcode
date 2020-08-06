package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * 给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
 *
 *  
 *
 * 示例：
 *
 * 输入：
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * 输出：
 * 1
 *
 * 解释：
 * 最小绝对差为 1，其中 2 和 1 的差的绝对值为 1（或者 2 和 3）。
 *
 * @Author: jiabin.wang
 * @Date: 2020/8/6 15:17
 */
public class GetMinimumDifference_530 {

    private int min = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int getMinimumDifference(TreeNode root){
        inorder(root);
        return min;
    }

    private void inorder(TreeNode root){
        if(null == root)return;
        inorder(root.left);
        if(pre!=null){
            min = Math.min(min,Math.abs(pre.val-root.val));
        }
        pre = root;
        inorder(root.right);
    }
}
