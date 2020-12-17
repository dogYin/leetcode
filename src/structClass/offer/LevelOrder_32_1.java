package structClass.offer;

import structClass.util.TreeNode;

import java.util.*;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/15 17:02
 */
public class LevelOrder_32_1 {

    public static int[] levelOrder(TreeNode root){
        if(null == root)return new int[0];
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pop();
            res.add(node.val);
            if(node.left!=null) deque.add(node.left);
            if(node.right!=null)deque.add(node.right);
        }

        return res.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        Stream.of(levelOrder(root)).forEach(System.out::print);
    }
}
