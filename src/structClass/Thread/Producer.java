package structClass.Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public  class Producer implements Runnable{

    private List container;

    public Producer(List container){
        this.container = container;
    }


    @Override
    public void run() {
        Random random = new Random(10);
        while (true)
        {
            synchronized (container){
                while (container.size() > 0){
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
                container.add(random.nextInt(10));
                System.out.println("生产者，生产了个东西："+container.get(0));
                container.notifyAll();
            }
        }
    }
}
