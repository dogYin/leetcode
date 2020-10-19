package structClass.Thread;

/**
 * @Description:  测试线程中的组合方法
 *
 * start  run
 *wait notify/notifyAll
 * @Author: jiabin.wang
 * @Date: 2020/10/16 14:19
 */
public class CombinationMethodTest {

    public static void main(String[] args) {

        TestRunnable runnable = new TestRunnable();
//        runnable.run(); //main：this is class:TestRunnable method:run
        new Thread(runnable).start();//Thread-0：this is class:TestRunnable method:run
    }
}
class TestRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"：this is class:TestRunnable method:run ");
    }
}
