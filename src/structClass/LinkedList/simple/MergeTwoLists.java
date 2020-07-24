package structClass.LinkedList.simple;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description: 合并两个有序链表
 *
 * 示例：
 *
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * @Author: jiabin.wang
 * @Date: 2020/7/21 14:55
 */
public class MergeTwoLists {


    public static ListNode test(ListNode l1,ListNode l2){
        if(null == l1 || null == l2){
            return null == l1? l2 : l1 ;
        }
        ListNode resNode = new ListNode(0);
        ListNode curr = resNode;
        while (l1 !=null && l2 != null){
            if(l1.val > l2.val){
                curr.next = l2;
                l2 = l2.next;
            }else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        if(l1!=null){
            curr.next = l1;
        }

        if(l2!=null){
            curr.next = l2;
        }
        return resNode.next;
    }

    public static void main(String[] args) {
        ListNode l1 = GenerateListNode.generate(1,2,4);
        ListNode l2 = GenerateListNode.generate(1,3,4);
        PrintListNode.print(test(l1,l2));
    }
}
