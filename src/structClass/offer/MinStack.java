package structClass.offer;

import java.util.Stack;

/**
 * @Description:
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 * 示例:
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.min();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.min();   --> 返回 -2.
 * 提示：
 * 各函数的调用总次数不超过 20000 次
 *
 * 链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
 * @Author: jiabin.wang
 * @Date: 2020/12/9 15:17
 */
public class MinStack {

    private Stack<Integer> valStack ;

    private Stack<Integer> compareStack;


    public MinStack(){
        valStack = new Stack<>();
        compareStack = new Stack<>();
    }
    public void push(int x){
        valStack.push(x);
        if(compareStack.isEmpty() || compareStack.peek() >= x){
            compareStack.push(x);
        }
    }

    public void pop(){
      if(valStack.pop().equals(compareStack.peek())){
          compareStack.pop();
      }
    }

    public int top(){
        return valStack.pop();
    }

    public int min(){
        return compareStack.pop();
    }
}
