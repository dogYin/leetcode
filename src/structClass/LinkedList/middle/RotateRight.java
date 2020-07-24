package structClass.LinkedList.middle;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description: 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 *  示例 1:
 *
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 *
 * 示例 2:
 *
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/22 13:53
 */
public class RotateRight {


    public static ListNode test(ListNode head , int k){
        if(k<=0 || null == head || null == head.next){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode currTemp = temp.next;
        ListNode topNode = temp.next;
        ListNode endNode = temp;
        int n;
        for (n=1;currTemp.next!=null;n++){
            currTemp = currTemp.next;
        }
        currTemp = temp.next;
        k = n > k?k:k%n;
        if(k==0){
            return head;
        }
        for (int i = 0; i <= k; i++) {
            endNode = endNode.next;

        }
        while(endNode!=null){
            if(endNode.next==null){
                temp.next = topNode.next;
                topNode.next = null;
                endNode.next = currTemp;
                break;
            }
            topNode = topNode.next;
            endNode = endNode.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode node = GenerateListNode.generate(1,2,3,4,5);
        PrintListNode.print(test(node,2));


    }
}
