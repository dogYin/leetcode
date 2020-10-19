package structClass.Thread;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * 输入: n = 1
 * 输出: "foobar"
 * 解释: 这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 *
 * @Author: jiabin.wang
 * @Date: 2020/9/28 16:37
 */
public class FooBar {

    private int n;

    public FooBar(int n) {
        this.n = n;
    }


    private volatile boolean flag = false;


    private ReentrantLock lock = new ReentrantLock();

    private Condition fooCondition = lock.newCondition();

    private Condition barCondition = lock.newCondition();

    public void foo(Runnable printFoo)  {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
                if(flag){
                    fooCondition.await();
                }
                printFoo.run();
                flag = true;
                barCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }


    public void bar(Runnable printBar) {
        try {
            lock.lock();
            for (int i = 0; i < n; i++) {
            if(!flag){
                barCondition.await();
            }
            flag = false;
            printBar.run();
            fooCondition.signal();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }



    public static int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            if(map.get(i-1)!=null && map.get(i)>0){
                return i;
            }else {
                map.put(i,1);
            }
        }
        return -1;
    }



    public static void main(String[] args) {
        System.out.println(findRepeatNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
    }
}
class FooClass implements Runnable{
    @Override
    public void run() {
        System.out.print("foo");
    }
}

class BarClass implements Runnable{
    @Override
    public void run() {
        System.out.print("bar");
    }
}