package ExecutorFrameWork;

public class NotificationTask implements Runnable{
    private NotificatinService service;
    private final String message;
    private final String recepient;

    public NotificationTask(NotificatinService service, String message, String recepient){
        this.service = service;
        this.message = message;
        this.recepient = recepient;
    }
    @Override
    public void run() {
        servic  e.sendMessage(message, recepient);
    }
}
