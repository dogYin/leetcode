package structClass.util;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/7/21 15:25
 */
public class GenerateListNode {

    public static ListNode generate(int... nodes){
        int length = nodes.length;
        ListNode node = new ListNode(nodes[0]);
        ListNode curr = node;
        for (int i = 1; i < length; i++) {
            curr.next = new ListNode(nodes[i]);
            curr =  curr.next;
        }
        return node;
    }
}
