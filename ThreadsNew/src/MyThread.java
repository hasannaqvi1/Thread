public class MyThread extends Thread{

    Display d;
    String name;

    MyThread(Display d, String name){
        this.d =d;
        this.name =name;
    }
    public void run(){
        d.wish(name);
    }

    public static void main(String[] args) {
    Display d = new Display();
    Display d2 = new Display();
    MyThread t = new MyThread(d, "Dhoni");
    MyThread t2 = new MyThread(d2, "Yuvraj");
    t.start();
    t2.start();
    }
}
