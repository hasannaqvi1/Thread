import java.util.concurrent.locks.ReentrantLock;

public class ReentrantDisplayMethod {

    // Move the lock here so it's shared across both threads
    ReentrantLock l = new ReentrantLock();

    public void wish(String name) {
        l.lock(); // Acquire the lock
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Good Morning");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name);
            }
        } finally {
            l.unlock(); // Ensure lock is released in case of any exception
        }
    }
    }
