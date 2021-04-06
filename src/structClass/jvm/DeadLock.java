package structClass.jvm;

import structClass.util.TreeNode;

import java.util.ArrayList;

public class DeadLock {

    public static void main(String[] args) {

        Object objA = new Object();
        Object objB = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objA){
                    System.out.println("A 线程获取资源A锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objB){
                        System.out.println("do a thing");
                    }
                }
            }
        },"AThread").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (objB){
                    System.out.println("B 线程获取资源B锁");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (objA){
                        System.out.println("do b thing");
                    }
                }
            }
        },"BThread").start();
    }
}
