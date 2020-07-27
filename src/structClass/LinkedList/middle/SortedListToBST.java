package structClass.LinkedList.middle;

import structClass.util.*;


/**
 * @Description:
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/24 10:32
 */
public class SortedListToBST {


    public static TreeNode test(ListNode head){
        if(null == head || null == head.next){
            return head==null?null:new TreeNode(head.val);
        }
        return temp(head,null);
    }

    public static TreeNode temp(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        ListNode slow = head;
        ListNode fast= head;
        while (fast!=tail&&fast.next !=tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = temp(head,slow);
        root.right = temp(slow.next,tail);
        return root;
    }

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(-10, -3, 0, 5, 9);
        PrintTreeNode.print(test(node), BTreePrintEnum.PRE);
    }
}
