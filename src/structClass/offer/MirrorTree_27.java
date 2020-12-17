package structClass.offer;

import structClass.util.BTreePrintEnum;
import structClass.util.PrintTreeNode;
import structClass.util.TreeNode;

/**
 * @Description: 镜像二叉树
 * @Author: jiabin.wang
 * @Date: 2020/12/14 19:52
 */
public class MirrorTree_27 {

    public static TreeNode mirrorTree(TreeNode root){
        if(null == root)return null;
         TreeNode left = mirrorTree(root.left);
         TreeNode right = mirrorTree(root.right);
         root.left = right;
         root.right = left;
         return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        PrintTreeNode.print(root, BTreePrintEnum.MIDDLE);
        System.out.println("--------------------");
        PrintTreeNode.print(mirrorTree(root), BTreePrintEnum.MIDDLE);
    }
}
