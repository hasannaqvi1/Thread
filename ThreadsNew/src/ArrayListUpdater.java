import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ArrayListUpdater {
    private static final List<Integer> values = new ArrayList<>();
    private static final Random random = new Random();

    public static void main(String[] args) {
        // Initialize ArrayList with some sample values
        values.add(50);
        values.add(70);
        values.add(90);

        // Create a ScheduledExecutorService to run every 3 minutes
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            // Update the values with random increments/decrements
            updateValues();

            // Print the highest value
            int maxValue = values.stream().max(Integer::compare).orElse(Integer.MIN_VALUE);
            System.out.println("Highest updated value: " + maxValue);
        }, 0, 3, TimeUnit.MINUTES);
    }

    private static void updateValues() {
        for (int i = 0; i < values.size(); i++) {
            int change = random.nextInt(11) - 5; // Random value between -5 and +5
            values.set(i, values.get(i) + change);
        }
        System.out.println("Updated values: " + values);
    }
}
