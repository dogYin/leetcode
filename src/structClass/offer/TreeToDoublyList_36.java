package structClass.offer;

import structClass.util.TwoWayNode;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/23 10:54
 */
public class TreeToDoublyList_36 {

    /**
     * @param root
     * @return
     */
    static TwoWayNode head,tail;
    public static TwoWayNode treeToDoublyList(TwoWayNode root){
        if(null == root)return null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return root;
    }

    static void dfs(TwoWayNode node){
        if(null == node)return;
        dfs(node.left);
        if(null == tail){
            head = node;
        }else {
            tail.right = node;
            node.left = tail;
        }
        tail = node;
        dfs(node.right);
    }
}
