public class ReentnetionMainThread {

    public static void main(String[] args) {
        ReentrantDisplayMethod r = new ReentrantDisplayMethod();
        ReententionThread rT = new ReententionThread("Yuvraj", r);
        ReententionThread rT2 = new ReententionThread("Dhoni", r);

        rT.start();
        rT2.start();
    }
}
