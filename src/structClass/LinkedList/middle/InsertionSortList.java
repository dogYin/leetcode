package structClass.LinkedList.middle;

import structClass.util.ListNode;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.UUID;

/**
 * @Description:
 * 对链表进行插入排序。
 *
 * 插入排序是迭代的，
 * 1
 * 每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 * 每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 * 重复直到所有输入数据插入完为止。
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 *
 * @Author: jiabin.wang
 * @Date: 2020/7/25 15:29
 */
public class InsertionSortList {


    /**
     * 两个指针，一个遍历表   一个找位置，找位置的指针始终停在表头
     * @param head
     * @return
     */
    public static ListNode test(ListNode head){
        if(null == head || null == head.next){
            return head;
        }
        ListNode tempNode = new ListNode(-1);
        UUID.randomUUID();
        return tempNode;
    }

    public static void main(String[] args) {
        Long now = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
        Long now_1 = new Date().getTime();
        System.out.println(now+"\n"+now_1);

    }
}
