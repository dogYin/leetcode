package structClass.util;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/7/21 14:12
 */
public class PrintListNode {

    public static void print(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }
    }
}
