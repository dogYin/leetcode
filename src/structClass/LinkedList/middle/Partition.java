package structClass.LinkedList.middle;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;


/**
 * @Description:
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 *
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/23 14:49
 */
public class Partition {


    public static ListNode test(ListNode head,int x){
        if(null == head){
            return head;
        }
        ListNode temp1 = new ListNode(-1);
        ListNode temp2 = new ListNode(-2);
        ListNode curr = head;
        ListNode currTmp1 = temp1;
        ListNode currTmp2 = temp2;
        while (curr!=null){
            if(curr.val <x){
                currTmp1.next = curr;
                currTmp1 = currTmp1.next;
                if(curr.next==null){
                    currTmp2.next =null;
                }
            }else {
                currTmp2.next = curr;
                currTmp2 = currTmp2.next;
            }
            curr = curr.next;
        }
        if(currTmp1!=null){
            currTmp1.next = temp2.next;
        }
        return temp1.next;
    }

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(2,1);
        PrintListNode.print(test(node,2));

    }
}
