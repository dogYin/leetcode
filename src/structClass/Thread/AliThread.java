package structClass.Thread;

public class AliThread {


    public static void main(String[] args) throws InterruptedException {
        System.out.println(1/4);
    }
}

class Print implements Runnable{
    private String value;

    private Thread thread;

    public Print(String value,Thread thread){
        this.value = value;
        this.thread = thread;
    }
    @Override
    public void run() {
        if(thread!=null) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.value);
    }
}
