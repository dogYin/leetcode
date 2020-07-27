package structClass.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/7/24 17:42
 */
public class PrintTreeNode {

    static final List<Integer> NODE_S = new ArrayList<>();

    /**
     * 中序遍历
     * @param treeNode
     */
    private static void middle(TreeNode treeNode){
        if(null == treeNode){
            return;
        }
        if(null!= treeNode.left) {
            middle(treeNode.left);
        }
        NODE_S.add(treeNode.val);
        if(null!=treeNode.right) {
            middle(treeNode.right);
        }
    }


    private static void pre(TreeNode treeNode){
        if(null == treeNode){
            return;
        }
        NODE_S.add(treeNode.val);
        pre(treeNode.left);
        pre(treeNode.right);
    }

    private static void after(TreeNode treeNode){
        if(null == treeNode){
            return;
        }
        after(treeNode.left);
        after(treeNode.right);
        NODE_S.add(treeNode.val);
    }

    public static void print(TreeNode treeNode,BTreePrintEnum printEnum){
        switch (printEnum){
            case PRE:
                pre(treeNode);
                break;
            case MIDDLE:
                middle(treeNode);
                break;
            case AFTER:
                after(treeNode);
            default:
                System.out.println("乱七八糟的");

        }
        System.out.println(NODE_S.stream().map(x -> String.valueOf(x)).collect(Collectors.joining(",")));
    }
}
