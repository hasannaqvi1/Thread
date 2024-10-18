public class PrintInSequence {
    int maxNumber;
    int counter =0;
    Object lock = new Object();

    public PrintInSequence(int maxNumber){
        this.maxNumber=maxNumber;

    }

    public void printEven(){
        while(counter<=maxNumber){
            synchronized (lock) {
                if (counter % 2 == 0) {
                    System.out.println(Thread.currentThread().getName() + " printed " + counter);
                    counter++;
                    lock.notify();
                }
                else{
                    try{
                        lock.wait();
                    }
                    catch (InterruptedException e){

                    }
                }
            }
        }
    }
    public void printOdd(){
        while(counter<maxNumber){
            synchronized (lock) {
                if (counter % 2 != 0) {
                    System.out.println(Thread.currentThread().getName() + " printed " + counter);
                    counter++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {

                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxNumber = 30;
        PrintInSequence print = new PrintInSequence(maxNumber);
        Thread evenThread = new Thread(print:: printOdd, "evenThread");
        Thread oddThread = new Thread(print:: printEven, "oddThread");
        evenThread.start();
        oddThread.start();
    }
}
