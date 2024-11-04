public class ExtendThread extends Thread{

    public void start() {
        super.start();
        System.out.println("Start Method");
    }
public void run(){

        System.out.println("Child thread");

}
    public void run(int i){
        System.out.println("Args constructor");
    }

    public static void main(String[] args) {
        ExtendThread t = new ExtendThread();
        synchronized (ExtendThread.class) {
            t.start();
        }


            System.out.println("Main thread");

    }
}
