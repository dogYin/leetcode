package structClass.Thread;

import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public final class Singleton {

    private static volatile Singleton INSTANCE = null;

    public static AtomicLong sequence = new AtomicLong(0);

    private static ThreadLocal<Long>  local = new ThreadLocal<>();

    private Singleton(){
        if(INSTANCE != null){
            //禁止反射创建实例
            throw new RuntimeException(" forbid  create CodeGenerator instance by reflector");
        }
        local.set(0L);
    }

    public static Singleton getInstance() {
        if(INSTANCE == null){
            synchronized (Singleton.class){
                if (INSTANCE == null){
                    INSTANCE = new Singleton();
                }
            }
        }
        return INSTANCE;
    }

    public void setSequence(){
        try {
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e) {
        }
//        sequence.incrementAndGet();
//        sequence1++;
       local.set(1L);
        try {
            Thread.sleep(new Random().nextInt(3000));
        } catch (Exception e) {
        }
        System.out.println(local.get());
//        System.out.println(sequence.get());
//        System.out.println(sequence1);
    }

}
