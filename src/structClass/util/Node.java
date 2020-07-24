package structClass.util;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/7/24 14:13
 */
public class Node {

    public int val;

    public Node random;

    public Node next;

    public Node(int val){
        this.val = val;
        this.random = null;
        this.next = null;
    }
}
