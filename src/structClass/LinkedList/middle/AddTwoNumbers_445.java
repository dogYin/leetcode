package structClass.LinkedList.middle;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Description:
 *
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 *  
 *
 * 进阶：
 *
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * 链接：https://leetcode-cn.com/problems/add-two-numbers-ii
 * @Author: jiabin.wang
 * @Date: 2020/10/19 14:42
 */
public class AddTwoNumbers_445 {


    public static ListNode addTwoNumbers(ListNode l1,ListNode l2){
        Deque<ListNode> stackA = new LinkedList<>();
        Deque<ListNode> stackB = new LinkedList<>();
        ListNode nodeA = l1;
        ListNode nodeB= l2;
        while (null != nodeA){
            stackA.push(nodeA);
            nodeA = nodeA.next;
        }
        while (null != nodeB){
            stackB.push(nodeB);
            nodeB = nodeB.next;
        }

        int carry = 0;
        ListNode res = null;
        while (!stackA.isEmpty() || !stackB.isEmpty() || carry >0){
            int sum = (stackA.isEmpty()?0:stackA.pop().val)+(stackB.isEmpty()?0:stackB.pop().val)+carry;
            ListNode curr = new ListNode(sum%10);
            carry = sum/10;
            curr.next = res;

            res = curr;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintListNode.print(
                addTwoNumbers(GenerateListNode.generate(7 ,2 ,4 ,3),GenerateListNode.generate(5 , 6 , 4)));
    }
}
