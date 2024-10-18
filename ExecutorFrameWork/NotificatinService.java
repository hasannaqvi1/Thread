package ExecutorFrameWork;

public class NotificatinService{

    void sendMessage(String message, String receipient){
        System.out.println("Sending notification to "+receipient+" message:"+message);
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){

        }
        System.out.println("Message send to "+ receipient);
    }

}
