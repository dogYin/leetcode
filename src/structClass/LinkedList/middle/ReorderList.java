package structClass.LinkedList.middle;

import structClass.LinkedList.simple.ReverseList;
import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description:
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 *
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 * 示例 2:
 *
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/25 13:34
 */
public class ReorderList {

    /**
     * 思路 ： 翻转 -> 合并
     * @param head
     * @return
     */
    public static void test(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        //拆分后的后半段
        ListNode end = slow.next;
        //将前半段和后半段斩开
        slow.next = null;

        //翻转后半段
        ListNode pre = null;
        ListNode curr = end;
        while (curr!=null){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = pre;
            pre = temp;
        }

        //合并
        while (pre!=null){
            ListNode change = pre.next;
            pre.next = head.next;
            head.next = pre;
            head = pre.next;
            pre = change;
        }
    }


    

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(1, 2, 3, 4,5,6);
        test(node);
    }
}
