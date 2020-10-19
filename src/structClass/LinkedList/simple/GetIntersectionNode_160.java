package structClass.LinkedList.simple;

import structClass.util.GenerateListNode;
import structClass.util.ListNode;
import structClass.util.PrintListNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Description:
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * 如下面的两个链表：
 *
 *
 *
 * 在节点 c1 开始相交。
 *
 *  
 *
 * 示例 1：
 *
 *
 *
 * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * 输出：Reference of the node with value = 8
 * 输入解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 *  
 *
 * 示例 2：
 *
 *
 *
 * 输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * 输出：Reference of the node with value = 2
 * 输入解释：相交节点的值为 2 （注意，如果两个链表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。
 *  
 *
 * 示例 3：
 *
 *
 *
 * 输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * 输出：null
 * 输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
 * 解释：这两个链表不相交，因此返回 null。
 *  
 *
 * 注意：
 *
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 * 通过次数157,693提交次数277,887
 *
 * 链接：https://leetcode-cn.com/problems/intersection-of-two-linked-lists
 *
 * @Author: jiabin.wang
 * @Date: 2020/10/15 19:57
 */
public class GetIntersectionNode_160 {


    /**
     *使用栈
     *这个不是相交的
     * 废弃掉
     *
     */
    public static ListNode getIntersectionNode1(ListNode headA,ListNode headB){
        if(null == headA || null == headB){
            return null;
        }
        LinkedList<ListNode> stackA = new LinkedList<>();
        LinkedList<ListNode> stackB = new LinkedList<>();
        ListNode preA = headA;
        ListNode preB= headB;
        while (null != preA){
            stackA.addFirst(preA);
            preA = preA.next;
        }
        while (null != preB){
            stackB.addFirst(preB);
            preB = preB.next;
        }
        ListNode res  = null;
        int k = Math.min(stackA.size(), stackB.size());
        for (int i = 0;i< k;i++){
            ListNode node1 = stackA.removeFirst();
            ListNode node2 = stackB.removeFirst();
            if(node1 == node2){
                res = node1;
            }else {
                break;
            }
        }
        return res;

    }


    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(null == headA || null == headB){
            return null;
        }
        ListNode preA = headA,preB = headB;
        while (preA!=preB){
            preA = preA == null ? headB : preA.next;
            preB = preB == null ? headA : preB.next;
        }
        return preA;
    }
    public static void main(String[] args) {
        //[4,1,8,4,5]
        //[5,6,1,8,4,5]
        //2
        //3



        PrintListNode.print(
                getIntersectionNode1(
                        GenerateListNode.generate(1,2,3,4,5,6,7,8,9,10,11,12,13),
                        GenerateListNode.generate(1,2,3,4,5,6,7,8,9,10,11,12,13)));
    }
}
