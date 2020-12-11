package structClass.offer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @Description:
 *
用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。
(若队列中没有元素，deleteHead 操作返回 -1 )
示例 1：
输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]
提示：

1 <= values <= 10000
最多会对 appendTail、deleteHead 进行 10000 次调用
 * @Author: jiabin.wang
 * @Date: 2020/12/9 14:45
 */
public class CQueue {
    private Stack<Integer>  pushStack;

    private Stack<Integer> popStack;
    public CQueue(){
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }
    public void appendTail(int value){
        pushStack.push(value);
    }

    public int deleteHead(){
        if(popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        if(popStack.isEmpty()){
            return -1;
        }else {
            return popStack.pop();
        }
    }

    public static void main(String[] args) {
        CQueue queue = new CQueue();
        System.out.println(queue.deleteHead());
        queue.appendTail(5);
        queue.appendTail(2);
        System.out.println(queue.deleteHead());
        System.out.println(queue.deleteHead());

    }
}
