public class PrintNumberInSequence implements Runnable{
    Object obj;

    public PrintNumberInSequence(Object obj){
        this.obj = obj;
    }
    @Override
    public void run() {

    }

    public static void main(String[] args) {
        Object lock = new Object();
        Runnable r = new PrintNumberInSequence(lock);
        Thread t1 = new Thread(r, "Thread 1");

    }
}
