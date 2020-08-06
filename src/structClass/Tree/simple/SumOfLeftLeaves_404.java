package structClass.Tree.simple;

import structClass.util.TreeNode;

/**
 * @Description:
 *
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/8/5 17:29
 */
public class SumOfLeftLeaves_404 {

    static int ans = 0;

    public static int sumOfLeftLeaves(TreeNode root){
        if(null == root)return 0;

        if(root.left!=null&& root.left.left == null && root.left.right==null)ans+=root.left.val;

        sumOfLeftLeaves(root.left);
        sumOfLeftLeaves(root.right);
        return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9,new TreeNode(15),new TreeNode(7));
        root.right = new TreeNode(20);
        System.out.println(sumOfLeftLeaves(root));
    }
}
