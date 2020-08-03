package structClass.Tree.simple;

import structClass.util.TreeNode;

import javax.sound.midi.Track;

/**
 * @Description:
 *
 * 翻转一棵二叉树。
 *
 * 示例：
 *
 * 输入：
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * @Author: jiabin.wang
 * @Date: 2020/8/3 15:40
 */
public class InvertTree_226 {

    public TreeNode invertTree(TreeNode root){
        if(null== root)return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
