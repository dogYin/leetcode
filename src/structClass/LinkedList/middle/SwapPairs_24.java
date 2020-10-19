package structClass.LinkedList.middle;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description:
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 * 输入：head = [1,2,3,4]
 * 输出：[2,1,4,3]
 *
 * 输入 head = []
 * 输出 []
 *
 * 输入 [1]
 * 输出 [1]
 * @Author: jiabin.wang
 * @Date: 2020/10/13 14:00
 */
public class SwapPairs_24 {


    public static ListNode swapPairs(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode res = new ListNode(-1);
        ListNode first = head;
        ListNode second = head.next;
        while (null != head.next){
            
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(1,2,3,4,5);
        PrintListNode.print(swapPairs(node));

    }
}
