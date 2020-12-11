package structClass.Thread;

import java.util.HashSet;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/2 20:51
 */
public class ThreadPool {

    //任务队列
    private BlockingDeque<Runnable> taskQueue;

    //线程集合
    private HashSet<Worker> workers = new HashSet<>();

    //核心线程数
    private int coreSize ;

    //超时时间
    private long timeout;

    private TimeUnit unit;

    private RejectPolicy<Runnable> rejectPolicy;

    public void execute(Runnable task){
        synchronized (workers){
            if(workers.size() < coreSize){
                Worker worker = new Worker(task);
                workers.add(worker);
                worker.start();
            }else {
                taskQueue.tryPut(rejectPolicy,task);
            }
        }
    }

    public ThreadPool(int coreSize,long timeout,TimeUnit unit,int queueCapcity,RejectPolicy<Runnable> rejectPolicy){
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.unit = unit;
        this.taskQueue = new BlockingDeque<>(queueCapcity);
        this.rejectPolicy = rejectPolicy;
    }

    class Worker extends Thread{

        private Runnable task;

        public Worker(Runnable task){
            this.task = task;
        }

        @Override
        public void run() {
            while (task != null || (task = taskQueue.poll(timeout,unit))!=null) {
                try {
                    System.out.println("开始执行task");
                    task.run();
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    task = null;
                }
            }

            synchronized (workers){
                workers.remove(this);
            }
        }
    }

    public static void main(String[] args) {

//        ThreadPoolExecutor executor = new ThreadPoolExecutor();
        ForkJoinPool joinPool = new ForkJoinPool();

        ThreadPool threadPool = new ThreadPool(1,
                1000, TimeUnit.MILLISECONDS, 1, (queue, task)->{
            // 1. 死等
                // queue.put(task);
            // 2) 带超时等待
                // queue.offer(task, 1500, TimeUnit.MILLISECONDS);
            // 3) 让调用者放弃任务执行
                // log.debug("放弃{}", task);
            // 4) 让调用者抛出异常
                // throw new RuntimeException("任务执行失败 " + task);
            // 5) 让调用者自己执行任务
            task.run();
        });
        for (int i = 0; i < 4; i++) {
            int j = i;
            threadPool.execute(() -> {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(j);
            });
        }
    }

}
