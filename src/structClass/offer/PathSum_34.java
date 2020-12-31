package structClass.offer;

import structClass.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * link:https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * @Author: jiabin.wang
 * @Date: 2020/12/21 10:16
 */
public class PathSum_34 {

    static List<List<Integer>> res = new ArrayList<>();
    public static List<List<Integer>> pathSum(TreeNode root,int sum){
        if(null == root)return new ArrayList<>();
        if(sum - root.val < 0)return new ArrayList<>();
        dfs(null,root,sum);
        return res;
    }
    static void dfs(List<Integer> temp,TreeNode root,int sum){
        if(null == root)return;
        if(temp==null){
            temp = new ArrayList<>();
        }
        temp.add(root.val);
        if(root.left == null && root.right==null&& sum-root.val == 0){
            res.add(new ArrayList<>(temp));
        }
        dfs(temp,root.left,sum-root.val);
        dfs(temp,root.right,sum-root.val);
        temp.remove(temp.size()-1);
    }
}
