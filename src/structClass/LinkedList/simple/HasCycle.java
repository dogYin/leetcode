package structClass.LinkedList.simple;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;

/**
 * @Description:
 * 给定一个链表，判断链表中是否有环。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 *
 * 实例
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：true
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/24 16:25
 */
public class HasCycle {


    public static boolean test(ListNode head){
        if(null== head || null == head.next){
            return false;
        }
        ListNode pre = head;
        ListNode end = head;
        while (pre!=null && pre.next!=null){
            pre = pre.next.next;
            end = end.next;
            if (pre == end){
                return true;
            }
        }
        return false;
    }

}
