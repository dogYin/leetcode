package structClass.LinkedList.middle;

import structClass.util.ListNode;
import structClass.util.PrintListNode;

import java.util.List;

/**
 * @Description: 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * @Author: jiabin.wang
 * @Date: 2020/7/21 13:46
 */
public class RemoveNthFromEnd {


    /**
     * 使用双指针法
     *
     * 头指针走n步 尾指针走一步当头指针走到尾部的时候尾部指针走到第n个节点
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode test(ListNode head,int n){
        if(null == head || n <=0){
            return head;
        }
        if(null == head.next ){
            return null;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode topNode = temp;
        ListNode endNode = temp;
        for (int i = 0; i <= n; i++) {
            endNode = endNode.next;
        }

        while (endNode!=null){
            topNode = topNode.next;
            endNode = endNode.next;
        }
        topNode.next = topNode.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        //1->2->3->4->5
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
       /*   node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);*/

        PrintListNode.print(test(node, 2));


    }
}
