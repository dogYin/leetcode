package structClass.LinkedList.simple;

import structClass.util.ListNode;

import java.util.List;

/**
 * @Description: 反转一个链表
 *
 * 示例:
 *
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * @Author: jiabin.wang
 * @Date: 2020/7/20 16:54
 */
public class ReverseList {


    /**
     * 双指针反转
     * @param node
     * @return
     */
    public static ListNode test(ListNode node){
       ListNode curr = node;
       ListNode pre = null;
       while (curr!=null){
           ListNode temp = curr;
           curr = curr.next;
           temp.next = pre;
           pre = temp;
       }
       return pre;
    }
}
