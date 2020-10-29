package structClass.LinkedList.simple;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;


/**
 * @Description:
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * 链接：https://leetcode-cn.com/problems/palindrome-linked-list
 * @Author: jiabin.wang
 * @Date: 2020/10/20 13:42
 */
public class IsPalindrome_234 {

    public static boolean isPalindrome(ListNode head){
        if(null == head || null == head.next)return false;
        ListNode mid = reveredSubNode(getMidNode(head));

        while (mid!=null){
            if(mid.val!=head.val)return false;
            mid = mid.next;
            head = head.next;
        }

        return true;
    }

    private static ListNode reveredSubNode(ListNode head){
        if(null ==head || null == head.next)return head;
        ListNode prve = null;
        ListNode curr = head;
        while(null != curr && null != curr.next){
            ListNode temp = curr;
            curr = curr.next;
            temp.next = prve;
            prve = temp;

        }
        return prve;
    }

    private static ListNode getMidNode(ListNode head){
        ListNode prve = head;
        ListNode end = head;
        while (prve!=null && prve.next!=null){
            prve = prve.next.next;
            end = end.next;
        }
        return end;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(GenerateListNode.generate(1,2)));
    }
}
