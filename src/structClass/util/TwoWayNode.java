package structClass.util;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/23 10:53
 */
public class TwoWayNode {
    public int val;
    public TwoWayNode left;
    public TwoWayNode right;

    public TwoWayNode() {}

    public TwoWayNode(int val) {
        this.val = val;
    }
    public TwoWayNode(int val,TwoWayNode left,TwoWayNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
