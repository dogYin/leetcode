package structClass.LinkedList.middle;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description: 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/21 16:18
 */
public class SwapPairs {


    public static ListNode test(ListNode head){
        if(null == head || null == head.next)return head;
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode pre = tempNode;
        ListNode curr = head;
        while (curr!=null){
            ListNode next = curr.next;
            ListNode nextNext = next.next;
            pre.next = next;
            next.next = curr;
            curr.next = nextNext;
            pre =curr;
            curr = nextNext;
        }
        return head;
    }




    public static void main(String[] args){
        ListNode node = GenerateListNode.generate(1, 2, 3, 4);
        PrintListNode.print(test(node));
    }
}
