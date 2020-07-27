package structClass.util;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/7/20 17:20
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(){

    }

    public TreeNode(int x){
        this.val = x;
    }

    public TreeNode(int x,TreeNode left,TreeNode right){
        this.val = x;
        this.left = left;
        this.right = right;
    }
}
