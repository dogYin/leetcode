package structClass.Thread;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/9/29 11:18
 */
public class SingletonTest {


    public static void main(String[] args) {

        new Thread(() ->{

            System.out.println(Singleton.getInstance());
        }).start();
        new Thread(() ->{
            System.out.println(Singleton.getInstance());
        }).start();

        new Thread(() ->{
            System.out.println(Singleton.getInstance());
        }).start();
        new Thread(() ->{
            System.out.println(Singleton.getInstance());
        }).start();
        new Thread(() ->{
            System.out.println(Singleton.getInstance());
        }).start();
    }

}

final class Singleton{
    private Singleton(){}

    private static  Singleton INSTANCE = null;

    public static Singleton getInstance() {

        if(INSTANCE == null){
            synchronized (Singleton.class){
                if(INSTANCE == null){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Singleton();
                }
            }
        }

        return INSTANCE;
    }
}
