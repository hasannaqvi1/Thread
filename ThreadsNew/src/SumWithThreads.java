public class SumWithThreads {

    static class SumTask extends Thread {
        private int start;
        private int end;
        private long partialSum;

        public SumTask(int start, int end) {
            this.start = start;
            this.end = end;
            this.partialSum = 0;
        }

        @Override
        public void run() {
            for (int i = start; i <= end; i++) {
                partialSum += i;
            }
        }

        public long getPartialSum() {
            return partialSum;
        }
    }

    public static void main(String[] args) {
        // Create three threads, each handling a range of 500 numbers
        SumTask thread1 = new SumTask(0, 499);
        SumTask thread2 = new SumTask(500, 999);
        SumTask thread3 = new SumTask(1000, 1499);

        // Start the threads
        thread1.start();
        thread2.start();
        thread3.start();

        try {
            // Wait for all threads to finish
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calculate the total sum by combining partial sums
        long totalSum = thread1.getPartialSum() + thread2.getPartialSum() + thread3.getPartialSum();
        System.out.println("Total sum from 0 to 1500: " + totalSum);
    }
}
