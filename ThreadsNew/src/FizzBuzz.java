public class FizzBuzz implements Runnable {
    private final Object lock;
    private int currentNumber = 1; // Shared counter

    public FizzBuzz(Object lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        while (currentNumber <= 40) {
            synchronized (lock) {
                if (currentNumber % 3 == 0 && currentNumber % 5 == 0 && Thread.currentThread().getName().equals("FizzBuzz")) {
                    System.out.println("FizzBuzz... Current thread is " + Thread.currentThread().getName());
                    currentNumber++;
                    lock.notifyAll();
                } else if (currentNumber % 3 == 0 && Thread.currentThread().getName().equals("Fizz")) {
                    System.out.println("Fizz... Current thread is " + Thread.currentThread().getName());
                    currentNumber++;
                    lock.notifyAll();
                } else if (currentNumber % 5 == 0 && Thread.currentThread().getName().equals("Buzz")) {
                    System.out.println("Buzz... Current thread is " + Thread.currentThread().getName());
                    currentNumber++;
                    lock.notifyAll();
                } else if (currentNumber % 3 != 0 && currentNumber % 5 != 0 && Thread.currentThread().getName().equals("Number")) {
                    System.out.println(currentNumber + " printed by " + Thread.currentThread().getName());
                    currentNumber++;
                    lock.notifyAll();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        FizzBuzz fizzBuzz = new FizzBuzz(lock);

        Thread t1 = new Thread(fizzBuzz, "Fizz");
        Thread t2 = new Thread(fizzBuzz, "Buzz");
        Thread t3 = new Thread(fizzBuzz, "FizzBuzz");
        Thread t4 = new Thread(fizzBuzz, "num");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
