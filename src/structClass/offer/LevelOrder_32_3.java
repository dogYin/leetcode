package structClass.offer;

import structClass.util.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/15 17:02
 */
public class LevelOrder_32_3 {

    public static List<List<Integer>> levelOrder(TreeNode root){
        if(null == root)return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        int flag = 1;
        int level = 1;
        while (!deque.isEmpty()){
            LinkedList<Integer> temp = new LinkedList<>();
            int x = 0;
            for (int i = 1; i <= flag; i++) {
                TreeNode node = deque.pop();
                if(level%2 ==0 ){
                    temp.addFirst(node.val);
                } else {
                    temp.addLast(node.val);
                }
                if(node.left!=null) {
                    x++;
                    deque.add(node.left);
                }
                if(node.right!=null){
                    x++;
                    deque.add(node.right);
                }
            }
            flag = x;
            res.add(temp);
            level++;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Stream.of(levelOrder(root)).forEach(temp->Stream.of(temp).forEach(System.out::print));
    }
}
