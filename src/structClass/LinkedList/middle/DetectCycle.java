package structClass.LinkedList.middle;

import structClass.util.ListNode;

/**
 * @Description:
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 *
 * 说明：不允许修改给定的链表。
 *
 *
 *  
 *
 * 示例 1：
 *
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *
 * 示例 2：
 *
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/24 16:51
 */
public class DetectCycle {

    public static ListNode test(ListNode head){
        if(null == head || null == head.next){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                break;
            }
        }
        while (head!=fast){
            if(fast==null){
                return null;
            }
            head = head.next;
            fast = fast.next;
        }
        return head;
    }
}
