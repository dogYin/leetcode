package structClass.LinkedList.middle;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

import java.util.List;

/**
 * @Description:
 *
给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3
 * @Author: jiabin.wang
 * @Date: 2020/7/23 13:54
 */
public abstract class DeleteDuplicates {

    public static ListNode test(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
      /*  ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode firstNode = tempNode;
        ListNode secondNode = head;
        test(secondNode.next);
        while (secondNode.next!=null){
            if(firstNode.next.val == secondNode.next.val){
                secondNode.next = secondNode.next.next;
                if(secondNode.val == secondNode.next.val){

                }
            }else {
                firstNode = firstNode.next;
                secondNode = secondNode.next;
            }
        }*/

        return null;
    }

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(1, 2, 3, 3, 4, 4, 5);
        PrintListNode.print(test(node));
    }
}
