package structClass.Tree.simple;

import structClass.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层次遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/27 17:24
 */
public class LevelOrderBottom_107 {

    public static List<List<Integer>> test(TreeNode root){
        if(null ==  root) return new ArrayList<>();
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();
            while (size>0){
                TreeNode poll = queue.poll();
                if(poll!=null) {
                    temp.add(poll.val);
                    queue.offer(poll.left);
                    queue.offer(poll.right);
                }
                size--;
            }
            ans.add(0,temp);
        }
       return ans;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20,new TreeNode(15),new TreeNode(7));
        test(root);

    }
}
