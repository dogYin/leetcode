package structClass.Tree.simple;

import structClass.util.TreeNode;

import javax.swing.table.TableRowSorter;

/**
 * @Description:
 * 给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
 *
 * 示例 1:
 * 给定的树 s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 true，因为 t 与 s 的一个子树拥有相同的结构和节点值。
 *
 * 示例 2:
 * 给定的树 s：
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * 给定的树 t：
 *
 *    4
 *   / \
 *  1   2
 * 返回 false。
 *
 * 链接：https://leetcode-cn.com/problems/subtree-of-another-tree
 * @Author: jiabin.wang
 * @Date: 2020/10/29 11:27
 */
public class IsSubtree_572 {

    public boolean isSubTree(TreeNode s ,TreeNode t){
        if(null == s )return false;
        return isEquals(s,t)|| isSubTree(s.left,t) || isSubTree(s.right,t);
    }
    private boolean isEquals(TreeNode s,TreeNode t){
        if(null == s && null == t)return true;
        if(null == s || null == t)return false;
        if(s.val!=t.val)return false;
        return isEquals(s.left,t.left) && isEquals(s.right,t.right);
    }
}
