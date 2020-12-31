package structClass.gc;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/12/29 17:04
 */
public class TestSystemGc {


    public static void gc1(){
        byte[] bytes = new byte[10 * 1024 * 1024];
        System.gc(); //不会gc
    }

    public static void gc2(){
        byte[] bytes = new byte[10 * 1024 * 1024];
        bytes = null;
        System.gc(); //hui回收bytes
    }
    public static void gc3(){
        {
            byte[] bytes = new byte[10 * 1024 * 1024];
        }
        System.gc(); //不会回收bytes
    }
    public static void gc4(){
        {
            byte[] bytes = new byte[10 * 1024 * 1024];
        }
        int val = 10;
        System.gc(); //会回收bytes
    }
    public static void gc5(){
        gc1();
        System.gc(); //最终回收掉bytes
    }

    public static void main(String[] args) {
        Integer i= 1;
    }
}
