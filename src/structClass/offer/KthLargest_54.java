package structClass.offer;

import structClass.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/
 * @Author: jiabin.wang
 * @Date: 2020/12/23 18:16
 */
public class KthLargest_54 {

    static List<Integer> res = new ArrayList<>();
    public static int kthLargest(TreeNode root,int k){
        if(null == root || k <=0)return -1;
        after(root);
        return res.get(k-1);
    }

    static void after(TreeNode root){
        if(null == root )return;
        after(root.right);
        res.add(root.val);
        after(root.left);

    }

    public static void main(String[] args) {
       TreeNode root = new TreeNode(3);
       root.left = new TreeNode(1);
       root.left.right = new TreeNode(2);

       root.right = new TreeNode(4);

        System.out.println(kthLargest(root,1));
    }
}
