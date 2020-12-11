package structClass.offer;

import structClass.util.BTreePrintEnum;
import structClass.util.PrintTreeNode;
import structClass.util.TreeNode;

    import java.util.Arrays;

/**
 * @Description:
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 *  
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *  
 *
 * 限制：
 *
 * 0 <= 节点个数 <= 5000
 *
 *  
 *
 * 链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
 * @Author: jiabin.wang
 * @Date: 2020/12/11 9:41
 */
public class BuildTree_07 {


    public static TreeNode buildTree(int[] pre,int[] in){
        int length = pre.length;
        if(length== 0)return null;
        int rootVal = pre[0],rootIndex=0;
        for (int i=0;i<length;i++){
            if(in[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(Arrays.copyOfRange(pre,1,1+rootIndex),Arrays.copyOfRange(in,0,rootIndex));
        root.right = buildTree(Arrays.copyOfRange(pre,1+rootIndex,length),Arrays.copyOfRange(in,rootIndex+1,length));
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        System.out.println(root);
    }
}
