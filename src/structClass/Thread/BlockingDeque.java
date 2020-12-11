package structClass.Thread;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/2 20:09
 */
public class BlockingDeque<T> {


    //1.任务队列
    private Deque<T> deque = new ArrayDeque();

    //2.锁
    private ReentrantLock lock = new ReentrantLock();

    //3.生产者条件变量
    private Condition fullWaitSet = lock.newCondition();

    //4.消费者条件变量
    private Condition emptyWaitSet = lock.newCondition();

    //5.容量
    private int capcity;

    //初始化容量
    public BlockingDeque(int capcity){
        this.capcity = capcity;
    }

    //带超时的阻塞获取
    public T poll(long timeout, TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (deque.isEmpty()){
                try {
                    if(nanos < 0){
                        return null;
                    }
                    nanos = emptyWaitSet.awaitNanos(nanos);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            fullWaitSet.signal();
            return t;
        }finally {
            lock.unlock();
        }
    }

    public T take(){
        lock.lock();
        try {
            while (deque.isEmpty()){
                try {
                    emptyWaitSet.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            T t = deque.removeFirst();
            return t;
        }finally {
            lock.unlock();
        }
    }

    public void put(T task){
        lock.lock();
        try {
            while (deque.size() == capcity){
                try {
                    System.out.println("等待任务加入队列。。。");
                    fullWaitSet.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("任务加入队列");
            deque.addLast(task);
            emptyWaitSet.signal();
        }finally {
            lock.unlock();
        }
    }


    public boolean offer(T task,long timeout,TimeUnit unit){
        lock.lock();
        try {
            long nanos = unit.toNanos(timeout);
            while (deque.size() == capcity){
                try {
                    if(nanos <=0){
                        return false;
                    }
                    System.out.println("超时等待任务加入队列。。。");
                    nanos = fullWaitSet.awaitNanos(nanos);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println("任务加入队列");
            deque.addLast(task);
            emptyWaitSet.signal();
            return true;
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        lock.lock();
        try {
            return deque.size();
        }finally {
            lock.unlock();
        }
    }

    public void tryPut(RejectPolicy<T> rejectPolicy,T task){
        lock.lock();
        try {
            if(capcity == deque.size()){
                rejectPolicy.reject(this,task);
            }else {
                deque.addLast(task);
                emptyWaitSet.signal();
            }
        }finally {
            lock.unlock();
        }
    }
}

