package structClass.Thread;

import structClass.util.TreeNode;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Consumer implements Runnable {

    private List container;

    public Consumer(List container){
        this.container = container;
    }

    @Override
    public void run() {
        while (true){
            synchronized (container){
                while (container.size()<=0){
                    try {
                        container.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("消费者消费了一条数据：" + container.remove(0) );
                container.notifyAll();
            }
        }
    }
}
