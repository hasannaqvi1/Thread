import java.util.concurrent.locks.ReentrantLock;

public class ReententionThread extends Thread {

    String name;
    ReentrantDisplayMethod displayMethod;
   // static ReentrantLock l = new ReentrantLock();

    ReententionThread(String name, ReentrantDisplayMethod displayMethod) {
        this.name = name;
        this.displayMethod = displayMethod;

    }

    public void run() {
      //  if (l.tryLock()) {
            displayMethod.wish(name);
  //
    }
}