public class RandomMethod {
    public void random() {
        System.out.println("The current time is " + System.currentTimeMillis());
        synchronized (RandomMethod.class) {
            for (int i = 0; i < 5; i++) {
                System.out.println("Thread name is i " + +i + " " + Thread.currentThread().getName());
            }
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {

            }
            System.out.println("total time took is " + System.currentTimeMillis());
        }
    }
}