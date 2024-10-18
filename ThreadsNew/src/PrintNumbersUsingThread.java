//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class PrintNumbersUsingThread implements Runnable{
    private final Object obj; // Shared object for synchronization

    PrintNumbersUsingThread(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            // Even thread block
            if (i % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (obj) {
                    try {
                        System.out.println(i + " " + Thread.currentThread().getName());
                        obj.notify(); // Notify the odd thread
                        obj.wait();   // Wait for the odd thread to proceed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            // Odd thread block
            else if (i % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (obj) {
                    try {
                        System.out.println(i + " " + Thread.currentThread().getName());
                        obj.notify(); // Notify the even thread
                        obj.wait();   // Wait for the even thread to proceed
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object(); // Shared lock object
        Runnable r = new PrintNumbersUsingThread(lock);

        Thread t1 = new Thread(r, "even");
        Thread t2 = new Thread(r, "odd");

        t1.start();
        t2.start();
    }
}
