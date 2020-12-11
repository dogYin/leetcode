package structClass.offer;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/10 17:03
 */
public class FindKthToTail {

    public static ListNode findKthToTail(ListNode head,int k){
        if(null == head) return head;
        ListNode temp = new ListNode(-1);
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;

        for (int i = 0; i < k && fast!=null; i++) {
            fast = fast.next;
        }

        if(fast==null){
            return null;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        PrintListNode.print(findKthToTail(GenerateListNode.generate(1,2,3,4,5),2));
    }
}
