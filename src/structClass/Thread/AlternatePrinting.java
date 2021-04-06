package structClass.Thread;

import java.util.EnumMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class AlternatePrinting {

    static volatile boolean flag = false;
    public static void main(String[] args){
//        EnumMap map = new EnumMap();
    }
    public static void method1(char[] nums,char[] chars){
        Object obj = new Object();

        new Thread(()->{
            synchronized (obj){
                for (int i = 0; i < nums.length; i+=2) {
                    System.out.print(nums[i]+""+nums[i+1]);
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        },"t1").start();

        new Thread(()->{
            synchronized (obj){
                for (int i = 0; i < chars.length; i++) {
                    System.out.print(chars[i]);
                    try {
                        obj.notify();
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        },"t2").start();

    }

    public static void method2(char[] nums,char[] chars){
        ReentrantLock lock = new ReentrantLock();
        Condition numsCondition = lock.newCondition();
        Condition charsCondition = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < nums.length; i+=2) {
                    System.out.print(nums[i]+""+nums[i+1]);
                    charsCondition.signal();
                    numsCondition.await();
                }
                charsCondition.signal();
                numsCondition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"nums").start();
        new Thread(()->{
            try {
                lock.lock();
                for (int i = 0; i < chars.length; i++) {
                    System.out.print(chars[i]);
                    numsCondition.signal();
                    charsCondition.await();
                }
                charsCondition.signal();
                numsCondition.signal();
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"chars").start();

    }

    static Thread numsTh;
    static Thread charsTh;

    public static void method3(char[] nums,char[] chars){
        numsTh = new Thread(()->{
            for (int i = 0; i < nums.length; i+=2) {
                System.out.print(nums[i]+""+nums[i+1]);
                LockSupport.unpark(charsTh);
                LockSupport.park();
            }
        },"nums");
        charsTh = new Thread(()->{
            for (int i = 0; i < chars.length; i++) {
                System.out.print(chars[i]);
                LockSupport.unpark(numsTh);
                LockSupport.park();
            }
        },"chars");
        numsTh.start();
        charsTh.start();
    }

}
class CircleThread{

    public void printThree(){

    }
}
