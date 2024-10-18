package ExecutorFrameWork;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        NotificatinService notificationService = new NotificatinService();

        NotificationTask[] tasks = {
                new NotificationTask(notificationService, "New comment on your post!", "user1@example.com"),
                new NotificationTask(notificationService, "New follower!", "user2@example.com"),
                new NotificationTask(notificationService, "Your password has been changed.", "user3@example.com"),
                new NotificationTask(notificationService, "New message from admin.", "user4@example.com")};

        for(NotificationTask task : tasks){
            service.submit(task);
        }
        service.shutdown();

    }
}
