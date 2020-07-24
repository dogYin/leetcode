package structClass.LinkedList.simple;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description: 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 *
 * 输入: 1->1->2
 * 输出: 1->2
 *
 *示例 2:
 *
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/22 18:42c
 */
public class DeleteDuplicates {


    public static ListNode test(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode curr = head;
        while (curr!=null && curr.next!=null){
            if(curr.val==curr.next.val){
                curr.next =  curr.next.next;
            }else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(1, 1, 2,3,3);
        PrintListNode.print(test(node));
    }
}
