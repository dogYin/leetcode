package structClass.LinkedList.middle;

import structClass.util.ListNode;

/**
 * @Description:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 *
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/23 15:24
 */
public class ReverseBetween {

    public static ListNode test(ListNode head,int m,int n){
        ListNode tempNode = new ListNode(-1);
        tempNode.next = head;
        ListNode firstNode = tempNode.next;
        ListNode secondNode = tempNode;
        int length=0;
        while (length<m-1){
            length++;
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        for (int i=0;i<n-m;i++){
            ListNode shouldEnd = secondNode.next;
            secondNode.next = secondNode.next.next;

            secondNode.next = firstNode.next;
            firstNode.next = shouldEnd;
        }
        return tempNode.next;
    }
}
