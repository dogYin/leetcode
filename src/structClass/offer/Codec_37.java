package structClass.offer;

import structClass.util.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/23 16:28
 */
public class Codec_37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(null == root)return "";
        StringBuilder builder = new StringBuilder();
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            TreeNode node = deque.pop();
            builder.append(node==null?"null": node.val);
            if(node!=null) {
                deque.add(node.left);
                deque.add(node.right);
            }
        }
        return builder.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(null == data || "".equals(data))return null;
        TreeNode root = new TreeNode(data.charAt(0));
        return root;
    }
}
