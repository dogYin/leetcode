package structClass;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description:
 * @Author: jiabin.wang
 * @Date: 2020/11/16 11:10
 */
public class Test {


    public static void main(String[] args) {
       /* String s1 = "hello ";  //0
        String s2 = s1 + "world"; //3-19

        String s3 = "hello world"; //23

        String s4 = "helllo " + "world";//26

        String s5 = "world";
        String s6 = s1 + s5;



        System.out.println(s2 == s3); //false
        System.out.println(s2.equals(s3)); //true

        System.out.println(s2.intern() == s3);//true
        System.out.println(s6.intern() == s4);//true*/

//        List<String> list = new ArrayList<>();
//        Collections.synchronizedList(new ArrayList<>());
//        CopyOnWriteArrayList list1 = new CopyOnWriteArrayList();
//        Collections.sort(list);
//
//        Iterator<String> iterator = list.iterator();
//
//        LinkedList linkedList = new LinkedList();
//        Deque d  = new LinkedList();
//        Queue q = new LinkedList();
//
//        Arrays.sort(list.toArray());
//
//        HashMap<String,Object> map = new HashMap<>(17);
//        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
//        TreeMap treeMap = new TreeMap();
//
//        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE-8));

//        ReentrantLock lock = new ReentrantLock();

//        System.out.println(text());
////        ThreadPoolExecutor executor = new ThreadPoolExecutor()
//        Semaphore semaphore = new Semaphore(1);
//        CountDownLatch downLatch = new CountDownLatch(1);
//        ThreadLocal local = new ThreadLocal();
//        LinkedHashMap hashMap = new LinkedHashMap();
//        synchronized (hashMap){}
        ArrayList list = new ArrayList();
        LinkedList linkedList = new LinkedList();

    }

    int a;
    volatile int v1 = 1;
    volatile int v2 = 2;

    void readAndWrite() {
        int i = v1;           // 第一个 volatile 读
        int j = v2;           // 第二个 volatile 读
        a = i + j;            // 普通写
        v1 = i + 1;          // 第一个 volatile 写
        v2 = j * 2;          // 第二个 volatile 写
    }

    public static boolean text(){
        int i = 1;
        retry:

        for(;;){
            if(i >10)
            break retry;
            i++;
        }
        System.out.println(i);
        return true;
    }




    public static synchronized void test1(){

    }


    public synchronized void test2(){
    }


    public void test3(){
        synchronized (this){

        }
    }
}
