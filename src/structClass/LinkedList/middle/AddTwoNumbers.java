package structClass.LinkedList.middle;

import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description:
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 *
 *示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/20 16:02
 */
public class AddTwoNumbers {


    public static ListNode test1(ListNode node1,ListNode node2){
        ListNode res = new ListNode(0);
        ListNode curr_1 = node1;
        ListNode curr_2 = node2;
        ListNode curr = res;
        int carry = 0;
        while (curr_1!=null || curr_2!=null){
            int val_1 = curr_1 == null ? 0:curr_1.val;
            int val_2 = curr_2 == null ? 0:curr_2.val;
            int sum = val_1 + val_2 + carry;
            if(sum > 9) {
                sum = sum % 10;
                carry = 1;
            }else {
                carry =0;
            }
            curr.next = new ListNode(sum);
            if(curr_1!=null)curr_1 = curr_1.next;
            if(curr_2!=null)curr_2 = curr_2.next;
            curr = curr.next;
        }
        if(carry > 0){
            curr.next = new ListNode(carry);
        }

        return res.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(5);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);
        node1.next.next.next = new ListNode(9);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode listNode = test1(node1, node2);
        PrintListNode.print(listNode);
    }
}
