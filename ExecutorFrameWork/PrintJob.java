package ExecutorFrameWork;

public class PrintJob implements Runnable{

    String name;

    public PrintJob(String name){
        this.name=name;
    }
    @Override
    public void run() {

        System.out.println(name+" job started by thread "+ Thread.currentThread().getName());
        try{
            Thread.sleep(5000);
        }
        catch (InterruptedException e){

        }
        System.out.println(name +" job finished by thread "+ Thread.currentThread().getName());

    }


}
