package structClass.Tree.simple;

import structClass.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 * 示例:
 *
 * 输入:
 *
 *    1
 *  /   \
 * 2     3
 *  \
 *   5
 *
 * 输出: ["1->2->5", "1->3"]
 *
 * 解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
 *
 * @Author: jiabin.wang
 * @Date: 2020/8/3 15:56
 */
public class BinaryTreePaths_257 {
    public static List<String> binaryTreePaths(TreeNode root){
        if(root==null)return new ArrayList<>();
        List<String> ANS = new ArrayList<>();
        getPath(root,"",ANS);
        return ANS;
    }

    private static void getPath(TreeNode root,String path,List<String> ans){
        if(null!=root){
            path+= root.val;
            if(null==root.left && null == root.right){
                ans.add(path);
            }else {
                path+="->";
                getPath(root.left,path,ans);
                getPath(root.right,path,ans);
            }
        }

    }
}
