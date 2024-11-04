public class ThreadOperations extends Thread{

    RandomMethod method;

    ThreadOperations(RandomMethod method){
        this.method = method;
    }

    public void run(){
        method.random();
    }

    public static void main(String[] args) {
        RandomMethod rM = new RandomMethod();
        ThreadOperations tP = new ThreadOperations(rM);
        ThreadOperations tP1 = new ThreadOperations(rM);
        ThreadOperations tP3 = new ThreadOperations(rM);
        tP.start();
        tP1.start();
        tP3.start();
    }
}
