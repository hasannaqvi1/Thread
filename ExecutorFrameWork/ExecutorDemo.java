package ExecutorFrameWork;

import java.time.Duration;
import java.time.LocalTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        LocalTime startTime = LocalTime.now();

        PrintJob [] jobs = {
                new PrintJob("job1"),
                new PrintJob("job2"),
                new PrintJob("job3"),
                new PrintJob("job4"),
                new PrintJob("job5"),
                new PrintJob("job6")
        };
        for(PrintJob job : jobs){
            service.submit(job);
        }
        service.shutdown();
        while (!service.isTerminated()) {
            // Wait for all tasks to finish
        }

        // Capture end time
        LocalTime endTime = LocalTime.now();

        // Calculate the total time taken
        Duration timeElapsed = Duration.between(startTime, endTime);
        long seconds = timeElapsed.getSeconds();
        System.out.println("Shutting down");

        // Display total time taken
        System.out.println("Total time taken: " + seconds + " seconds");

    }
}
