package structClass.Tree.simple;

import structClass.util.BTreePrintEnum;
import structClass.util.PrintTreeNode;
import structClass.util.TreeNode;

/**
 * @Description:
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/30 14:05
 */
public class SortedArrayToBST_108 {

    public static TreeNode test(int[] nums){
        if(nums.length==0 || nums.length == 1){
            return nums.length == 0 ? null : new TreeNode(nums[0]);
        }
        return dfs(nums,0,nums.length-1);
    }

    private static TreeNode dfs(int[] nums,int lo,int high){
        if(lo>high){
            return null;
        }
        int mid = lo + (high-lo)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = dfs(nums,lo,mid-1);
        root.right = dfs(nums,mid+1,high);
        return root;
    }


    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        PrintTreeNode.print(test(nums), BTreePrintEnum.PRE);
    }
}
